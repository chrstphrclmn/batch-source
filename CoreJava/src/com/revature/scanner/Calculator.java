package com.revature.scanner;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        startCalculator();
    }

    private static void startCalculator() {

        try (Scanner reader = new Scanner(System.in)) {
            Double previous = Double.MIN_VALUE;
            Outer:
            while (true) {
                showMenu();

                System.out.println("Select an operation and press enter");
                String operationCase = reader.next();

                String[] caseArray = {"S", "A", "M", "D","P","Sr", "E"};
                boolean operationExists = Arrays.stream(caseArray).anyMatch(a -> operationCase.equalsIgnoreCase(a));
                if (!operationExists) {
                    System.out.println("Not a valid operation, please reselect \n");
                    continue;
                } else if (operationCase.equalsIgnoreCase("E")) {
                    System.out.println("Exiting application...");
                    break Outer;
                }

                System.out.println("Type first operand and press enter (enter 'previous' to use the last calculated result)");
                Double operand1 = checkNext(reader, previous);
                if (operationCase.equalsIgnoreCase("Sr")) {
                    previous = calculateAndDisplayResult(operationCase, operand1);
                } else {
                    System.out.println("Type second operand and press enter");
                    Double operand2 = reader.nextDouble();

                    if (operationCase.equalsIgnoreCase("D")) {
                        while (operand2 == 0) {
                            System.out.println("Cannot divide by zero please enter a different operand");
                            System.out.println("Type second operand and press enter");
                            operand2 = reader.nextDouble();
                        }
                    }
                    previous = calculateAndDisplayResult(operationCase, operand1, operand2);
                }
            }
        } catch (Exception e) {
            System.out.println("An error occured in class " + e.getClass() + ": " + e + "\n Exiting application...");
        }
    }

    private static Double checkNext(Scanner reader, Double previous) {
        Double operand1;
        boolean old = false;
        while (!reader.hasNextDouble()) {
            if(reader.hasNext("previous")){
                old = true;
                reader.next();
                break;
            }else{
                reader.next();
                System.out.println("Please use a number");
            }
        }
        operand1 =  old ? previous : reader.nextDouble();
        return operand1;
    }

    private static Double calculateAndDisplayResult(String operationCase, Double... args) {
        Double result = Double.MIN_VALUE;
        if (args.length == 1) {
            result = Math.sqrt(args[0]);
            System.out.println("Square root of " + args[0] + " = " + result);
        } else {
            String operation = "";
            Double operand1 = args[0];
            Double operand2 = args[1];
            switch (operationCase.toUpperCase()) {

                case "S":
                    result = operand1 - operand2;
                    operation = " - ";
                    break;
                case "A":
                    result = operand1 + operand2;
                    operation = " + ";
                    break;
                case "M":
                    result = operand1 * operand2;
                    operation = " * ";
                    break;
                case "D":
                    result = operand1 / operand2;
                    operation = " / ";
                    break;
                case "P":
                    result = Math.pow(operand1, operand2);
                    operation = " ^ ";
                    break;
            }
            System.out.println(operand1 + operation + operand2 + " = " + result);
        }
        return result;
    }

    private static void showMenu() {
        System.out.println("|   Java Calculator        |");
        System.out.println("| Operations:              |");
        System.out.println("|        S. Subtract       |");
        System.out.println("|        A. Add            |");
        System.out.println("|        M. Multiply       |");
        System.out.println("|        D. Divide         |");
        System.out.println("|        P. Power          |");
        System.out.println("|        Sr. Sqrt          |");
        System.out.println("|        E. Exit           |");
    }
}
