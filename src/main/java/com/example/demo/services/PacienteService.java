package com.example.demo.services;

import com.example.demo.dtos.PacienteDTO;
import com.example.demo.entities.Paciente;
import com.example.demo.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Transactional(readOnly = true)
    public List<PacienteDTO> findAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream().map(PacienteDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PacienteDTO findById(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        paciente.orElseThrow(() -> new NoSuchElementException("Id not found"));
        return new PacienteDTO(paciente.get());
    }

    @Transactional
    public PacienteDTO save(PacienteDTO pacienteDTO) {
        Paciente save = getPaciente(pacienteDTO);
        return new PacienteDTO(save);

    }

    private Paciente getPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setName(pacienteDTO.getName());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setRg(pacienteDTO.getRg());
        return pacienteRepository.save(paciente);
    }


}
