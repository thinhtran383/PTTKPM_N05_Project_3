package com.example.foodordering.controller.WebController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "")
public class LocalController {


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
        return "Say hello with my team :)";
    }


}
