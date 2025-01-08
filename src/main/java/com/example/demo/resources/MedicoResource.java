package com.example.demo.resources;

import com.example.demo.dtos.MedicoDTO;
import com.example.demo.services.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "medico")
public class MedicoResource {


    private final MedicoService medicoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MedicoDTO>> findAll() {
        List<MedicoDTO> dto = medicoService.findAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
