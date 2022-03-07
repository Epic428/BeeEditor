package com.teamresourceful.editorbackend.controller;

import com.teamresourceful.editorbackend.dto.beedata.BeeDataDto;
import com.teamresourceful.editorbackend.model.beedata.BeeData;
import com.teamresourceful.editorbackend.service.BeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//API Layer
@RestController
@RequestMapping(path = "api/editor/bee")
public class BeeController {

    //@Autowired
    private final BeeService beeService;

    //@Autowired
    private final ModelMapper modelMapper;

    @Autowired // use with @Component/@Service to link service and inject dependency
    public BeeController(BeeService beeService, ModelMapper modelMapper) {
        this.beeService = beeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<BeeDataDto> getBees() {
        return beeService.getBees().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = {"{beeId}"})
    public BeeData getBee(@PathVariable UUID beeId) {
        return beeService.getBee(beeId);
    }

    @PostMapping("/create")
    public ResponseEntity<BeeDataDto> addNewBee(@Valid @RequestBody BeeDataDto beeDataDto) {
        return new ResponseEntity<>(convertToDto(beeService.addNewBee(convertToEntity(beeDataDto))), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{beeId}")
    public void deleteBee(@PathVariable("beeId") Long beeId) {
        beeService.deleteBee(beeId);
    }

    /*@PutMapping(path = "{beeId}")
    public void updateBee(@PathVariable("beeId") Long beeId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        beeService.updateBee(beeId, name, email);
    }*/

    /*@PostMapping(path = "/update/{beeId}")
    public ResponseEntity<CustomBeeData> update(@PathVariable("beeId") Long beeId, @RequestBody CustomBeeData beeData) {
        beeData = BeeService.update(beeId, beeData);
        return ResponseEntity.ok().body(beeData);
    }*/

    @PostMapping(path = "/update/{beeId}")
    public String update(@PathVariable("beeId") Long beeId, @RequestBody BeeData beeData) {
        //beeData = BeeService.update(beeId, beeData);
        return "This is a Test!!!";
    }

    private BeeDataDto convertToDto(BeeData beeData) {
        return modelMapper.map(beeData, BeeDataDto.class);
    }

    private BeeData convertToEntity(BeeDataDto beeDataDto) {
        return modelMapper.map(beeDataDto, BeeData.class);
    }
}
