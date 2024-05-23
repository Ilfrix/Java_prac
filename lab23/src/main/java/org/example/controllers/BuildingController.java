package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.services.BuildingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
@AllArgsConstructor
public class BuildingController {
    private BuildingService service;
}
