package org.example;

import java.awt.*;

public class Robot {

    public static final int HEAD_SIZE = 40;
    public static final int BODY_SIZE = 60;

    private MyRectangle head;
    private MyRectangle body;
    private MyRectangle leftFoot;
    private MyRectangle rightFoot;
    private boolean alive;

    public Robot(){
        this.head = new MyRectangle(Window.WINDOW_WIDTH/2-HEAD_SIZE/2, 9*Window.WINDOW_HEIGHT/12, HEAD_SIZE, HEAD_SIZE/2);
        this.body = new MyRectangle(this.head.getX()-(BODY_SIZE-this.head.getWidth())/2,this.head.getY()+this.head.getHeight(),BODY_SIZE,BODY_SIZE);
        this.alive =true;
    }



    public void paint(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(this.head.getX(),
                this.head.getY(),
                this.head.getWidth(),
                this.head.getHeight());
        g.fillRect(this.body.getX(),
                this.body.getY(),
                this.body.getWidth(),
                this.body.getHeight());

    }

    public Rectangle getHeadRobotAsRectangel(){
        return new Rectangle(this.head.getX(),
                this.head.getY(),
                this.head.getWidth(),
                this.head.getHeight());
    }
    public Rectangle getBodyRobotAsRectangel(){
        return new Rectangle(this.body.getX(),
                this.body.getY(),
                this.body.getWidth(),
                this.body.getHeight());

    }


    public void die(){
        this.alive=false;
    }
    public void dissmennal(){
        if (!alive) {
            this.head.moveLeft();
            this.head.moveUp();
            this.body.moveRight();
            this.body.moveDown();
        }
    }


}
