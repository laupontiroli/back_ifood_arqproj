package br.ifood.proj.Projeto.Ifood.grupo3.entregador.controller;

import br.ifood.proj.Projeto.Ifood.grupo3.entregador.DTO.EditarEntregadorDTO;
import br.ifood.proj.Projeto.Ifood.grupo3.entregador.model.Entregador;
import br.ifood.proj.Projeto.Ifood.grupo3.entregador.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @PostMapping("/entregador")
    public Entregador salvarEntregador(@RequestBody Entregador entregador) {
        return entregadorService.cadastrarEntregador(entregador);
    }

    @GetMapping("/entregador")
    public List<Entregador> getEntregador() {
        return entregadorService.listarEntregadores();
    }

    @GetMapping("/entregador/disponivel")
    public Entregador getEntregadorStatus() {
        return entregadorService.getEntregadorDisponivel();
    }

    @GetMapping("/entregador/d{cpf}")
    public Entregador getEntregadorPorCpf(@PathVariable String cpf) {
        return entregadorService.getEntregadorCpf(cpf);
    }

    @DeleteMapping("/entregador/{cpf}")
    public void deleteEntregador(@PathVariable String cpf) {
        entregadorService.deletarEntregador(cpf);
    }

    @PostMapping("/entregador/{cpf}")
    public Entregador editarEntregador(@PathVariable String cpf, @RequestBody EditarEntregadorDTO entregador) {
        return entregadorService.editarEntregador(cpf, entregador);
    }









}
