package de.homealone.game.statistic;


public class GameStatistic {

    private int draws;

    private int winsForPlayerOne;

    private int winsForPlayerTwo;

    public int getDraws() {
        return draws;
    }

    public void addDraw() {
        draws++;
    }

    public int getWinsForPlayerOne() {
        return winsForPlayerOne;
    }

    public int getWinsForPlayerTwo() {
        return winsForPlayerTwo;
    }

    public void addWinForPlayerOne() {
        winsForPlayerOne++;
    }

    public void addWinForPlayerTwo() {
        winsForPlayerTwo++;
    }
}
