package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    //todo Task 1
    public void largestNumber(){
        // input your solution here
        int inputCounterIndex = 1;
        double consoleInput;
        double biggestNumber = 0;
        Scanner consoleInputScanner = new Scanner(System.in);


        while (true) {
            System.out.print("Number " + inputCounterIndex + ": ");
            consoleInput = consoleInputScanner.nextDouble();

            if (consoleInput <= 0) {
                if (inputCounterIndex == 1) {
                    System.out.println("No number entered.");
                    break;
                }
                else {
                    System.out.printf("The largest number is %.2f" + System.lineSeparator(), biggestNumber);
                    break;
                }
            }
            else if (biggestNumber < consoleInput) {
                biggestNumber = consoleInput;
            }

            inputCounterIndex++;
        }
    }

    //todo Task 2
    public void stairs(){
        // input your solution here
        int rowQuantity;
        int counter = 0;
        Scanner consoleInput = new Scanner(System.in);


        System.out.print("n: ");
        rowQuantity = consoleInput.nextInt();

        if (rowQuantity <= 0) {
            System.out.println("Invalid number!");
        }
        else {
            for (int i = 1; i <= rowQuantity; i++) {
                for (int j = 1; j <= i; j++) {
                    counter++;
                    System.out.print((counter) + " ");
                }
                System.out.print(System.lineSeparator());
            }
        }
    }

    //todo Task 3
    public void printPyramid(){
        // input your solution here
        final int ROWQUANTITY = 6;


        //Jede Zeile kommt auf einer Hälfte der Pyramide ein Sternchen hinzu, dh es muss ein Leerzeichen verschwinden
        //In der letzten Zeile sind genau so viele Sternchen hinzugekommen wie es (Zeilen - 1) gibt.
        //In der ersten Zeile gibt es kein Sternchen auf einer der Hälften
        // In letzten Zeile gibt es keine Leerzeichen

        //Sternchen_Einseitig(i) = 1 + (i - 1)
        //Sternchen_Zweiseitig(i) = 1 + (i - 1) * 2
        //Leerzeichen_Einseitig(i) = Zeilenanzahl - i

        for (int z = 1; z <= ROWQUANTITY; z++) {
            for (int whitespace = (ROWQUANTITY - z); whitespace > 0; whitespace--) {
                System.out.printf(" ");
            }
            for (int sternchen = 1; sternchen <= (1 + (z - 1) * 2); sternchen++) {
                System.out.printf("*");
            }
            System.out.printf(System.lineSeparator());
        }
    }

    //todo Task 4
    public void printRhombus(){
        // input your solution here
        int h;
        char c;
        int grenze;
        Scanner consoleInput = new Scanner(System.in);


        System.out.print("h: ");
        h = consoleInput.nextInt();
        System.out.print("c: ");
        c = consoleInput.next().charAt(0);

        if (h % 2 == 0) {
            System.out.println("Invalid number!");
        }
        else {
            for (int z = - (h / 2); z <= (h / 2); z++) {
                for (int whitespace = 0; whitespace < (Integer.signum(z) * z); whitespace++) {
                    System.out.printf(" ");
                }
                grenze = (- (h / 2)) + (Integer.signum(z) * z);
                for (int s = grenze; s <= (Integer.signum(grenze) * grenze); s++) {
                    System.out.printf("%c", c - (Integer.signum(s) * s));
                }
                System.out.printf(System.lineSeparator());
            }
        }


    }

    //todo Task 5
    public void marks(){
        // input your solution here
        int inputCounterIndex = 1;
        int consoleInput;
        int gradeSum = 0;
        int negativeMarkCounter = 0;
        double averageGrade;
        Scanner consoleInputScanner = new Scanner(System.in);

        outer:
        while (true) {
            System.out.print("Mark " + inputCounterIndex + ": ");
            consoleInput = consoleInputScanner.nextInt();


            switch (consoleInput) {
                case 0:
                    if (inputCounterIndex == 1) {
                        averageGrade = 0;
                    }
                    else {
                        averageGrade = (double) gradeSum / (inputCounterIndex - 1);
                    }
                        System.out.printf("Average: %.2f" + System.lineSeparator(), averageGrade);
                        System.out.println("Negative marks: " + negativeMarkCounter);
                        break outer;
                case 1:
                case 2:
                case 3:
                case 4:
                    gradeSum = gradeSum + consoleInput;
                    inputCounterIndex++;
                    break;
                case 5:
                    gradeSum = gradeSum + consoleInput;
                    negativeMarkCounter++;
                    inputCounterIndex++;
                    break;
                default:
                    System.out.println("Invalid mark!");
            }
        }
    }

    //todo Task 6
    public void happyNumbers(){
        // input your solution here
        int tempNumber;
        ArrayList<Integer> digitsReverse = new ArrayList<>();
        Scanner consoleInputScanner = new Scanner(System.in);

        System.out.print("n: ");
        tempNumber = consoleInputScanner.nextInt();

        while (true) {
            while (0 < tempNumber) {
                digitsReverse.add(tempNumber % 10);
                tempNumber = tempNumber / 10;
            }

            for (int i = 0; i < digitsReverse.size(); i++) {
                tempNumber = tempNumber + (digitsReverse.get(i)) ^ 2;
            }

            digitsReverse.clear();

            if(tempNumber == 1) {
                System.out.println("Happy number!");
                break;
            }
            if(tempNumber == 4) {
                System.out.println("Sad number!");
                break;
            }
        }
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}