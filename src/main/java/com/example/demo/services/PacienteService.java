package com.example.demo.services;

import com.example.demo.dtos.PacienteDTO;
import com.example.demo.entities.Paciente;
import com.example.demo.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;


    public List<PacienteDTO> findAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(x -> new PacienteDTO(x)).toList();
    }

}
