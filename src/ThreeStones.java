/**
 * Created by java on 2/28/2016.
 */

import java.util.Random;
import java.util.Scanner;

public class ThreeStones {
    public void startGame() {
        int P1StoneNum = 3;
        int P2StoneNum = 3;
        int StoneSum = 0;
        int a, b = 0;
        Random randomGenerator = new Random();
        boolean turn = randomGenerator.nextBoolean(); //false = P1's turn  //true = P2's turn
        do {
            a = getPickUpInfo("1", P1StoneNum);
            b = getPickUpInfo("2", P2StoneNum);
            StoneSum = a + b;
            int[] A = new int[2];
            A = getGuessingInfo(turn);
            if (A[0] == StoneSum) {
                P1StoneNum--;
                System.out.println("Player 1 guessed correctly, now he has only " + P1StoneNum + " stones");
            } else {
                if (A[1] == StoneSum) {
                    P2StoneNum--;
                    System.out.println("Player 2 guessed correctly, now he has only " + P2StoneNum + " stones");
                } else {
                    System.out.println("Nobody guessed correctly!");
                }
            }
            turn = !turn;
        } while (P1StoneNum > 0 && P2StoneNum > 0);
        if (P1StoneNum == 0) {
            System.out.println("Player 1 won the game!!!Congratulations!!!");
        } else {
            System.out.println("Player 2 won the game!!!Congratulations!!!");
        }
    }

    public int getPickUpInfo(String s, int StonesNum) {
        int PickedUpStones = 0;
        System.out.println("Player " + s + ", please write down the number of stones you would like to pick up");
        System.out.println("Another player, please move away from the screen!");
        Scanner scan = new Scanner(System.in);
        do {
            PickedUpStones = scan.nextInt();
            if(PickedUpStones > StonesNum || PickedUpStones < 0){
                System.out.println("Error, write number from 0 to "+StonesNum);
            }
        } while (PickedUpStones > StonesNum || PickedUpStones < 0);
        for (int i = 0; i < 20; ++i) System.out.println();
        return PickedUpStones;
    }

    public int[] getGuessingInfo(boolean turn) {
        int[] guessings = {0, 0};
        Scanner scan = new Scanner(System.in);

        if (turn == false) {
            System.out.println("Player 1, please insert your prediction on how many stones you have all together");
            guessings[0] = scan.nextInt();
            System.out.println("Player 2, please insert your prediction on how many stones you have all together. The number should not be equal to " + guessings[0]);
            do {
                guessings[1] = scan.nextInt();
                if(guessings[1] == guessings[0]){
                    System.out.println("Choose something else");
                }
            } while (guessings[1] == guessings[0]);

        } else {
            System.out.println("Player 2, please insert your prediction on how many stones you have all together");
            guessings[1] = scan.nextInt();
            System.out.println("Player 1, please insert your prediction on how many stones you have all together. The number should not be equal to " + guessings[1]);
            do {
                guessings[0] = scan.nextInt();
                if(guessings[1] == guessings[0]){
                    System.out.println("Choose something else");
                }
            } while (guessings[1] == guessings[0]);
        }
        return guessings;
    }

    public static void main(String[] args) {
        ThreeStones NewStones = new ThreeStones();
        NewStones.startGame();
    }
}
