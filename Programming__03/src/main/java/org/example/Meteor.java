package org.example;

import java.awt.*;
import java.util.Random;

public class Meteor {

    public static final int SIZE = 30;
    private int x;
    private int y;

    public Meteor() {
        randomXY();
    }

    public void paint(Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillOval(x,y, SIZE, SIZE);
    }

    public void randomXY(){
        Random random = new Random();
        this.x = random.nextInt(Window.WINDOW_WIDTH);
        this.y = random.nextInt(-Window.WINDOW_HEIGHT, -SIZE);
    }

    public void fall(){
        if(this.y<=Window.WINDOW_HEIGHT)
            this.y++;
        else {
            randomXY();
        }
    }

    public Rectangle getMeteorAsRectangel(){
        return new Rectangle(this.x,
                this.y,
                this.SIZE,
                this.SIZE);

    }



}
