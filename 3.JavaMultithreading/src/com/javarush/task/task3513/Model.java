package com.javarush.task.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    protected int maxTile;
    protected int score;

    public Model() {
        resetGameTiles();
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

    void left() {

        boolean needToAdd = false;

        for (Tile[] tiles : gameTiles) {
            if (compressTiles(tiles) | mergeTiles(tiles)) {
                needToAdd = true;
            }
        }

        if (needToAdd) {
            addTile();
        }
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
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
    }
    void up() {
        rotateToRight();
        rotateToRight();
        rotateToRight();
        left();
        rotateToRight();
    }
    void down() {
        rotateToRight();
        left();
        rotateToRight();
        rotateToRight();
        rotateToRight();
    }
}
