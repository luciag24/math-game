package org.example.models;
import org.example.models.AnswerRequest;

public class AnswerRequest {
    private int questionId;
    private int userAnswer;

    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public int getUserAnswer() {
        return userAnswer;
    }
    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }
}
