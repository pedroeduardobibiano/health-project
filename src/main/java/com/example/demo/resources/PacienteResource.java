package com.example.demo.resources;


import com.example.demo.dtos.PacienteDTO;
import com.example.demo.services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id) {
        PacienteDTO dto = pacienteService.findById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> save(@RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO dto = pacienteService.save(pacienteDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> update(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO dto = pacienteService.update(id, pacienteDTO);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> delete(@PathVariable Long id) {
        PacienteDTO dto = pacienteService.deleteById(id);
        return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
    }


}
