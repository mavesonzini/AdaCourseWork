package com.mavesonzini;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
/**
 * Created by mave on 31/05/2017.
 */
public class StringScanner {

    public Quiz[] StringScanner (){

        Scanner scanQuestion;
        Scanner scanAnswer;
        Scanner scanCorrectAnswers;
        int i = 0;
        int j = 0;

        String[] questionsArray = new String[10];
        String[][] answersArray = new String[10][5];
        String[] correctAnswersArray = new String[10];

        Quiz[] parsedQuestions = new Quiz[10];

        try {
            File easyQuestions = new File("EasyQuestions.txt");
            scanQuestion = new Scanner(easyQuestions);

            while (scanQuestion.hasNextLine()){
                questionsArray[i] = scanQuestion.nextLine();
                i++;
            }
//            System.out.println(Arrays.toString(questionsArray));

            File easyAnswers = new File("EasyAnswers.txt");
            scanAnswer = new Scanner(easyAnswers).useDelimiter(", ");

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
                String[] answers = answersArray[i];
                System.out.println(answers[4]);

                int index = Integer.parseInt(answers[4]);
                Quiz quiz = new Quiz(individualQuestion, answers[0], answers[1], answers[2], answers[3], index);
                parsedQuestions[i] = quiz;
            }

            File correctAnswers = new File("correctAnswers.txt");
            scanCorrectAnswers = new Scanner(correctAnswers);

            i = 0;
            while (scanCorrectAnswers.hasNextLine()){
                correctAnswersArray[i] = scanCorrectAnswers.nextLine();
                i++;
            }

        } catch (IOException ioe){
            System.out.println("Problem reading from the file " + ioe.getLocalizedMessage());
        }
        return parsedQuestions ;
    }
}
