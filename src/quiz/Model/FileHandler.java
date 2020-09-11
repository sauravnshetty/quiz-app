package quiz.Model;

import quiz.Controller.MyRuntimeException;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class FileHandler {

    private final String filename ;
    private final String countFile;
    private static int count;

    {
        count = 0;
    }

    public static int getCount() { return count; }

    public String getFilename() {
        return filename;
    }

    public FileHandler(String filename, String countFile) {
        this.filename = filename;
        this.countFile = countFile;
        try {
            File cfile = new File(this.countFile);
            cfile.createNewFile();
            Scanner scan = new Scanner(cfile);
            if (scan.hasNextInt())
                count = scan.nextInt();
        }
        catch (Exception e) {
            throw new MyRuntimeException(e.getMessage());
        }
    }

    public void addQuestions(QuizQuestion q) {
        try {
            if(count == 0) {
                File quizFile = new File(this.filename);
                quizFile.createNewFile();
                FileOutputStream file = new FileOutputStream(quizFile);
                ObjectOutputStream fobj = new ObjectOutputStream(file);
                fobj.writeObject(q);
                file.close();
                fobj.close();
            }
            else {
                FileOutputStream file = new FileOutputStream(this.filename, true);
                ObjectOutputStream fobj = new ObjectOutputStream(file){
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
                fobj.writeObject(q);
                file.close();
                fobj.close();
            }
            incCounter();
        }
        catch(Exception fe) {
            throw new MyRuntimeException(fe.getMessage());
        }
    }

    public void incCounter() throws Exception {

        File cfile = new File(countFile);
        cfile.createNewFile();
        Scanner scan = new Scanner(cfile);
        if(scan.hasNextInt())
            count = scan.nextInt();
        PrintWriter writer = new PrintWriter(cfile);
        writer.print(++count);
        writer.close();
        scan.close();
    }

    public QuizGame importQuiz() {

        //int rand = (int)Math.random()*(count - QuizGame.NO_OF_QUESTIONS);
        Random rand_int = new Random();
        int rand = 0;
        if(count > QuizGame.getNoOfQuestions()+1) {
            rand = rand_int.nextInt(count - QuizGame.getNoOfQuestions()+1);
        }
        QuizGame quizGame = new QuizGame();
        QuizQuestion question;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.filename));
            while (rand-- != 0) {
                ois.readObject();
            }
            for (int i = 0; i < Math.min(QuizGame.getNoOfQuestions(), count); i++)
                quizGame.addQuestion((QuizQuestion) ois.readObject());
        }
        catch(Exception e) {
            throw new MyRuntimeException(e.getMessage());
        }
        return quizGame;
    }
}
