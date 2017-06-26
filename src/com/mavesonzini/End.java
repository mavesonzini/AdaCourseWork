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
    JLabel score;
    JButton playAgainButton;


    public End(Integer UserScore){
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(0,1));

        score = new JLabel("Your score is " + UserScore);
        contentPane.add(score);

        this.playAgainButton = new JButton("Play Again!");
        contentPane.add(playAgainButton);
        playAgainButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Game();
    }
}
