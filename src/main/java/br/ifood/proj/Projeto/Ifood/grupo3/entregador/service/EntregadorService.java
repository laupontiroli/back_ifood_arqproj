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

    public Entregador getEntregadorDisponivel() {
        List<Entregador> entregadores = entregadorRepository.findByStatus("DISPONIVEL");
        if (entregadores.size() > 0) {
            return entregadores.get(0);
        }
        throw new EntregadorNaoEncontradoException("Entregadores disponíveis não encontrados!");
    }

    public Entregador getEntregadorCpf(String cpf) {
        Entregador entregador = entregadorRepository.findByCpf(cpf);
        if (entregador != null) {
            return entregador;
        }
        throw new EntregadorNaoEncontradoException("Entregador " + cpf + " não encontrado!");
    }

    public void deletarEntregador(String cpf) {
        Entregador entregador = entregadorRepository.findByCpf(cpf);

        if (entregador != null) {
            entregadorRepository.delete(entregador);
        }

        else {
            throw new EntregadorNaoEncontradoException("Entregador " + cpf + " não encontrado!");
        }
    }

    public Entregador editarEntregador(String cpf, EditarEntregadorDTO editarEntregadorDTO) {
        Entregador entregador = entregadorRepository.findByCpf(cpf);

        if (entregador != null) {

            if (editarEntregadorDTO.getTipoVeiculo() != null) {
                entregador.setTipoVeiculo(editarEntregadorDTO.getTipoVeiculo());
            }
            if (editarEntregadorDTO.getPrecoViagem() != null) {
                entregador.setPrecoViagem(editarEntregadorDTO.getPrecoViagem());
            }
            if (editarEntregadorDTO.getStatus() != null) {
                entregador.setStatus(editarEntregadorDTO.getStatus());
            }
            return entregadorRepository.save(entregador);
        }

        else {
            throw new EntregadorNaoEncontradoException("Entregador " + cpf + " não encontrado!");
        }
    }

    public Entregador liberarEntregador(String cpf) {
        Entregador entregador = entregadorRepository.findByCpf(cpf);

        if (entregador != null) {
            entregador.setStatus("DISPONIVEL");
            return entregadorRepository.save(entregador);
        }

        else {
            throw new EntregadorNaoEncontradoException("Entregador " + cpf + " não encontrado!");
        }
    }






}
