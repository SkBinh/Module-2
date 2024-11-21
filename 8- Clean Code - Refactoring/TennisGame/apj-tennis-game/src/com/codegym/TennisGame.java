package com.codegym;

public class TennisGame {

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "15";
    private static final String THIRTY = "30";
    private static final String FORTY = "40";
    private static final String LOVE_ALL = "Love";
    private static final String FIFTEEN_ALL = "15";
    private static final String THIRTY_ALL = "30";
    private static final String FORTY_ALL = "40";
    private static final String DEUCE = "Deuce";
    private static final String WIN_PLAYER1 = "Win for player1";
    private static final String WIN_PLAYER2 = "Win for player2";
    private static final String ADVANTAGE_PLAYER1 = "Advantage player1";
    private static final String ADVANTAGE_PLAYER2 = "Advantage player2";

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        if (isDraw(scorePlayer1, scorePlayer2)) {
            return getDrawScore(scorePlayer1);
        }

        if (hasWinner(scorePlayer1, scorePlayer2)) {
            return getWinnerScore(scorePlayer1, scorePlayer2);
        }

        return getRegularScore(scorePlayer1, scorePlayer2);
    }

    private static boolean isDraw(int scorePlayer1, int scorePlayer2) {
        return scorePlayer1 == scorePlayer2;
    }

    private static String getDrawScore(int score) {
        switch (score) {
            case 0:
                return LOVE_ALL;
            case 1:
                return FIFTEEN_ALL;
            case 2:
                return THIRTY_ALL;
            case 3:
                return FORTY_ALL;
            default:
                return DEUCE;
        }
    }

    private static boolean hasWinner(int scorePlayer1, int scorePlayer2) {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private static String getWinnerScore(int scorePlayer1, int scorePlayer2) {
        int scoreDifference = scorePlayer1 - scorePlayer2;

        if (scoreDifference == 1) return ADVANTAGE_PLAYER1;
        if (scoreDifference == -1) return ADVANTAGE_PLAYER2;
        if (scoreDifference >= 2) return WIN_PLAYER1;

        return WIN_PLAYER2;
    }

    private static String getRegularScore(int scorePlayer1, int scorePlayer2) {
        StringBuilder scoreBuilder = new StringBuilder();
        appendScore(scoreBuilder, scorePlayer1);
        scoreBuilder.append("-");
        appendScore(scoreBuilder, scorePlayer2);
        return scoreBuilder.toString();
    }

    private static void appendScore(StringBuilder scoreBuilder, int score) {
        switch (score) {
            case 0:
                scoreBuilder.append(LOVE);
                break;
            case 1:
                scoreBuilder.append(FIFTEEN);
                break;
            case 2:
                scoreBuilder.append(THIRTY);
                break;
            case 3:
                scoreBuilder.append(FORTY);
                break;
        }
    }
}