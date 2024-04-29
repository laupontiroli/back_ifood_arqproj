package br.ifood.proj.Projeto.Ifood.grupo3.entregador.model;

import jakarta.persistence.*;

@Entity
public class Entregador {
//    criar a classe entregador dentro de um package novo 'entregador' com os dados :
//    Nome, CPF, Tipo Veículo, Preço da Viagem por KM e Status (DISPONIVEL, INDISPONIVEL).
//    Criar funções básicas

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String tipoVeiculo;
    @Column(nullable = false)
    private Float precoViagem;
    @Column(nullable = false)
    private String status;

    public Entregador(String cpf, String nome, String tipoVeiculo, Float precoViagem, String status) {
        this.cpf = cpf;
        this.nome = nome;
        this.tipoVeiculo = tipoVeiculo;
        this.precoViagem = precoViagem;
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Float getPrecoViagem() {
        return precoViagem;
    }

    public void setPrecoViagem(Float precoViagem) {
        this.precoViagem = precoViagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
