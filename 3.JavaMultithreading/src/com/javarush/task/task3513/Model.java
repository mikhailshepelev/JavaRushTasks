package com.javarush.task.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int maxTile;
    protected int score;
    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();

        if (emptyTiles.isEmpty()) {
            return;
        }

        int tileIndex = (int) (emptyTiles.size() * Math.random());
        int tileValue = Math.random() < 0.9 ? 2 : 4;

        Tile tile = emptyTiles.get(tileIndex);
        tile.value = tileValue;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();

        for (Tile[] rowOfTiles : gameTiles) {
            for (Tile tile : rowOfTiles) {
                if (tile.value == 0) {
                    list.add(tile);
                }
            }
        }

        return list;
    }

    protected void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        maxTile = 2;
        score = 0;

        for (Tile[] tiles : gameTiles) {
            Arrays.fill(tiles, new Tile());
        }

        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        int hash = Arrays.hashCode(tiles);
        Arrays.sort(tiles, Comparator.comparing(Tile::isEmpty));
        return hash != Arrays.hashCode(tiles);
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean arrayIsChanged = false;

        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i+1].value) {
                tiles[i].value = tiles[i].value * 2;
                tiles[i+1].value = 0;

                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
                if (tiles[i].value != 0) {
                    arrayIsChanged = true;
                }
                score += tiles[i].value;
                compressTiles(tiles);
            }
        }


        return arrayIsChanged;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) {
            return true;
        }

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j-1][i].value)return true;
            }
        }

        return false;
    }

    void left() {

        if (isSaveNeeded) {
            saveState(gameTiles);
        }

        boolean needToAdd = false;

        for (Tile[] tiles : gameTiles) {
            if (compressTiles(tiles) | mergeTiles(tiles)) {
                needToAdd = true;
            }
        }

        if (needToAdd) {
            addTile();
        }

        isSaveNeeded = true;
    }

    private void rotateToRight() {
        Tile tmp;
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH-j-1][i];
                gameTiles[FIELD_WIDTH-j-1][i] = gameTiles[FIELD_WIDTH-i-1][FIELD_WIDTH-j-1];
                gameTiles[FIELD_WIDTH-i-1][FIELD_WIDTH-j-1] = gameTiles[j][FIELD_WIDTH-i-1];
                gameTiles[j][FIELD_WIDTH-i-1] = tmp;
            }
        }
    }

    void right() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
    }
    void up() {
        saveState(gameTiles);
        rotateToRight();
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
    }
    void down() {
        saveState(gameTiles);
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
        rotateToRight();
    }

    private void saveState(Tile[][] gameTiles) {
        Tile[][] fieldCopy = new Tile[gameTiles.length][gameTiles.length];

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                fieldCopy[i][j] = new Tile(gameTiles[i][j].value);
            }
        }
        
        previousStates.push(fieldCopy);
        previousScores.push(score);

        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n) {
            case 0 :
                left();
                break;
            case 1 :
                right();
                break;
            case 2 :
                up();
                break;
            case 3 :
                down();
                break;
        }
    }

    public boolean hasBoardChanged() {
        Tile[][] previousState = previousStates.peek();

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (previousState[i][j].value != gameTiles[i][j].value) {
                    return true;
                }
            }
        }

        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();

        if (!hasBoardChanged()) {
            return new MoveEfficiency(-1, 0, move);
        }

        rollback();
        return new MoveEfficiency(getEmptyTiles().size(), score, move);
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));

        Objects.requireNonNull(queue.poll()).getMove().move();
    }
}
