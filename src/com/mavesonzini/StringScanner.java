package com.mavesonzini;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

/**
 * Created by mave on 31/05/2017.
 */
public class StringScanner {

    public Quiz[] StringScanner (int difficulty){

        Scanner scanQuestion;
        Scanner scanAnswer;
        String pathNameQuestion = "";
        String pathNameAnswer = "";


        if (difficulty == 1){
            pathNameQuestion = "EasyQuestions.txt";
            pathNameAnswer = "EasyAnswers.txt";
        } else if (difficulty == 0){
            pathNameQuestion = "HardQuestions.txt";
            pathNameAnswer = "HardAnswers.txt";

        }

        int i = 0;
        int j = 0;

        String[] questionsArray = new String[10];
        String[][] answersArray = new String[10][5];

        Quiz[] parsedQuestions = new Quiz[10];

        try {
            File questions = new File(pathNameQuestion);
            scanQuestion = new Scanner(questions);

            while (scanQuestion.hasNextLine()){
                questionsArray[i] = scanQuestion.nextLine();
                i++;
            }
            System.out.println("QUESTIONS " + Arrays.deepToString(questionsArray));


            File answers = new File(pathNameAnswer);
            scanAnswer = new Scanner(answers).useDelimiter(", ");

            i = 0;
            j = 0;
            while (scanAnswer.hasNext()){
                String answer = scanAnswer.next();
                System.out.println("Parsed answer: " + answer);
                System.out.println("i = " + i + ", j = " + j);
                answersArray[i][j] = answer;
                if (j == 4) {
                    System.out.println(Arrays.deepToString(answersArray[i]));
                    j = 0;
                    i++;
                } else {
                    j++;
                }
            }
            System.out.println(Arrays.deepToString(answersArray));

            i = 0;

            for (i = 0; i < 10; i++){
                String individualQuestion = questionsArray[i];
                String[] answer = answersArray[i];
                System.out.println(answer[4]);

                int index = Integer.parseInt(answer[4]);
                Quiz quiz = new Quiz(individualQuestion, answer[0], answer[1], answer[2], answer[3], index);
                parsedQuestions[i] = quiz;
            }

        } catch (IOException ioe){
            System.out.println("Problem reading from the file " + ioe.getLocalizedMessage());
        }
        return parsedQuestions ;
    }
}
