package com.example.foodordering.controller;

import com.example.foodordering.repositories.MenuItemsRepository;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(path = "")
public class LocalController {

    @Autowired
    private MenuItemsRepository menuItemsRepository;
    @Value("${image.upload.path}")
    private String imageUploadPath;

//    @GetMapping("")
//    public ResponseEntity<Resource> getImage() throws MalformedURLException {
//        Path imagePath = Paths.get(imageUploadPath);
//
//        Resource resource = new UrlResource(imagePath.toUri() + "/" + menuItemsRepository.findAllImageUrl(11L));
//        if (resource.exists() && resource.isReadable()) {
//            return ResponseEntity.ok()
//                    .contentType(MediaType.IMAGE_JPEG) // Định dạng của ảnh
//                    .body(resource);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }



    @GetMapping("")
    public String helloF(){
        return "Say hello";
    }


}
