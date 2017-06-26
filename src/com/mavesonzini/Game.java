package com.mavesonzini;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by mave on 31/05/2017.
 */
public class Game extends JFrame {
    StringScanner scan = new StringScanner();
    JRadioButton radioButtonA;
    JRadioButton radioButtonB;
    JRadioButton radioButtonC;
    JRadioButton radioButtonD;

    JLabel scoreCounter;
    JLabel questionLabel;
    JLabel answerLabel;
    JLabel messageLabel;

    JPanel panel;
    ButtonGroup buttonGroup;

    int score = 0;
    Quiz[] questionList = new Quiz[10];
    Quiz currentQuiz;

    int correctAnswerCounter = 0;
    int questionCounter = 0;

    public Game() {
        loadQuestions();
        createButtons();
        updateScreen();
    }

    public void createButtons() {
        this.buttonGroup = new ButtonGroup();
        JRadioButton radioButton = new JRadioButton();

        JOptionPane.showMessageDialog(null, "Are you ready?\nTo Start Press 'OK'", "Game of Thrones Quiz", JOptionPane.DEFAULT_OPTION);
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.PAGE_AXIS));
        JPanel questionPanel = new JPanel();

        this.questionLabel = new JLabel("Question");
        questionPanel.add(questionLabel);

        panel.add(questionPanel);

        JPanel answersPanel = new JPanel();

        this.radioButtonA = new JRadioButton("Answer 1");
        buttonGroup.add(radioButtonA);
        answersPanel.add(radioButtonA);

        this.radioButtonB = new JRadioButton("Answer 2");
        buttonGroup.add(radioButtonB);
        answersPanel.add(radioButtonB);

        this.radioButtonC = new JRadioButton("Answer 3");
        buttonGroup.add(radioButtonC);
        answersPanel.add(radioButtonC);

        this.radioButtonD = new JRadioButton("Answer 4");
        buttonGroup.add(radioButtonD);
        answersPanel.add(radioButtonD);

        panel.add(answersPanel);

        JPanel messagePanel = new JPanel();

        this.messageLabel = new JLabel("Message");
        messagePanel.add(messageLabel);

        panel.add(messagePanel);

        this.scoreCounter = new JLabel("0");
        updateScore();
        panel.add(scoreCounter);
    }

    public int getSelectedIndex() {
        if (radioButtonA.isSelected()) {
            return 0;
        } else if (radioButtonB.isSelected()) {
            return 1;
        } else if (radioButtonC.isSelected()) {
            return 2;
        } else {
            return 3;
        }
    }

    public void radioButtons(){

        buttonGroup.clearSelection();

        String[] buttonsArray = {"Finish", "Next", "Previous"};

        int buttonOption = JOptionPane.showOptionDialog(null, this.panel, "Do you know the answer???", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, buttonsArray, null);
        System.out.println("button option selected");
        System.out.println(buttonOption);

        System.out.println("Right Answer");
        System.out.println(currentQuiz.getRightAnswerIndex());

        System.out.println("Selected Answer");
        System.out.println(getSelectedIndex());

        switch (buttonOption){
            case 2:
                previousQuestion();
                break;
            case 1:
                if (isRightAnswer()) {
                    score++;
                    updateScore();
                }
                nextQuestion();
                break;
            case 0:
                endScreen();
                break;
        }
    }

    public void updateScore() {
        scoreCounter.setText("Score: " + score);
    }

    public boolean isRightAnswer() {
        return currentQuiz.getRightAnswerIndex() == getSelectedIndex();
    }

    public void nextQuestion(){
        System.out.println("next question called");

        questionCounter ++;
        if (questionCounter >= questionList.length){
            endScreen();
            System.out.println("The End!");
            System.out.println(correctAnswerCounter);
        } else {
            updateScreen();
        }
    }

    public void previousQuestion(){
        questionCounter --;
        if(questionCounter < 0){
            questionCounter = 0;
        }
        updateScreen();
    }

    public void saveForNext(){

    }

    public void finishGame(){
        new End(correctAnswerCounter);
    }

    public void loadQuestions(){
        System.out.println("load questions called");

        questionList =  scan.StringScanner();

    }

    public void endScreen(){
        setVisible(false);
        new End(correctAnswerCounter);
    }

    public void updateScreen() {
        currentQuiz = questionList[questionCounter];
        questionLabel.setText(currentQuiz.getQuestion());
        radioButtonA.setText(currentQuiz.getAnswer1());
        radioButtonB.setText(currentQuiz.getAnswer2());
        radioButtonC.setText(currentQuiz.getAnswer3());
        radioButtonD.setText(currentQuiz.getAnswer4());
        messageLabel.setText("Please select ONE answer");
        radioButtons();
    }

}
