package br.ifood.proj.Projeto.Ifood.grupo3.entregador.DTO;

public class EditarEntregadorDTO {
    private String tipoVeiculo;
    private Float precoViagem;
    private String status;

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
