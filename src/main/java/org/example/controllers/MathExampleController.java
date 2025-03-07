package org.example.controllers;

import org.example.models.MathExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.services.MathExampleService;

/**
 * RestController pro matematické příklady.
 * Obsahuje endpointy na generovanie príkladov a overovanie odpovedí.
 */
@RestController
@RequestMapping("/api")
public class MathExampleController {
    private final MathExampleService mathExampleService;

    /**
     * Konštruktor na injektovanie služieb.
     *
     * @param mathExampleService Servisná vrstva pre matematické príklady.
     */
    @Autowired
    public MathExampleController(MathExampleService mathExampleService) {
        this.mathExampleService = mathExampleService;
    }

    /**
     * Endpoint na získanie progresu.
     *
     * @return Reťazec informujúci o progrese uživatele.
     */
    @GetMapping("/progress")
    public String getProgress() {
        return mathExampleService.getProgressMessage();
    }

    /**
     * Overí správnosť odpovede na matematický příklad.
     *
     * @param example Objekt obsahujúci odpoveď užívateľa.
     * @return Výsledok analýzy odpovede.
     */
    @PostMapping("/check-answer")
    public MathExample checkAnswer(@RequestBody MathExample example) {
        System.out.println("HTTP Method: Post");
        System.out.println("Received request: " + example);
        
        // OPRAVENO: Odstraněna kontrola na example.getUserAnswer() == 0
        // Nula může být legitimní odpověď, zejména u desetinných čísel
        if (example == null) {
            throw new IllegalArgumentException("Request is missing!");
        }
        
        // Debugging informace
        System.out.println("Očekávaná odpověď: " + example.getCorrectAnswer());
        System.out.println("Uživatelská odpověď: " + example.getUserAnswer());
        
        // Upravené vyhodnocení pro tolerance desetinných čísel
        boolean isCorrect = Math.abs(example.getUserAnswer() - example.getCorrectAnswer()) < 0.1;
        System.out.println("Je odpověď správná? " + isCorrect);
        
        // Zde používáme double místo int pro userAnswer
        MathExample result = mathExampleService.analyzeAnswer(example, example.getUserAnswer());
        
        // Přidáme vlastnost 'correct' pro frontend
        result.setCorrect(result.isCorrect());
        
        return result;
    }

    /**
     * Vygeneruje nový matematický příklad na základe zvoleného ročníka.
     *
     * @param grade Ročník, pre ktorý sa generuje príklad.
     * @return Matematický příklad.
     */
    @GetMapping("/generate")
    public MathExample generateMathExample(@RequestParam int grade) {
        System.out.println("Grade received: " + grade);
        MathExample example;
        
        switch (grade) {
            case 1 -> example = mathExampleService.generateFirstGradeExample();
            case 2 -> example = mathExampleService.generateSecondGradeExample();
            case 3 -> example = mathExampleService.generateThirdGradeExample();
            case 4 -> example = mathExampleService.generateFourthGradeExample();
            default -> throw new IllegalArgumentException("Neplatný ročník: " + grade);
        }
        
        // Debugging výpis vygenerovaného příkladu
        System.out.println("Vygenerovaný příklad: " + example.getQuestion() + " = " + example.getCorrectAnswer());
        
        return example;
    }

    /**
     * Endpoint na získanie příkladu pro první ročník.
     *
     * @return Matematický příklad pro první ročník.
     */
    @GetMapping("/first-grade")
    public MathExample getFirstGradeExample() {
        return mathExampleService.generateFirstGradeExample();
    }

    /**
     * Endpoint na získanie příkladu pro druhý ročník.
     *
     * @return Matematický příklad pro druhý ročník.
     */
    @GetMapping("/second-grade")
    public MathExample getSecondGradeExample() {
        return mathExampleService.generateSecondGradeExample();
    }

    /**
     * Endpoint na získanie příkladu pro třetí ročník.
     *
     * @return Matematický příklad pro třetí ročník.
     */
    @GetMapping("/third-grade")
    public MathExample getThirdGradeExample() {
        return mathExampleService.generateThirdGradeExample();
    }

    /**
     * Endpoint na získanie příkladu pro čtvrtý ročník.
     *
     * @return Matematický příklad pro čtvrtý ročník.
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