package com.example.b4934.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.b4934.utils.Constants;

public abstract class MovingCharacterSprite implements Comparable<MovingCharacterSprite> {
    protected Bitmap[] images;
    protected int x, y;
    protected int xVelocity = 10;
    protected int yVelocity = 10;
    protected int currFrame = 0;
    public int weight = 0;


    public MovingCharacterSprite(Bitmap[] bmp) {
        images = bmp;
        x = 50;
        y = Constants.screenHeight / 2;

    }

    @Override
    public int compareTo(MovingCharacterSprite o) {

        if (o.getWeight() == getWeight()) return 0;
        else if (getWeight() > o.getWeight()) return 1;
        return -1;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(images[currFrame], x, y, null);

    }

    abstract public void update();

    public int getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rect getRect() {
        return new Rect(x, y, x + images[currFrame].getWidth(), y + images[currFrame].getHeight());
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
