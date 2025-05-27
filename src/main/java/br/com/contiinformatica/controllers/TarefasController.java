package br.com.contiinformatica.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contiinformatica.dtos.TarefaRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/tarefas")
@Tag( 	name = "Controle de Tarefas",
		description = "Serviços para gerenciamento de dados de tarefas.")
public class TarefasController {
	
	@PostMapping
	@Operation (summary = "Cadastro de tarefas",
	description = "cadastra uma tarefa no sistema")
	public void post( @RequestBody @Valid TarefaRequestDto request ) {
		
		
	}
	
	@PutMapping
	@Operation (summary = "Edição de tarefas",
				description = "Atualiza uma tarefa existente no sistema")
	public void put() {}
	
	@DeleteMapping
	@Operation (summary = "Deleção de tarefas",
	description = "Deleta uma tarefa existente no sistema")
	public void delete() {}
	
	@GetMapping
	@Operation (summary = "Consulta de tarefas",
	description = "Retorna as tarefas cadastradas no sistema")
	public void get () {}
	

}
