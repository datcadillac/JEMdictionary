package src.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class QuestionManagement {

    private static final String questionPath = "src/resource/question.txt";
    private static ArrayList<Question> questionArrayList = new ArrayList<Question>();

    public static ArrayList<Question> getQuestionArrayList() {
        return questionArrayList;
    }

    public static void importQuestion() {
        try {
            File file = new File(questionPath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                String question = line.substring(1);
                line = reader.readLine();
                String opt1 = line;
                line = reader.readLine();
                String opt2 = line;
                line = reader.readLine();
                String opt3 = line;
                line = reader.readLine();
                String opt4 = line;
                line = reader.readLine();
                String answer = line.substring(1);
                questionArrayList.add(new Question(question, opt1, opt2, opt3, opt4, answer));
                System.out.println(questionArrayList.size());
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
