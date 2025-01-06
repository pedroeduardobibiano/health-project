package com.example.demo.resources;


import com.example.demo.dtos.PacienteDTO;
import com.example.demo.services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "paciente")

public class PacienteResource {

    public final PacienteService pacienteService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PacienteDTO>> findAll() {
        List<PacienteDTO> dto = pacienteService.findAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
