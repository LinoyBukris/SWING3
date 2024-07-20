package org.example;

import javax.swing.*;

public class Window extends JFrame {

    public static final int WINDOW_WIDTH = 850;
    public static final int WINDOW_HEIGHT=750;

    public Window(){
        this.setVisible(true);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        Screen1 screen1 = new Screen1(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);
        add(screen1);

    }


}
