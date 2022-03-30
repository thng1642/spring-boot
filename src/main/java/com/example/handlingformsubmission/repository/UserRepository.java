package com.example.handlingformsubmission.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.handlingformsubmission.models.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<Account, String> {

    @Query(value = "SELECT password FROM author_user u WHERE u.acount = ?1", 
    nativeQuery = true)
    String findPassword(String username);

    @Modifying
    @Transactional
    @Query(value = "insert into author_user values (?1, ?2)", 
    nativeQuery = true)
    void insertAccount(String email, String pass);
}
