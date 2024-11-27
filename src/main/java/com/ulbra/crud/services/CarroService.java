package com.ulbra.crud.services;
import com.ulbra.crud.dtos.CarroDto;
import com.ulbra.crud.entities.Carro;
import com.ulbra.crud.repositories.CarroRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Table(name = "db_carros")
public class CarroService {

    private final CarroRepository carroRepository;

    @Autowired
    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public CarroDto createCarro(CarroDto carroDto) {
        Carro carro = carroDto.toEntity();
        Carro carroSalvo = carroRepository.save(carro);
        return CarroDto.fromEntity(carroSalvo);
    }

    public List<CarroDto> getAllCarros() {
        List<Carro> carros = (List<Carro>) carroRepository.findAll();
        return carros.stream()
                .map(CarroDto::fromEntity)
                .collect(Collectors.toList());
    }

    public CarroDto getCarroById(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
        return CarroDto.fromEntity(carro);
    }

    public CarroDto updateCarro(Long id, CarroDto carroAtualizado) {
        Carro carroExistente = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
        carroExistente.setMarca(carroAtualizado.getMarca());
        carroExistente.setCor(carroAtualizado.getCor());
        carroExistente.setModelo(carroAtualizado.getModelo());

        Carro carroAtaulizadoSalvo = carroRepository.save(carroExistente);
        return CarroDto.fromEntity(carroAtaulizadoSalvo);
    }

    public void deletar(Long id) {
        carroRepository.deleteById(id);
    }
}
