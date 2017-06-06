package com.mavesonzini;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by mave on 31/05/2017.
 */
public class Quiz extends JFrame {
    StringScanner scan = new StringScanner();
    JButton radioButtonA;
    JButton radioButtonB;
    JButton radioButtonC;
    JButton radioButtonD;

    JLabel scoreCounter;
    JLabel questionLabel;
    JLabel answerLabel;
    JLabel messageLabel;

    int counter = 0;
    ArrayList<Question> questionList = new ArrayList<Question>();
    int correctAnswerCounter = 0;
    int questionCounter = 1;

    public Quiz(){
        loadQuestions();
        radioButtons();
        updateScreen();
    }

    public void radioButtons(){
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioButton = new JRadioButton();

        JOptionPane.showMessageDialog(null, "Are you ready?\nTo Start Press 'OK'", "Game of Thrones Quiz", JOptionPane.DEFAULT_OPTION);
        JPanel panel = new JPanel();

        JRadioButton button1 = new JRadioButton("Answer 1");
        buttonGroup.add(button1);
        panel.add(button1);

        JRadioButton button2 = new JRadioButton("Answer 2");
        buttonGroup.add(button2);
        panel.add(button2);

        JRadioButton button3 = new JRadioButton("Answer 3");
        buttonGroup.add(button3);
        panel.add(button3);

        JRadioButton button4 = new JRadioButton("Answer 4");
        buttonGroup.add(button4);
        panel.add(button4);

        String[] buttonsArray = {"Finish", "Next", "Previous"};
        int buttonOption = JOptionPane.showOptionDialog(null, panel, "This is a title!", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, buttonsArray, null);
        System.out.println(buttonOption);

        int buttonSelection = 2;

        switch (buttonSelection){
            case 1:
                previousQuestion();
                break;
            case 2:
                nextQuestion();
                break;
            case 3:
                finishGame();
                break;
        }
    }

    public void checkAnswer(String guess){

    }

    public void nextQuestion(){
        questionCounter ++;
        if (questionCounter >= questionList.size()){
            endScreen();
            System.out.println("The End!");
            System.out.println(correctAnswerCounter);
        }
            updateScreen();
    }

    public void previousQuestion(){
        questionCounter --;
        if(questionCounter <= 0){
            counter = 0;
        }
        updateScreen();
    }

    public void saveForNext(){

    }

    public void finishGame(){
        new End(correctAnswerCounter);
    }

    public void loadQuestions(){
        scan.StringScanner();
    }

    public void endScreen(){
        setVisible(false);
        new End(correctAnswerCounter);
    }

    public void updateScreen() {
        scoreCounter.setText("Question " + Integer.toString(questionCounter++));
        Question question = questionList.get(counter);
        questionLabel.setText(question.getQuestion());
        radioButtonA.setText(question.getAnswer1());
        radioButtonB.setText(question.getAnswer2());
        radioButtonC.setText(question.getAnswer3());
        radioButtonD.setText(question.getAnswer4());
        messageLabel.setText("Please select ONE answer");
    }

}
