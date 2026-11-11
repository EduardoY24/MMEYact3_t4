package com.eymm.spring.mmeyact3_t4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eymm.spring.mmeyact3_t4.models.Videojuego;
import com.eymm.spring.mmeyact3_t4.service.PlataformaService;
import com.eymm.spring.mmeyact3_t4.service.VideojuegoService;

@Controller
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @Autowired
    private PlataformaService plataformaService;

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("videojuegos", videojuegoService.listar());
        return "index";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        model.addAttribute("plataformas", plataformaService.listar());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Videojuego videojuego) {
        videojuegoService.guardar(videojuego);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("videojuego", videojuegoService.buscar(id));
        model.addAttribute("plataformas", plataformaService.listar());
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        videojuegoService.eliminar(id);
        return "redirect:/";
    }
}