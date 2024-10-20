package com.vw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vw.model.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, String> {

}
