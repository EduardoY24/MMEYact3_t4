package com.eymm.spring.mmeyact3_t4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eymm.spring.mmeyact3_t4.models.Videojuego;
import com.eymm.spring.mmeyact3_t4.repository.VideojuegoRepository;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepository repo;

    public List<Videojuego> listar() {
        return repo.findAll();
    }

    public Videojuego buscar(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void guardar(Videojuego videojuego) {
        repo.save(videojuego);
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
