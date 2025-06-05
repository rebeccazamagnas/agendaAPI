package br.com.contiinformatica.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.contiinformatica.entities.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository <Tarefa, UUID> {
	
	List<Tarefa> findByDataHoraBetween(Date dataInicio, Date dataFim);

}
