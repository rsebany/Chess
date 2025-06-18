package main;

import java.awt.*;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame(); // create new window
        frame.getContentPane().setBackground(new Color(60, 60, 60));
        frame.setLayout(new GridBagLayout());
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setLocationRelativeTo(null);


        Board board = new Board(); // create a new chessboard
        frame.add(board);

        frame.setVisible(true); // make it visible to the user

    }

}
