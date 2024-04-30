package br.ifood.proj.Projeto.Ifood.grupo3.entregador.repository;

import br.ifood.proj.Projeto.Ifood.grupo3.entregador.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Integer> {

    public List<Entregador> findByStatus(String status);

    public Entregador findByCpf(String cpf);


}
