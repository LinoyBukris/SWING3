package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Screen1 extends JPanel {

    //פעם הבאה להוסיף משתנה קבוע לרוחב ולגובה של המסך
    //public static final int SCREEN_WIDTH;

    private ArrayList<Meteor> meteorsList;
    private Robot robot;
    public static final int MAX_METEORS = 15;


    public Screen1(int x, int y, int width, int height){
        this.setBounds(x,y,width,height);
        this.setBackground(Color.YELLOW);
        this.meteorsList = new ArrayList<>();
        for (int i=0; i<MAX_METEORS; i++) {
            meteorsList.add(new Meteor());
        }
        this.robot = new Robot();
        mainGameLoop();



    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Meteor meteor: this.meteorsList)
            meteor.paint(g);
        this.robot.paint(g);
    }

    public void mainGameLoop(){
        new Thread(()-> {
            while (true){
                try {
                    for (Meteor meteor: this.meteorsList){
                        meteor.fall();
                    }
                    repaint();
                    checkCollision();
                    this.robot.dissmennal();
                    Thread.sleep(7);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
}       }).start();
    }

    private boolean checkCollision(){
        boolean collision = false;
        for (Meteor meteor: meteorsList){
            if (meteor.getMeteorAsRectangel().intersects(this.robot.getHeadRobotAsRectangel()) ||
                    meteor.getMeteorAsRectangel().intersects(this.robot.getBodyRobotAsRectangel())){
                collision = true;
                System.out.println("collision");
            }
            if (collision){
                this.robot.die();
            }
        }
        return collision;
    }


}
