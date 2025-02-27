package org.example.dto;

import org.example.dto.MathExampleDTO;
import org.example.mapper.MathExampleMapper;

public class MathExampleDTO {
    private String question;
    private double correctAnswer;
    private int userAnswer;


    public MathExampleDTO(String question, double correctAnswer, int userAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(double correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
}
