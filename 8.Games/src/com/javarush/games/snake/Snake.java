package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public void setDirection(Direction direction) {
        if (this.direction == Direction.LEFT && direction == Direction.RIGHT) {}
        else if (this.direction == Direction.RIGHT && direction == Direction.LEFT) {}
        else if (this.direction == Direction.UP && direction == Direction.DOWN) {}
        else if (this.direction == Direction.DOWN && direction == Direction.UP) {}
        else if (this.direction == Direction.LEFT && snakeParts.get(0).x == snakeParts.get(1).x) {}
        else if (this.direction == Direction.RIGHT && snakeParts.get(0).x == snakeParts.get(1).x) {}
        else if (this.direction == Direction.UP && snakeParts.get(0).y == snakeParts.get(1).y) {}
        else if (this.direction == Direction.DOWN && snakeParts.get(0).y == snakeParts.get(1).y) {}
        else this.direction = direction;
    }

    public Snake(int x, int y) {
        GameObject snakeHead = new GameObject(x, y);
        GameObject snakeMid = new GameObject(x + 1, y);
        GameObject snakeTail = new GameObject(x + 2, y);
        snakeParts.add(snakeHead);
        snakeParts.add(snakeMid);
        snakeParts.add(snakeTail);
    }

    public void draw(Game game) {
        if (isAlive) {
            game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, Color.BLACK, 75);
            for (int i = 1; i<snakeParts.size(); i++)
            game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.BLACK, 75);
        }
        else {
            game.setCellValueEx(snakeParts.get(0).x, snakeParts.get(0).y, Color.NONE, HEAD_SIGN, Color.RED, 75);
            for (int i = 1; i<snakeParts.size(); i++)
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, Color.RED, 75);
        }
    }

    public void move(Apple apple){
        GameObject newHead = createNewHead();
        if ((newHead.x >= SnakeGame.WIDTH || newHead.x <0) ||
                (newHead.y >= SnakeGame.HEIGHT || newHead.y <0)) isAlive = false;
        else if (newHead.x == apple.x && newHead.y == apple.y){
            if (checkCollision(newHead)) isAlive = false;
            else {
                apple.isAlive = false;
                snakeParts.add(0, newHead);
            }
        }
        else {
            if (checkCollision(newHead)) isAlive = false;
            else {
                snakeParts.add(0, newHead);
                removeTail();
            }
        }
    }

    public GameObject createNewHead(){
        if (direction == Direction.LEFT) return new GameObject(snakeParts.get(0).x-1, snakeParts.get(0).y);
        else if (direction == Direction.RIGHT) return new GameObject(snakeParts.get(0).x+1, snakeParts.get(0).y);
        else if (direction == Direction.DOWN) return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y+1);
        else if (direction == Direction.UP) return new GameObject(snakeParts.get(0).x, snakeParts.get(0).y-1);
        else return null;
    }

    public void removeTail(){
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision(GameObject gameObject){
        for (GameObject a : snakeParts){
            if (a.x == gameObject.x && a.y == gameObject.y) return true;
        }
        return false;
    }

    public int getLength(){
        return snakeParts.size();
    }
}
