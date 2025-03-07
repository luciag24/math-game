package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller pro domovskou stránku aplikace
 */
@Controller
public class HomeController {

    /**
     * Vrátí domovskou stránku aplikace
     * 
     * @return název šablony pro domovskou stránku
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }
}