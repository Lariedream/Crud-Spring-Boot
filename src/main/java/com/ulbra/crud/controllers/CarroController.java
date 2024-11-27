package com.ulbra.crud.controllers;
import com.ulbra.crud.dtos.CarroDto;
import com.ulbra.crud.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;

    @Autowired
    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public CarroDto createCarro(@RequestBody CarroDto bodyRequest) {
        return this.carroService.createCarro(bodyRequest);
    }

    @GetMapping
    public List<CarroDto> getAllCarros() {
        return carroService.getAllCarros();
    }

    @GetMapping("/{id}")
    public CarroDto getCarroById(@PathVariable Long id) {
        return carroService.getCarroById(id);
    }

    @PutMapping("/{id}")
    public CarroDto atualizar(@PathVariable Long id, @RequestBody CarroDto carroAtualizado) {
        return carroService.updateCarro(id, carroAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        carroService.deletar(id);
    }
}
