package com.kodilla.rps;

public class Rules {

    public static final int[][] RPS_RULES = {
            {0, -1, 1},
            {1, 0, -1},
            {-1, 1, 0}
    };

    public static final int[][] RPSLS_RULES = {
            {0, -1, 1, 1, -1},
            {1, 0, -1, -1, 1},
            {-1, 1, 0, 1, -1},
            {-1, 1, -1, 0, 1},
            {1, -1, 1, -1, 0}
    };
}
