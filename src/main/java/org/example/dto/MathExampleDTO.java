package org.example.dto;

import org.example.dto.MathExampleDTO;
import org.example.mapper.MathExampleMapper;

/**
 * Data Transfer Object (DTO) pre matematický príklad.
 * Používa sa na prenos údajov medzi frontend a backend aplikáciou.
 */
public class MathExampleDTO {
    private String question;
    private double correctAnswer;
    private int userAnswer;

    /**
     * Konštruktor pre MathExampleDTO.
     *
     * @param question Text matematického príkladu.
     * @param correctAnswer Správna odpoveď na príklad.
     * @param userAnswer Odpoveď zadaná používateľom.
     */
    public MathExampleDTO(String question, double correctAnswer, int userAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
    }

    /**
     * Získa text matematického príkladu.
     *
     * @return Text matematického príkladu
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Nastaví text matematického príkladu.
     *
     * @param question Nový text matematického príkladu.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Získa ssprávnu odpoveď na príklad.
     *
     * @return Správna odpoveď.
     */
    public double getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Nastaví správnu odpoveď na príklad.
     *
     * @param correctAnswer Nová správna odpoveď.
     */
    public void setCorrectAnswer(double correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * Získa odpoveď zadanú používateľom.
     *
     * @return Odpoveď zadaná používateľom.
     */
    public int getUserAnswer() {
        return userAnswer;
    }

    /**
     * Nastaví odpoveď zadanú používateľom.
     *
     * @param userAnswer Nová odpoveď zadaná používateľom.
     */
    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
}
