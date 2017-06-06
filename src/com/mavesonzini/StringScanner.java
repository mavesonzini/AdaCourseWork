package com.mavesonzini;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
/**
 * Created by mave on 31/05/2017.
 */
public class StringScanner {

    public Question[] StringScanner (){

        Scanner scanQuestion;
        Scanner scanAnswer;
        Scanner scanCorrectAnswers;
        int i = 0;
        int j = 0;

        String[] questionsArray = new String[10];
        String[][] answersArray = new String[10][4];
        String[] correctAnswersArray = new String[10];

        Question[] parsedQuestions = new Question[10];

        try {
            File easyQuestions = new File("EasyQuestions.txt");
            scanQuestion = new Scanner(easyQuestions);

            while (scanQuestion.hasNextLine()){
                questionsArray[i] = scanQuestion.nextLine();
                i++;
            }
            System.out.println(Arrays.toString(questionsArray));

            File easyAnswers = new File("EasyAnswers.txt");
            scanAnswer = new Scanner(easyAnswers).useDelimiter("\t");

            i = 0;
            while (scanAnswer.hasNext()){
                answersArray[i][j] = scanAnswer.next();
                if (j == 3) {
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
                String[] answers = answersArray[i];

                Question question = new Question(individualQuestion, answers[0], answers[1], answers[2], answers[3]);
            }

            File correctAnswers = new File("correctAnswers.txt");
            scanCorrectAnswers = new Scanner(correctAnswers);

            i = 0;
            while (scanCorrectAnswers.hasNextLine()){
                correctAnswersArray[i] = scanCorrectAnswers.nextLine();
                i++;
            }
            System.out.println(Arrays.toString(correctAnswersArray));

        } catch (IOException ioe){
            System.out.println("Problem reading from the file " + ioe.getLocalizedMessage());
        }
        return parsedQuestions ;
    }
}
