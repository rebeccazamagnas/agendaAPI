package br.com.contiinformatica.dtos;

import java.util.UUID;

public class TarefaRespondeDto {

	private UUID id;
	private String titulo;
	private String data;
	private String hora;
	private Boolean finalizado;
	private CategoriaResponseDto categoria;
	
	public UUID getId() {
		return id;
	}
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
	public CategoriaResponseDto getCategoria() {
		return categoria;
	}
	public void setId(UUID id) {
		this.id = id;
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
	public void setCategoria(CategoriaResponseDto categoria) {
		this.categoria = categoria;
	}
	
	
}
