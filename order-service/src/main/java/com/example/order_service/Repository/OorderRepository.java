package com.example.order_service.Repository;

import com.example.order_service.Model.Oorder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OorderRepository extends JpaRepository<Oorder, Integer> {

}
