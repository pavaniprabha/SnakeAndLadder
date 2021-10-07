package com.blz;

import java.util.Random;

public class SankeAndLadder {

	public static Random random = new Random();
    public static int diceRoll, slnp, player, turns1,turns2, player1,turns;

    public static void main(String[] args) {
        Loop();

    }

    public static void Dice() {
        turns = turns + 1;
        int temp = random.nextInt(6);
        diceRoll = temp + 1;
    }

    public static void SLNP() {
        int temp = random.nextInt(3);
        slnp = temp + 1;
        if (slnp == 1) {// No play
            SLNP1();
        } else if (slnp == 2) {// Snake
            turns1=turns1+1;
            Dice();
            player = player + diceRoll;
        } else {
            turns1=turns1+1;
            Dice();
            player = player - diceRoll;
            if (player < 0) {
                player = 0;
            }
            SLNP1();
        }
    }

    public static void SLNP1() {
        int temp = random.nextInt(3);
        slnp = temp + 1;
        if (slnp == 1) {// No play

        } else if (slnp == 2) {// Snake
            turns2=turns2+1;
            Dice();
            player1 = player1 + diceRoll;
        } else {
            turns2=turns2+1;
            Dice();
            player1 = player1 - diceRoll;
            if (player1 < 0) {
                player1 = 0;
            }
        }
    }

    public static void Loop() {
        while (player < 100 || player1 < 100) {
            SLNP();
        }
        if (player == 100) {
            System.out.println("Player 1 WINS");
            System.out.println("Total Dice rolls by player 1 : " + turns1);
            System.out.println("Total Dice rolls by player 2 : " + turns2);
            System.out.println("Total dice rolled : "+ turns);
        } else if (player1 == 100) {
            System.out.println("Player 2 WINS");
            System.out.println("Total Dice rolls by player 1 : " + turns1);
            System.out.println("Total Dice rolls by player 2 : " + turns2);
            System.out.println("Total dice rolled : "+ turns);
        } else if (player > 100) {
            player = player - diceRoll;
            Loop();
        } else if (player1 > 100) {
            player1 = player1 - diceRoll;
            Loop();
        }

    }
}
