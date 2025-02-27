package org.example.models;
import org.example.models.AnswerRequest;

/**
 * Trieda AnswerRequest predstavuje požiadavku používateľa na odpoveď na matematický príklad.
 * Obsahuje ID otázky a odpoveď zadanú používateľom.
 */
public class AnswerRequest {

    /** Identifikátor otázky. */
    private int questionId;

    /** Odpoveď používateľa. */
    private int userAnswer;

    /**
     * Získanie ID otázky.
     *
     * @return ID otázky.
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Nastavenie ID otázky.
     *
     * @param questionId nové ID otázky.
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * Získanie odpovede používateľa.
     *
     * @return Odpoveď používateľa.
     */
    public int getUserAnswer() {
        return userAnswer;
    }

    /**
     * Nastavenie odpovede používateľa.
     *
     * @param userAnswer Nová odpoveď používateľa.
     */
    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
}
