package com.teamresourceful.editorbackend.controller;

import com.teamresourceful.editorbackend.beedata.CustomBeeData;
import com.teamresourceful.editorbackend.service.BeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API Layer
@RestController
@RequestMapping(path = "api/editor/bee")
public class BeeController {

    private final BeeService beeService;

    @Autowired // use with @Component/@Service to link service and inject dependency
    public BeeController(BeeService beeService) {
        this.beeService = beeService;
    }

    @GetMapping
    public List<CustomBeeData> getBees() {
        return beeService.getBees();
    }

    @GetMapping(path = {"{beeId}"})
    public CustomBeeData getBee(@PathVariable Long beeId) {
        return beeService.getBee(beeId);
    }

    @PostMapping
    public void addNewBee(@RequestBody CustomBeeData beeData) {
        beeService.addNewBee(beeData);
    }

    @DeleteMapping(path = "{beeId}")
    public void deleteBee(@PathVariable("beeId") Long beeId) {
        beeService.deleteBee(beeId);
    }

    /*@PutMapping(path = "{beeId}")
    public void updateBee(@PathVariable("beeId") Long beeId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        beeService.updateBee(beeId, name, email);
    }*/
}
