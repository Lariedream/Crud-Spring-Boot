package com.ulbra.crud.dtos;

import com.ulbra.crud.entities.Carro;

public class CarroDto {

    private String marca;
    private String cor;
    private String modelo;

    public CarroDto() {}

    public CarroDto(String marca, String cor, String modelo) {
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    // Convertendo DTO para Entidade
    public Carro toEntity(){
        return new Carro(this.cor, this.marca, this.modelo);
    }

    // Convertendo Entidade para DTO
    public static  CarroDto fromEntity(Carro carro){
        return new CarroDto(carro.getMarca(), carro.getCor(), carro.getModelo());
    }
}
