package quiz.Model;

import java.util.*;

public class QuizGame {

    private static final int MAX_QUESTIONS = 10;
    private List<QuizQuestion> questionList;
    private int countQuestions, index;

    private static boolean LOG = true;

    private static void log(String s) { if(LOG) System.out.println(s); }

    public static int getNoOfQuestions() { return MAX_QUESTIONS; }

    public QuizGame() {

        questionList = new ArrayList<QuizQuestion>() ;
        countQuestions = 0;
        index = 0;
    }

    public boolean addQuestion(QuizQuestion ques) {

        if(countQuestions < MAX_QUESTIONS)
            questionList.add(ques);
        else
            return false;
        countQuestions++;
        log(ques.toString());
        log("countQuestions value = " + Integer.toString(countQuestions));

        return true;
    }

    public int getCountQuestions() {
        return countQuestions;
    }

    public QuizQuestion getQuestion() {

        if(index < countQuestions) {
            log(questionList.get(index).toString());
            return questionList.get(index);
        }
        else
            return null;
    }

    public String getCorrect() {

        return questionList.get(index).getCorrect();
    }

    public boolean isGameOver() {
        if(index < countQuestions - 1)
            return false;
        else
            return true;
    }

    public void incIndex() {
        log("Index value = "+Integer.toString(index));
        if(index < countQuestions-1)
            index++;
    }

   /* public void decIndex() {
        if(index > 0)
            index--;
    }*/

}
