package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.entity.Cliente;

@Repository
public interface LancamentoRepository extends JpaRepository <Cliente,Long> {

}
