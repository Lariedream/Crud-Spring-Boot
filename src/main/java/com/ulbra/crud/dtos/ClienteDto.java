package com.ulbra.crud.dtos;

import com.ulbra.crud.entities.Cliente;

public class ClienteDto {

    private String nome;
    private int idade;
    private String email;

    public ClienteDto() {}

    public ClienteDto(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // Convertendo DTO para Entidade
    public Cliente toEntity() {
        return new Cliente(this.nome, this.idade, this.email);
    }

    // Convertendo Entidade para DTO
    public static ClienteDto fromEntity(Cliente cliente) {
        return new ClienteDto(cliente.getNome(), cliente.getIdade(), cliente.getEmail());
    }
}
