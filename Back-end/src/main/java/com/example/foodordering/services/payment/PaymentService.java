package com.example.foodordering.services.payment;

import com.example.foodordering.client.MbBank.TransactionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private TransactionHistory transactionHistory;

    public boolean TrackingSuccess(String sessionId, float credit, String content){
        while(true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(content);
            if (transactionHistory.callApi(sessionId,credit,content)){
                break;
            }
        }
        return true;
    }
}
