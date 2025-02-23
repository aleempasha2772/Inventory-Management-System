package com.example.order_service.Service;

import com.example.order_service.Model.Oorder;
import com.example.order_service.Repository.OorderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OorderService {

    @Autowired
    private OorderRepository oorderRepository;

    public Oorder SaveOrder(Oorder oorder) {
        return oorderRepository.save(oorder);
    }

    public List<Oorder> GetAllOrders(){
        return oorderRepository.findAll();
    }
}
