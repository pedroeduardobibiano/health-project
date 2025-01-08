package com.example.demo.resources;

import com.example.demo.dtos.ConsultaDTO;
import com.example.demo.services.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "consulta")
public class ConsultaResource {

    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> findAll() {
        List<ConsultaDTO> dto = consultaService.findAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
