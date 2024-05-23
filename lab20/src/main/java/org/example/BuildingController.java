package org.example;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buildings")
@AllArgsConstructor
public class BuildingController {
    private BuildingService service;
}
