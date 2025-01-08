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
        Medico medico = getMedico(id);
        return new MedicoDTO(medico);
    }


    @Transactional
    public MedicoDTO save(MedicoDTO medicoDTO) {
        Medico medico = getMedico(new Medico(), medicoDTO);
        return new MedicoDTO(medicoRepository.save(medico));

    }

    @Transactional
    public MedicoDTO update(Long id, MedicoDTO medicoDTO) {
        Medico medico = medicoRepository.getReferenceById(id);
        getMedico(medico, medicoDTO);
        return new MedicoDTO(medicoRepository.save(medico));
    }

    @Transactional
    public MedicoDTO deleteById(Long id) {
        Medico medico = getMedico(id);
        medicoRepository.delete(medico);
        return new MedicoDTO(medico);
    }

    private Medico getMedico(Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.orElseThrow(() -> new NoSuchElementException("id not found"));
    }


    private static Medico getMedico(Medico medico, MedicoDTO medicoDTO) {
        medico.setName(medicoDTO.getName());
        medico.setArea(medicoDTO.getArea());
        medico.setCrm(medicoDTO.getCrm());
        medico.setAvaliacao(medicoDTO.getAvaliacao());
        return medico;
    }

}
