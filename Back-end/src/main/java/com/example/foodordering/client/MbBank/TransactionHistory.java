package com.example.foodordering.client.MbBank;

import com.example.foodordering.DTO.TransactionDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Handler;

@Component
public class TransactionHistory {
    private static final String authorizationHeader = "Basic RU1CUkVUQUlMV0VCOlNEMjM0ZGZnMzQlI0BGR0AzNHNmc2RmNDU4NDNm";
    private static final String apiUrl = "https://online.mbbank.com.vn/api/retail-web-transactionservice/transaction/getTransactionAccountHistory";


    RestTemplate restTemplate = new RestTemplate();

    public List<TransactionDTO> callApi(String sessionId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(getRequestJson(sessionId),headers);

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                String responseData = responseEntity.getBody();

                ObjectMapper objectMapper = new ObjectMapper();

                JsonNode rootNode = objectMapper.readTree(responseData);
                JsonNode transactionList = rootNode.get("transactionHistoryList");

                List<TransactionDTO> result = new ArrayList<>();

                if (transactionList.isArray()) {
                    for (JsonNode transactionNode : transactionList) {
                        LocalDateTime transactionDate = LocalDateTime.parse(transactionNode.get("transactionDate").asText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                        float creditAmount = Float.parseFloat(transactionNode.get("creditAmount").asText());
                        String description = transactionNode.get("description").asText();

                        TransactionDTO transactionDTO = new TransactionDTO(transactionDate, creditAmount, description);
                        result.add(transactionDTO);
                    }
                }

                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Err: " + e.getMessage());
        }
        return Collections.emptyList(); // Trả về danh sách trống nếu có lỗi
    }

    public Boolean callApi(String sessionId, float credit, String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(getRequestJson(sessionId),headers);

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                String responseData = responseEntity.getBody();

                ObjectMapper objectMapper = new ObjectMapper();

                JsonNode rootNode = objectMapper.readTree(responseData);
                JsonNode transactionList = rootNode.get("transactionHistoryList");

                List<TransactionDTO> result = new ArrayList<>();

                if (transactionList.isArray()) {
                    for (JsonNode transactionNode : transactionList) {
                        LocalDateTime transactionDate = LocalDateTime.parse(transactionNode.get("transactionDate").asText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                        float creditAmount = Float.parseFloat(transactionNode.get("creditAmount").asText());
                        String description = transactionNode.get("description").asText().substring("CUSTOMER ".length(), "CUSTOMER ".length() + 5);
                        System.out.println(description);
                        if(creditAmount == credit){
                            TransactionDTO transactionDTO = new TransactionDTO(transactionDate, creditAmount, description);
                            result.add(transactionDTO);
                        }

                    }
                }

                if(!result.isEmpty()) return true;

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Err: " + e.getMessage());
        }
        return false;
    }

    public String getRequestJson(String sessionId){
        return "{\"accountNo\":\"0857723969\",\"fromDate\":\"25/09/2023\",\"toDate\":\"25/09/2023\",\"sessionId\": \""+ sessionId +"\",\"refNo\": \"VANANHLU-2023091607010697\", \"deviceIdCommon\": \"oankw8vh-mbib-0000-0000-2023090618002619\" }";
    }
}
