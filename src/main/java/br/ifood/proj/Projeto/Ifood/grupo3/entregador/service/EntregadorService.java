package br.ifood.proj.Projeto.Ifood.grupo3.entregador.service;

import br.ifood.proj.Projeto.Ifood.grupo3.entregador.model.Entregador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    public Entregador cadastrarEntregador(Entregador entregador) {
        if (entregador.getNome().equals("")) {
            return null;
        } else {
            return entregadorRepository.save(entregador);
        }
    }

    public List<Entregador> listarEntregadores() {

        return entregadorRepository.findAll();
    }

    public Entregador getEntregadorDisponivel(String status) {
        List<Entregador> entregadores = entregadorRepository.findByStatus(status);
        if (entregadores.size() > 0) {
            return entregadores.get(0);
        }
        throw new RuntimeException("Entregador não encontrado");
    }

    public void deletarEntregador(String cpf) {
        Entregador entregador = entregadorRepository.findByCpf(cpf);

        if (entregador != null) {
            entregadorRepository.delete(entregador);
            throw new RuntimeException("Entregador deletado com sucesso!");
        }

        else {
            throw new RuntimeException("Entregador não encontrado!");
        }
    }




}
