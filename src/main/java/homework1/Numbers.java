package homework1;

import java.util.Random;
import java.util.Scanner;

public class Numbers {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random rnd = new Random();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Let the game begin!");

        //Array of numbers entered by the user
        int[] inputNum = new int[15];
        String[][] yearOfEvents = {{"476", "1914", "1939"},
                {"End of Rome Empire", "World War I Begin", "World War II Begin"}};

        int index = rnd.nextInt(3);
        System.out.println("When " + yearOfEvents[1][index] + "?");

        //this is for simple guess -->
        int predictNum = rnd.nextInt(100);

        guessNum(name, index, yearOfEvents, inputNum);
        //guessNumSimple(name, predictNum, inputNum);
        sortArray(inputNum);
    }

    /**
     * This method describes all the basic work and logic of the game(Guessing dates of some Events)
     */
    public static void guessNum(String name, int index, String[][] events, int[] inputNum) {
        int i = 0;
        int attempts = inputNum.length;

        while (true) {
            correctness(inputNum, i);
            if (inputNum[i] == Integer.parseInt(events[0][index])) {
                System.out.println("Congratulations, " + name + "!");
                break;
            } else if (inputNum[i] > Integer.parseInt(events[0][index])) {
                System.out.println("Your number is too big. Please, try again");
            } else if (inputNum[i] < Integer.parseInt(events[0][index])) {
                System.out.println("Your number is too small. Please, try again.");
            }
            //Check if attempts over or not
            if (attempts > 1) {
                i++;
                attempts--;
                System.out.println("Attempts left: " + attempts);
            } else {
                System.out.println("Game over. The guessed year is: " + events[0][index]);
                break;
            }
        }
    }

    /**
     * This method describes all the basic work and logic of the game (Simple logic)
     */
    public static void guessNumSimple(String name, int rndNum, int[] inputArr) {
        int i = 0;

        while (true) {
            correctness(inputArr, i);
            if (inputArr[i] == rndNum) {
                System.out.println("Congratulations, " + name + "!");
                break;
            } else if (inputArr[i] > rndNum) {
                System.out.println("Your number is too big. Please, try again");
            } else if (inputArr[i] < rndNum) {
                System.out.println("Your number is too small. Please, try again.");
            }
            i++;
        }
    }

    /**
     * This method sorts the array of numbers, entered by the user, in descending order
     */
    public static void sortArray(int[] inputArr) {
        int tmp;
        System.out.print("Your numbers: ");
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                if (inputArr[j] > inputArr[i]) {
                    tmp = inputArr[i];
                    inputArr[i] = inputArr[j];
                    inputArr[j] = tmp;
                }
            }
            System.out.print(inputArr[i] + " ");
        }
    }

    /**
     * Check for correctness of the data
     */
    public static void correctness(int[] inputArr, int i) {
        while (inputArr[i] == 0) {
            String buffer = scanner.nextLine();
            try {
                inputArr[i] = Integer.parseInt(buffer);
            } catch (Exception e) {
                System.out.println("Wrong input. Please, try again");
            }
        }
    }
}