package com.example.demo.services;


import com.example.demo.dtos.MedicoDTO;
import com.example.demo.entities.Medico;
import com.example.demo.repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Transactional(readOnly = true)
    public List<MedicoDTO> findAll() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream().map(MedicoDTO::new).toList();
    }

}
