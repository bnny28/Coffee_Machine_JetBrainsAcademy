package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        String action;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            switch (action) {
                case "buy": {
                    buy();
                    break;
                }
                case "fill": {
                    fill();
                    break;
                }
                case "take": {
                    take();
                    break;
                }
                case "remaining": {
                    remaining();
                }
            }
        } while (!"exit".equals(action));
    }

    private static void remaining() {
        printCurrentState();
    }

    private static void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String kindCoffee = scanner.nextLine().trim();
        if ("1".equals(kindCoffee) || "2".equals(kindCoffee) || "3".equals(kindCoffee)) {
            cook(Integer.parseInt(kindCoffee));
        } else {
            if (!"back".equals(kindCoffee)) {
                buy();
            }
        }
    }

    private static void take() {
        System.out.printf("I gave you $%d\n\n", money);
        correctResources(0, 0, 0, 0, -money);
    }

    private static void fill() {
        System.out.println("\nWrite how many ml of water do you want to add:");
        correctResources(scanner.nextInt(), 0, 0, 0, 0);
        System.out.println("Write how many ml of milk do you want to add:");
        correctResources(0, scanner.nextInt(), 0, 0, 0);
        System.out.println("Write how many grams of coffee beans do you want to add:");
        correctResources(0, 0, scanner.nextInt(), 0, 0);
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        correctResources(0, 0, 0, scanner.nextInt(), 0);
        System.out.println();
    }

    private static boolean checkResources(int water, int milk, int beans) {
        if (CoffeeMachine.water < water) {
            System.out.println("Sorry, not enough water!\n");
            return false;
        }
        if (CoffeeMachine.milk < milk) {
            System.out.println("Sorry, not enough milk!\n");
            return false;
        }
        if (CoffeeMachine.beans < beans) {
            System.out.println("Sorry, not enough beans!\n");
            return false;
        }
        if (CoffeeMachine.cups < 1) {
            System.out.println("Sorry, not enough cups!\n");
            return false;
        }
        System.out.println("I have enough resources, making you a coffee!\n");
        return true;
    }

    private static void correctResources(int water, int milk, int beans, int cups, int money) {
        CoffeeMachine.water += water;
        CoffeeMachine.milk += milk;
        CoffeeMachine.beans += beans;
        CoffeeMachine.cups += cups;
        CoffeeMachine.money += money;
    }

    private static void cook(int kindCoffee) {
        switch (kindCoffee) {
            case 1: {
                if (checkResources(250, 0, 16)) {
                    correctResources(-250, 0, -16, -1, 4);
                }
                break;
            }
            case 2: {
                if (checkResources(350, 75, 20)) {
                    correctResources(-350, -75, -20, -1, 7);
                }
                break;
            }
            case 3: {
                if (checkResources(200, 100, 12)) {
                    correctResources(-200, -100, -12, -1, 6);
                }
            }
        }
    }

    private static void printCurrentState() {
        System.out.printf("\nThe coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d of money\n\n", water, milk, beans, cups, money);
    }
}
