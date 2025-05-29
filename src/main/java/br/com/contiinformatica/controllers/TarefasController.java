package br.com.contiinformatica.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contiinformatica.dtos.TarefaRequestDto;
import br.com.contiinformatica.entities.Tarefa;
import br.com.contiinformatica.repositories.CategoriaRepository;
import br.com.contiinformatica.repositories.TarefaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/tarefas")
@Tag( 	name = "Controle de Tarefas",
		description = "Serviços para gerenciamento de dados de tarefas.")
public class TarefasController {
	
	//Instanciando atributos de forma automatica
	
	@Autowired 
	TarefaRepository tarefaRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostMapping
	@Operation (summary = "Cadastro de tarefas",
	description = "cadastra uma tarefa no sistema")
	public void post( @RequestBody @Valid TarefaRequestDto request ) {
		//Buscar a categoria no banco de dados através do ID
		
		var categoria = categoriaRepository.findById(request.getCategoriaId())
				.orElseThrow(() -> new IllegalArgumentException 
						("Categoria não encontrada. Verifique o ID informado"));
				
		//Instanciando a classe do ModelMapper
		var mapper = new ModelMapper();
		
		//copiando os dados do objeto request para a entidade tarefa
		var tarefa = mapper.map(request, Tarefa.class);
		
		
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
