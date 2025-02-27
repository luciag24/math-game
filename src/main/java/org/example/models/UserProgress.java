package org.example.models;

/**
 * Trieda na sledovanie progresu používateľa v počte správnych a nesprávnych odpovedí.
 */
public class UserProgress {

    /** Počet správnych odpovedí. */
    private int correctAnswers;

    /** Počet nesprávnych odpovedí. */
    private int incorrectAnswers;

    /**
     * Konštruktor inicializuje počty správnych a nesprávnych odpovedí na nulu.
     */
    public UserProgress() {
        this.correctAnswers = 0;
        this.incorrectAnswers = 0;
    }

    /**
     * Inkrementuje počet správnych odpovedí o 1.
     */
    public void incrementCorrectAnswers() {
        this.correctAnswers++;
    }

    /**
     * Inkrementuje počet nesprávnych odpovedí o 1.
     */
    public void incrementIncorrectAnswers() {
        this.incorrectAnswers++;
    }

    /**
     * Získa počet správnych odpovedí.
     *
     * @return počet správnxh odpovedí
     */
    public int getCorrectAnswers() {
        return correctAnswers;
    }

    /**
     * Získa počet nesprávnych odpovedí-
     *
     * @return počet nesprávnych odpovedí
     */
    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }
}
