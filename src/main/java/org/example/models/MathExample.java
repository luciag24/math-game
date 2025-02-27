package org.example.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MathExample {


    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String question;
        private double correctAnswer;
        private int userAnswer;
        private boolean isCorrect;

        public MathExample() {}

        public MathExample(String question, double correctAnswer) {
            this.question = question;
            this.correctAnswer = correctAnswer;
            this.userAnswer = 0;
            this.isCorrect = false;
        }
        public Long getId() {
            return id;
        }

    public void setId(Long id) {
        this.id = id;
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
            this.isCorrect = (userAnswer == this.correctAnswer);
        }

        public boolean isCorrect() {
            return isCorrect;
        }
    }



