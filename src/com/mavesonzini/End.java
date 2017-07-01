package com.mavesonzini;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mave on 31/05/2017.
 */
public class End extends JFrame implements ActionListener {
    JPanel panel;
    ButtonGroup buttonGroup;
    JLabel messageLabel;
    JLabel scoreLabel;
    int score = 0;
    String[] buttonsArray = {"No, thanks", "Try again"};

    public End(Integer UserScore){
        this.buttonGroup = new ButtonGroup();
        this.panel = new JPanel();
        this.messageLabel = new JLabel("Customized message here!");
        panel.add(messageLabel);

        this.scoreLabel = new JLabel("Your score is 0");
        panel.add(scoreLabel);
        updateLabel(UserScore);


        int buttonOption = JOptionPane.showOptionDialog(null, this.panel, "Do you want to try again?", JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, buttonsArray, null);

        if (buttonOption == 1){
            new Game();
        }
    }

    public void updateLabel(Integer score){
        if (score < 3){
            messageLabel.setText("You should \nreview seasson 1...");
            scoreLabel.setText("Your score: " + score);

        } else if (score > 3 && score < 7) {
            messageLabel.setText("You call yourself \na GOT fan?");
            scoreLabel.setText("Your score: " + score);
        } else {
            messageLabel.setText("Wow! well done");
            scoreLabel.setText("Your score: " + score);
        }
    }

    public void actionPerformed(ActionEvent e){
        new Game();
    }
}
