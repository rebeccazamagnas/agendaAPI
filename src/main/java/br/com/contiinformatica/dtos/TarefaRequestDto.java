package br.com.contiinformatica.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TarefaRequestDto {
	
	@Size(min = 8, max= 100, message = "O Titulo deve ter entre 8 e 100 caracteres")
	@NotEmpty(message = "Campo obrigatório")
	private String titulo;

	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", 
			message = "A data deve estar no formato AAA-MM-DD")
					
					
	@NotEmpty(message = "Campo obrigatório")
	private String data;
	
	@Pattern(regexp = "^\\d{2}:\\d{2}$", 
			message = "A hora deve estar no formato HH:MM")
			
	@NotEmpty(message = "Campo obrigatório")
	private String hora;
	
	@NotNull(message = "Informe se a tarefa esta finalizada")
	private Boolean finalizado;
	
	@NotNull(message = "Informe a categoria")
	private UUID categoriaId;
	
	
	public String getTitulo() {
		return titulo;
	}
	public String getData() {
		return data;
	}
	public String getHora() {
		return hora;
	}
	public Boolean getFinalizado() {
		return finalizado;
	}
	public UUID getCategoriaId() {
		return categoriaId;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	public void setCategoriaId(UUID categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	
	
	
}
