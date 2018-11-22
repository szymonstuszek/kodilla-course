package com.kodilla.rps;

public class Rules {

    public static final int[][] rpsRules = {
            {0, -1, 1},
            {1, 0, -1},
            {-1, 1, 0}
    };

    public static final int[][] rpslsRules = {
            {0, -1, 1, 1, -1},
            {1, 0, -1, -1, 1},
            {-1, 1, 0, 1, -1},
            {-1, 1, -1, 0, 1},
            {1, -1, 1, -1, 0}
    };
}
