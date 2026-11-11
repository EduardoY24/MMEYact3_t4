package com.eymm.spring.mmeyact3_t4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eymm.spring.mmeyact3_t4.models.Plataforma;
import com.eymm.spring.mmeyact3_t4.repository.PlataformaRepository;

@Service
public class PlataformaService {

    @Autowired
    private PlataformaRepository repo;

    public List<Plataforma> listar() {
        return repo.findAll();
    }
}