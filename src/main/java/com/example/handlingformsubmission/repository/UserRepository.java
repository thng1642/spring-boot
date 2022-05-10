package com.example.handlingformsubmission.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.handlingformsubmission.models.DetailUser;

import com.example.handlingformsubmission.models.DetailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<DetailUser, String> {

    @Query(value = "SELECT password FROM author_user u WHERE u.acount = ?1", 
    nativeQuery = true)
    String findPassword(String username);

//    @Modifying
//    @Transactional
//    @Query(value = "insert into users values (?1, ?2)",
//    nativeQuery = true)
//    void save(String email, String pass, String firstname, String lastname, String verify);
}
