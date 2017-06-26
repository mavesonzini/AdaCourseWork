package com.mavesonzini;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by mave on 26/06/2017.
 */
public class QuizGame {
    JButton radioButtonA;
    JButton radioButtonB;
    JButton radioButtonC;
    JButton radioButtonD;

    JLabel scoreCounter;
    JLabel questionLabel;
    JLabel answerLabel;
    JLabel messageLabel;

    ArrayList<Quiz> questionList = new ArrayList<Quiz>();


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
    }

    public void updateWithQuiz(Quiz quiz){
        questionLabel.setText(quiz.getQuestion());
        radioButtonA.setText(quiz.getAnswer1());
        radioButtonB.setText(quiz.getAnswer2());
        radioButtonC.setText(quiz.getAnswer3());
        radioButtonD.setText(quiz.getAnswer4());
    }
}
