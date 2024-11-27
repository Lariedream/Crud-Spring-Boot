package com.ulbra.crud.services;
import com.ulbra.crud.dtos.ClienteDto;
import com.ulbra.crud.entities.Cliente;
import com.ulbra.crud.repositories.ClienteRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Table(name = "db_clientes")
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDto createCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteDto.toEntity();
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ClienteDto.fromEntity(clienteSalvo);
    }

    public List<ClienteDto> getAllClientes() {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        return clientes.stream()
                .map(ClienteDto::fromEntity) // Converte cada Cliente para ClienteDto
                .collect(Collectors.toList());
    }

    public ClienteDto getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return ClienteDto.fromEntity(cliente);
    }

    public ClienteDto updateCliente(Long id, ClienteDto clienteAtualizado) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setIdade(clienteAtualizado.getIdade());
        clienteExistente.setEmail(clienteAtualizado.getEmail());

        Cliente clienteAtualizadoSalvo = clienteRepository.save(clienteExistente);
        return ClienteDto.fromEntity(clienteAtualizadoSalvo);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
