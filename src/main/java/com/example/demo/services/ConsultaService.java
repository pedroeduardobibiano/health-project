package com.example.demo.services;

import com.example.demo.dtos.ConsultaDTO;
import com.example.demo.entities.Consulta;
import com.example.demo.repositories.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConsultaService {


    private final ConsultaRepository consultaRepository;

    @Transactional(readOnly = true)
    public List<ConsultaDTO> findAll() {
        List<Consulta> consulta = consultaRepository.findAll();
        return consulta.stream().map(ConsultaDTO::new).toList();
    }
}
