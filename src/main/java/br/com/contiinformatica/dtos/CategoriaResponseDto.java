package br.com.contiinformatica.dtos;

import java.util.UUID;

public class CategoriaResponseDto {
	
	private UUID id;
	private String nome;
	
	
	public UUID getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	
	

}
