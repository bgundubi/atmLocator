package com.ing.controller;

import com.ing.model.Atm;
import com.ing.service.AtmLocatorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class AtmLocatorController {

    @Autowired
    AtmLocatorService atmLocatorService;


    @GetMapping(path= "/atms",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Atm> getAllAtms() throws IOException {
        return atmLocatorService.getAllAtms();
    }

        @GetMapping(path= "/atms/{cityName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Atm> getAllAtmsByCity(@PathVariable String cityName) throws IOException {
        return atmLocatorService.getAllAtmsByCity(cityName);
    }
}
