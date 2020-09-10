package quiz.model;

import java.io.Serializable;

public class QuizQuestion implements Serializable {

    private static final long serialVersionUID = 7807408951839180492L;

    private String question;
    private String correct;
    private String[] allAnswers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String[] getAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(String[] allanswers) {
        this.allAnswers = allanswers;
    }

    @Override
    public String toString() {
        return this.getQuestion() + " " + this.getCorrect();
    }
}
