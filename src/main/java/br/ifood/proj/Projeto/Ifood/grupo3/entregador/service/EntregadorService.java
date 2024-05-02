package br.ifood.proj.Projeto.Ifood.grupo3.entregador.service;

import br.ifood.proj.Projeto.Ifood.grupo3.entregador.DTO.EditarEntregadorDTO;
import br.ifood.proj.Projeto.Ifood.grupo3.entregador.exceptions.EntregadorNaoEncontradoException;
import br.ifood.proj.Projeto.Ifood.grupo3.entregador.model.Entregador;
import br.ifood.proj.Projeto.Ifood.grupo3.entregador.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        throw new EntregadorNaoEncontradoException("Entregadores " + status + " não encontrados!");
    }

    public void deletarEntregador(String cpf) {
        Entregador entregador = entregadorRepository.findByCpf(cpf);

        if (entregador != null) {
            entregadorRepository.delete(entregador);
            throw new RuntimeException("Entregador deletado com sucesso!");
        }

        else {
            throw new EntregadorNaoEncontradoException("Entregador " + cpf + " não encontrado!");
        }
    }

    public Entregador editarEntregador(String cpf, EditarEntregadorDTO editarEntregadorDTO) {
        Entregador entregador = entregadorRepository.findByCpf(cpf);

        if (entregador != null) {
            entregador.setTipoVeiculo(editarEntregadorDTO.getTipoVeiculo());
            entregador.setPrecoViagem(editarEntregadorDTO.getPrecoViagem());
            entregador.setStatus(editarEntregadorDTO.getStatus());
            return entregadorRepository.save(entregador);
        }

        else {
            throw new EntregadorNaoEncontradoException("Entregador " + cpf + " não encontrado!");
        }
    }






}
