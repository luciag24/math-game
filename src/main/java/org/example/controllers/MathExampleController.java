package org.example.controllers;

import org.example.models.MathExample;
import org.example.models.UserProgress;
import org.springframework.web.bind.annotation.*;
import org.example.services.MathExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.dto.MathExampleDTO;
import org.example.mapper.MathExampleMapper;

/**
 * RestController pre matematické príklady.
 * Obsahuje endpointy na generovanie príkladov a overovanie odpovedí.
 */
@RestController
@RequestMapping("/api")
public class MathExampleController {
    private final MathExampleService mathExampleService;
    private final MathExampleMapper mathExampleMapper;

    /**
     * Konštruktor na injektovanie služieb.
     *
     * @param mathExampleService Servisná vrstva pre matematické príklady.
     * @param mathExampleMapper Mapper medzi entitou a DTO.
     */
    @Autowired
    public MathExampleController(MathExampleService mathExampleService, MathExampleMapper mathExampleMapper) {
        this.mathExampleService = mathExampleService;
        this.mathExampleMapper = mathExampleMapper;
    }

    /**
     * Uloží matematický príkaz do databázy.
     *
     * @param exampleDTO DTO objekt obsahujúci detaily príkladu.
     * @return Uložený príklad v DTO formáte.
     */
    @PostMapping("/save-example")
    public MathExampleDTO saveExample(@RequestBody MathExampleDTO exampleDTO) {
        MathExample example = mathExampleMapper.toEntity(exampleDTO);
        MathExample savedExample = mathExampleService.saveExample(example);
        return mathExampleMapper.toDTO(savedExample);
    }

    /**
     * Endpoint na získanie progresu.
     *
     * @return Reťazec informujúci o dostupnosti endpointu.
     */
    @GetMapping("/progress")
    public String getProgress() {
        return "Progress endpoint is working!";
    }

    /**
     * Overí správnosť odpovede na matematický príklad.
     *
     * @param example Objekt obsahujúci odpoveď užívateľa.
     * @return Výsledok analýzy odpovede.
     */
    @PostMapping("/check-answer")
    public MathExample checkAnswer(@RequestBody MathExample example) {
        System.out.println("HTTP Method: Post");
        System.out.println("Received request: " + example);
        if (example == null || example.getUserAnswer() == 0) {
            throw new IllegalArgumentException("User answer is missing!");
        }
        return mathExampleService.analyzeAnswer(example, example.getUserAnswer());
    }

    /**
     * Vygeneruje nový matematický príklad na základe zvoleného ročníka.
     *
     * @param grade Ročník, pre ktorý sa generuje príklad.
     * @return Matematický príklad.
     */
    @GetMapping("/generate")
    public MathExample generateMathExample(@RequestParam int grade) {
        System.out.println("Grade received:" + grade);
        switch (grade) {
            case 1:
                return mathExampleService.generateFirstGradeExample();
            case 2:
                return mathExampleService.generateSecondGradeExample();
            case 3:
               return mathExampleService.generateThirdGradeExample();
            case 4:
                return mathExampleService.generateFourthGradeExample();
            default:
                throw new IllegalArgumentException("Neplatný ročník:" + grade);
        }
    }

    /**
     * Endpoint na získanie príkkladu pre prvý ročník.
     *
     * @return Matematický príklad pre prvý ročník.
     */
    @GetMapping("/first-grade")
    public MathExample getFirstGradeExample() {
        return mathExampleService.generateFirstGradeExample();
    }

    /**
     * Endpoint na získanie príkladu pre druhý ročník.
     *
     * @return Matematický príklad pre druhý ročník.
     */
    @GetMapping("/second-grade")
    public MathExample getSecondGradeExample() {
        return mathExampleService.generateSecondGradeExample();
    }

    /**
     * Endpoint na získanie príkladu pre tretí ročník.
     *
     * @return Matematický príklad pre tretí ročník.
     */
    @GetMapping("/third-grade")
    public MathExample getThirdGradeExample() {
        return mathExampleService.generateThirdGradeExample();
    }

    /**
     * Endpoint na získanie príkladu pre štvrtý ročník.
     *
     * @return Matematický príklad pre štvrtý ročník.
     */
    @GetMapping("/fourth-grade")
    public MathExample getFourthGradeExample() {
        return mathExampleService.generateFourthGradeExample();
    }


    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working!";
    }
}

