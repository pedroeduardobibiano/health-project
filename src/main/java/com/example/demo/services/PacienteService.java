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
        Paciente paciente = getId(id);
        return new PacienteDTO(paciente);
    }

    @Transactional
    public PacienteDTO save(PacienteDTO pacienteDTO) {
        Paciente save = getPaciente(new Paciente(), pacienteDTO);
        return new PacienteDTO(save);

    }


    @Transactional
    public PacienteDTO update(Long id, PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteRepository.getReferenceById(id);
        return new PacienteDTO(getPaciente(paciente, pacienteDTO));

    }

    @Transactional
    public PacienteDTO deleteById(Long id) {
        Paciente paciente = getId(id);
        pacienteRepository.delete(paciente);
        return new PacienteDTO(paciente);
    }

    @Transactional
    public Paciente getId(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.orElseThrow(() -> new NoSuchElementException("Id not found"));
    }


    private Paciente getPaciente(Paciente paciente, PacienteDTO pacienteDTO) {
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setName(pacienteDTO.getName());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setRg(pacienteDTO.getRg());
        return pacienteRepository.save(paciente);
    }


}
