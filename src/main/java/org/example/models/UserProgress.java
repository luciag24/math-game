package org.example.models;

public class UserProgress {
    private int correctAnswers;
    private int incorrectAnswers;

    public UserProgress() {
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
    }
    public void incrementCorrectAnswers() {
        this.correctAnswers++;
    }
    public void incrementIncorrectAnswers() {
        this.incorrectAnswers++;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }
}
