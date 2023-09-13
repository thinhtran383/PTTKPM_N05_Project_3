package com.example.foodordering.services;

import com.example.foodordering.constant.TableStatus;
import com.example.foodordering.entity.Table;
import com.example.foodordering.repositories.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {
    @Autowired
    private TableRepository tableRepository;



    public List<Table> getAllAvailableTables(@RequestParam(value = "filterByStatus", required = false) TableStatus tableStatus){
        if(tableStatus == null){
            return tableRepository.findAll();
        } else return tableRepository.findAllTableByStatus(tableStatus);
    }

    public void changeStatusTable(Long tableId){
        Table foundTable = tableRepository.findTableById(tableId);
        foundTable.setStatus(TableStatus.NotAvailable);
        tableRepository.save(foundTable);
    }
}
