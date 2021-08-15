package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private final static int GOAL = 25;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        score = 0;
        setScore(score);
        turnDelay = 300;
        setTurnTimer(turnDelay);
        Snake snake = new Snake(WIDTH/2, HEIGHT/2);
        this.snake = snake;
        createNewApple();
        isGameStopped = false;
        drawScene();

    }

    private void drawScene(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.BISQUE, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            createNewApple();
            setTurnTimer(turnDelay -= 10);
            setScore(score += 5);
        }
        if (!snake.isAlive) gameOver();
        if (snake.getLength()>GOAL) win();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) snake.setDirection(Direction.LEFT);
        else if (key == Key.RIGHT) snake.setDirection(Direction.RIGHT);
        else if (key == Key.DOWN) snake.setDirection(Direction.DOWN);
        else if (key == Key.UP) snake.setDirection(Direction.UP);
        else if (key == Key.SPACE && isGameStopped) createGame();
    }
    private void createNewApple(){
        while (true) {
            this.apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
            if (!snake.checkCollision(apple)) break;
        }
    }

    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "GAME OVER", Color.BLACK, 75);
    }

    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "YOU WIN", Color.GREEN, 75);
    }
}
