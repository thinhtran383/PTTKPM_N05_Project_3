package com.example.foodordering.controller.payment;


import com.example.foodordering.DTO.BankAccountDTO;
import com.example.foodordering.DTO.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

import com.example.foodordering.client.GetCaptchaBase64;

@RestController
@RequestMapping("/api/payment")
public class DoLoginController {

    @Autowired
    private GetCaptchaBase64 getCaptchaBase64;

    @GetMapping("/getCaptcha")
    public ResponseEntity<?> getCaptchaImage() {
        String base64Image = getCaptchaBase64.getCaptchaImage();
        try {
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new ResponseObject("false","Cannot get captcha", "")
            );
        }
    }

    @PostMapping("/doLogin")
    public ResponseEntity<ResponseObject> doLogin(@RequestBody BankAccountDTO bankAccount){

        return null;
    }
}
