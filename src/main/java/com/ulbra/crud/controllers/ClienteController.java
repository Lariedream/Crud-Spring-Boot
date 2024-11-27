package com.ulbra.crud.controllers;
import com.ulbra.crud.dtos.ClienteDto;
import com.ulbra.crud.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteDto createCliente(@RequestBody ClienteDto bodyRequest) {
        return clienteService.createCliente(bodyRequest);
    }

    @GetMapping
    public List<ClienteDto> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ClienteDto getClienteById(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }

    @PutMapping("/{id}")
    public ClienteDto atualizar(@PathVariable Long id, @RequestBody ClienteDto clienteAtualizado) {
        return clienteService.updateCliente(id, clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }
}
