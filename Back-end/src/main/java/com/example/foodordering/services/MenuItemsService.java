package com.example.foodordering.services;

import com.example.foodordering.entity.MenuItem;
import com.example.foodordering.entity.ResponseObject;
import com.example.foodordering.repositories.MenuItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MenuItemsService {
    @Autowired
    private MenuItemsRepository menuItemsRepository;

    public ResponseEntity<ResponseObject> addNewItem(@RequestBody MenuItem menuItem){
        List<MenuItem> isExist = menuItemsRepository.findMenuItemByName(menuItem.getName().trim());

        if(isExist.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
              new ResponseObject("false","Item is existed", "")
            );
        }
        else {

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query successfully", menuItemsRepository.save(menuItem))
            );
        }
    }
}