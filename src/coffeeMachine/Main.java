package coffeeMachine;

import java.util.Scanner;

public class Main {
	final static Scanner scanner = new Scanner(System.in);
	static int water = 400, milk = 540, grams = 120, cupsDisp = 9, money = 550;
	
	public static void main(String[] args) {
		action();
    }
	
	static void machineInfo() {
		System.out.println("The coffee machine has: ");
		System.out.printf("%d of water\n", water);
		System.out.printf("%d of milk\n", milk);
		System.out.printf("%d of coffee beans\n", grams);
		System.out.printf("%d of disposable cups\n", cupsDisp);
		System.out.printf("%d of money\n", money);
	}
	static void action() {
		int exit = 0;
		while (exit == 0) {
			System.out.println("Write action (buy, fill, take, remaining, exit): ");
			String act = scanner.next();
			System.out.println();
			switch (act) {
			case "buy":
				buy();
				break;
			case "fill":
				fill();
				break;
			case "take":
				take();
				break;
			case "remaining":
				machineInfo();
				break;
			case "exit":
				exit = 1;
				break;
			}
			System.out.println();
		}
	}
	static void buy() {
		System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
		String choise = scanner.next();
		boolean tr = false;
		switch (choise) {
		case "1":
			tr = resources(250, 0, 16, 4);
			break;
		case "2":
			tr = resources(350, 75, 20, 7);
			break;
		case "3":
			tr = resources(200, 100, 12, 6);
			break;
		default :
			break;
		}
		if (tr) {
			System.out.println("I have enough resources, making you a coffee!");
		}
	}
	static boolean resources(int resWater, int resMilk, int resGrams, int valMoney) {
		if (water < resWater) {
			System.out.println("Sorry, not enough water!");
			return false;
		}
		else if (grams < resGrams) {
			System.out.println("Sorry, not enough grams!");
			return false;
		}
		else if (milk < resMilk) {
			System.out.println("Sorry, not enough milk!");
			return false;
		}
		else if (cupsDisp <= 0) {
			System.out.println("Sorry, not enough cups disponible!");
			return false;
		}
		else if (water >= resWater && milk >= resMilk && grams >= resGrams && cupsDisp > 0) {
			water -= resWater;
			milk -= resMilk;
			grams -= resGrams;
			cupsDisp --;
			money += valMoney;
			return true;
		}
		return false;
	}
	static void fill() {
		int inputVal;
		System.out.println("Write how many ml of water do you want to add: ");
		inputVal = scanner.nextInt();
		water += inputVal;
		System.out.println("Write how many ml of milk do you want to add: ");
		inputVal = scanner.nextInt();
		milk += inputVal;
		System.out.println("Write how many grams of coffee beans do you want to add: ");
		inputVal = scanner.nextInt();
		grams += inputVal;
		System.out.println("Write how many disposable cups of coffee do you want to add: ");
		inputVal = scanner.nextInt();
		cupsDisp += inputVal;
	}
	static void take() {
		System.out.println("i gave you $" + money);
		money = 0;
	}
}