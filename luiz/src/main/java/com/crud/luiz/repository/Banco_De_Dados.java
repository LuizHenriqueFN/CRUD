package com.crud.luiz.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crud.luiz.model.Dados;


@Repository
public interface Banco_De_Dados extends CrudRepository<Dados, Integer> {

    List<Dados> findAll();

    Dados findByid(int id);
}
