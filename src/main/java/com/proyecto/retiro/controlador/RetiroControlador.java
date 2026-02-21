package com.proyecto.retiro.controlador;

import com.proyecto.retiro.modelo.Retiro;
import com.proyecto.retiro.repositorio.RetiroRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/retiros")
public class RetiroControlador {
    private final RetiroRepositorio repo;

    public RetiroControlador(RetiroRepositorio repo) {
        this.repo = repo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("resources", repo.findAll());
        return "retiros/retiros-lista";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("resource", new Retiro());
        return "retiros/retiros-formulario";
    }

    @PostMapping
    public String create(@ModelAttribute Retiro resource) {
        if (resource.getAvailable() == null) {
            resource.setAvailable(false);
        }
        repo.save(resource);
        return "redirect:/retiros";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Retiro resource = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("resource", resource);
        return "retiros/retiros-formulario";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Retiro resource) {
        resource.setId(id);
        if (resource.getAvailable() == null) {
            resource.setAvailable(false);
        }
        repo.save(resource);
        return "redirect:/retiros";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/retiros";
    }
}