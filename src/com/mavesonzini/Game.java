package com.mavesonzini;

import com.sun.codemodel.internal.JOp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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
    JLabel messageLabel;

    JPanel panel;
    ButtonGroup buttonGroup;

    int score = 0;
    Quiz[] questionList;
    List<Quiz>skippedQuestionList = new ArrayList<Quiz>();
    Quiz currentQuiz;

    int correctAnswerCounter = 0;
    int questionCounter = 0;

    public Game() {
        chooseGame();
        createButtons();
        updateScreen();
    }

    public void chooseGame(){
        String[] buttonsArray = {"Hard", "Easy"};
        int buttonOption = JOptionPane.showOptionDialog(null, "Choose the level of difficulty", "How awesome are you?", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,null, buttonsArray,null);
        loadQuestions(buttonOption);
    }
    
    public void createButtons() {
        this.buttonGroup = new ButtonGroup();
        JRadioButton radioButton = new JRadioButton();

        JOptionPane.showMessageDialog(null, "Are you ready?\nTo Start Press 'OK'", "The toughest Game of Thrones trivia quiz in the Seven Kingdoms (Spoilers Ahoy!)\n", JOptionPane.DEFAULT_OPTION);
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

        this.messageLabel = new JLabel("Your Score is: " + correctAnswerCounter);
        messagePanel.add(messageLabel);
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
                }
                nextQuestion();
                break;
            case 0:
                finishGame();
                break;
        }
    }

    public void updateScore() {
        scoreCounter.setText("YOUR SCORE: " + score);
    }

    public boolean isRightAnswer() {
        return currentQuiz.getRightAnswerIndex() == getSelectedIndex();
    }

    public void addToSkipedArray(Quiz quiz){
        skippedQuestionList.add(quiz);
    }

    public void popUpMessage(){
        String[] buttonsArray = {"Leave for later", "Go back"};
        int buttonSelection = JOptionPane.showOptionDialog(null, this.panel, "Please select 1 answer", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, buttonsArray, null);
        switch (buttonSelection){
            case 1:
                break;
            case 0:
                addToSkipedArray(currentQuiz);
                questionCounter ++;
                break;
        }
    }

    public void updateQuestionArray(){
        for (int i = 0; i < skippedQuestionList.size(); i ++) {
            questionList[questionList.length + i] = skippedQuestionList.get(i);
        }
    }

    public void nextQuestion(){
        if (buttonGroup.getSelection() != null) {
            questionCounter ++;
        } else {
            popUpMessage();
        }

        if (questionCounter >= questionList.length) {
            if (skippedQuestionList.size() > 0) {
                for (int i = 0; i < questionList.length; i ++) {
                    System.out.println("PUTO ARRAY " + questionList[i].getQuestion());
                }
                updateQuestionArray();
            } else{
                finishGame();
            }
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

    public void finishGame(){
        new End(score);
    }

    public void loadQuestions(int difficulty){
        System.out.println("load questions called");

        questionList =  scan.StringScanner(difficulty);

    }

    public void updateScreen() {
        currentQuiz = questionList[questionCounter];
        questionLabel.setText(currentQuiz.getQuestion());
        radioButtonA.setText(currentQuiz.getAnswer1());
        radioButtonB.setText(currentQuiz.getAnswer2());
        radioButtonC.setText(currentQuiz.getAnswer3());
        radioButtonD.setText(currentQuiz.getAnswer4());
        radioButtons();
    }

}
