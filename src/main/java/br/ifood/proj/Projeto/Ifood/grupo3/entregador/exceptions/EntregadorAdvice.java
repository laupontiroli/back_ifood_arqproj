package br.ifood.proj.Projeto.Ifood.grupo3.entregador.exceptions;

import br.ifood.proj.Projeto.Ifood.grupo3.entregador.common.Erro;
import br.ifood.proj.Projeto.Ifood.grupo3.entregador.exceptions.EntregadorNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class EntregadorAdvice {

    @ExceptionHandler(EntregadorNaoEncontradoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Erro timeNaoEncontradoHandler(EntregadorNaoEncontradoException e) {
        Erro erro = new Erro();
        erro.setMensagem(e.getMessage());
        erro.setData(LocalDateTime.now());
        erro.setCodigo(404);
        return erro;
    }

}
