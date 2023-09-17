package com.example.foodordering.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


@AllArgsConstructor
public class ApiCallTemplate {
    private static final String authorizationHeader = "Basic RU1CUkVUQUlMV0VCOlNEMjM0ZGZnMzQlI0BGR0AzNHNmc2RmNDU4NDNm";

    @NonNull
    private final RestTemplate restTemplate;
    @NonNull
    private final String apiUrl;
    @NonNull
    private final String requestJson;

    public String callApi(String field, HttpMethod httpMethod){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestJson,headers);

        try{
            ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, httpMethod, requestEntity, String.class);
            if(responseEntity.getStatusCode() == HttpStatus.OK){
                String responseData = responseEntity.getBody();
                System.out.println(responseData);

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(responseData);
                String result = rootNode.get(field).asText();
                return result;
            }

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Err: " + e.getMessage());
        }
        return null;
    }

}
