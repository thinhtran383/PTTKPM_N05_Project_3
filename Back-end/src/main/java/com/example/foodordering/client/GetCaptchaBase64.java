package com.example.foodordering.client;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetCaptchaBase64 {
    private static final String apiUrl = "https://online.mbbank.com.vn/api/retail-web-internetbankingms/getCaptchaImage";
    private static final String authorizationHeader = "Basic RU1CUkVUQUlMV0VCOlNEMjM0ZGZnMzQlI0BGR0AzNHNmc2RmNDU4NDNm";

    public void getCaptchaImage() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        // Tạo đối tượng yêu cầu HTTP
        HttpEntity<String> requestEntity = new HttpEntity<>(getRequestJson(), headers);

        try {
            // Gửi yêu cầu POST
            ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                String responseData = responseEntity.getBody();
                System.out.println("Phản hồi từ máy chủ: " + responseData);
            } else {
                System.err.println("Lỗi khi gửi yêu cầu, HTTP status code: " + responseEntity.getStatusCodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Lỗi khi gửi yêu cầu: " + e.getMessage());
        }
    }

    private String getRequestJson() {
        return "{\"refNo\": \"2023091400484893\", \"deviceIdCommon\": \"oankw8vh-mbib-0000-0000-2023090618002619\", \"sessionId\": \"\"}";
    }

}