package br.com.contiinformatica.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.contiinformatica.dtos.TarefaRequestDto;
import br.com.contiinformatica.dtos.TarefaRespondeDto;
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
	@Autowired 
	ModelMapper mapper;
	
	@PostMapping
	@Operation (summary = "Cadastro de tarefas",
	description = "cadastra uma tarefa no sistema")
	public TarefaRespondeDto post( @RequestBody @Valid TarefaRequestDto request ) {
		//Buscar a categoria no banco de dados através do ID
		
		var categoria = categoriaRepository.findById(request.getCategoriaId())
				.orElseThrow(() -> new IllegalArgumentException 
						("Categoria não encontrada. Verifique o ID informado"));
				
	
		//copiando os dados do objeto request para a entidade tarefa
		var tarefa = mapper.map(request, Tarefa.class);
		tarefa.setId(UUID.randomUUID()); 
		tarefa.setCategoria(categoria);
		tarefaRepository.save(tarefa);
		
		//retornar os dados da tarefa cadastrada
		return mapper.map(tarefa, TarefaRespondeDto.class);
		
		
	}
	
	@PutMapping("{id}")
	@Operation (summary = "Edição de tarefas",
				description = "Atualiza uma tarefa existente no sistema")
	public TarefaRespondeDto put(@PathVariable UUID id, @RequestBody @Valid TarefaRequestDto request) {
		
		if(!tarefaRepository.existsById(id))
			throw new IllegalArgumentException("Tarefa não encontrada. Verifique o ID");
		
		var categoria = categoriaRepository.findById(request.getCategoriaId())
				.orElseThrow(() -> new IllegalArgumentException 
						("Categoria não encontrada. Verifique o ID informado"));
		//copiando os dados do objeto request para a entidade tarefa
				var tarefa = mapper.map(request, Tarefa.class);
				tarefa.setId(UUID.randomUUID()); 
				tarefa.setCategoria(categoria);
				tarefaRepository.save(tarefa);
				
				//retornar os dados da tarefa cadastrada
				return mapper.map(tarefa, TarefaRespondeDto.class);
	}
	
	@DeleteMapping
	@Operation (summary = "Deleção de tarefas",
				description = "Deleta uma tarefa existente no sistema")
	public TarefaRespondeDto delete(@PathVariable UUID id) {
		
		var tarefa = tarefaRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Tarefa não encontrada"));
		
		tarefaRepository.delete(tarefa);
		
		return mapper.map(tarefa, TarefaRespondeDto.class);
	}
	
	@GetMapping
	@Operation (summary = "Consulta de tarefas",
	description = "Retorna as tarefas cadastradas no sistema")
	public List<TarefaRespondeDto> get () {
		
		//consultar as categorias cadastradas no banco de dados
				var tarefas = tarefaRepository.findAll();
				
				//copiando os dados de uma lista de categorias para uma lista da classe dto
				return tarefas
					.stream() 
					.map(tarefa -> mapper.map(tarefa, TarefaRespondeDto.class))
					.collect(Collectors.toList());
				
				
	}
	
	@GetMapping("/{dataInicio}/{dataFim}")
	@Operation(summary = "Consulta tarefas por período",
	           description = "Retorna as tarefas cadastradas entre duas datas.")
	public List<TarefaRespondeDto> getPorPeriodo(
	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataInicio,
	    @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataFim
	) {
	    var tarefas = tarefaRepository.findByDataHoraBetween(dataInicio, dataFim);
	    
	    return tarefas
	        .stream()
	        .map(tarefa -> mapper.map(tarefa, TarefaRespondeDto.class))
	        .collect(Collectors.toList());
	}
	

}
