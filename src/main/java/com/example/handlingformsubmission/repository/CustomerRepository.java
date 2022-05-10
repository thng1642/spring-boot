package com.example.handlingformsubmission.repository;

import com.example.handlingformsubmission.models.Customer;

import com.example.handlingformsubmission.models.DetailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

//public interface CustomerRepository  extends JpaRepository<DetailUser, String> {
//
//    //To perform an insert operation, we have to both apply @Modifying and use a native query since INSERT is not a part of the JPA interface:
//
//    //insert into customers values (:email, :fullname);
//    @Modifying
//    @Transactional
//    @Query(value = "insert into customers values (?1, ?2, ?3)", nativeQuery = true)
//    void insertCustomer(String email, String fullname, String pass);
//
//}
