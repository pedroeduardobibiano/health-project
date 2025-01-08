package com.example.demo.services;


import com.example.demo.dtos.MedicoDTO;
import com.example.demo.entities.Medico;
import com.example.demo.repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Transactional(readOnly = true)
    public List<MedicoDTO> findAll() {
        List<Medico> medicos = medicoRepository.findAll();
        return medicos.stream().map(MedicoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public MedicoDTO findById(Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        medico.orElseThrow(() -> new NoSuchElementException("id not found"));
        return new MedicoDTO(medico.get());
    }

    @Transactional
    public MedicoDTO save(MedicoDTO medicoDTO) {
        Medico medico = getMedico(medicoDTO);
        return new MedicoDTO(medicoRepository.save(medico));

    }

    private static Medico getMedico(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setName(medicoDTO.getName());
        medico.setArea(medicoDTO.getArea());
        medico.setCrm(medicoDTO.getCrm());
        medico.setAvaliacao(medicoDTO.getAvaliacao());
        return medico;
    }

}
