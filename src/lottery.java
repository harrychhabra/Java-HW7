//package lotterySystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class lottery {
	ArrayList<Integer> lotteryNumber = new ArrayList<Integer>(5);
	ArrayList<Integer> lotteryPick = new ArrayList<Integer>(5);

	// function to assign lottery number
	// by generating random integer between 0 to 9
	public void AssignLotteryNumber() {
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			lotteryNumber.add(random.nextInt(10));
		}
	}

	// function to assign lottery pick which is entered by user
	public void AssignLotteryPick() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 5 number");
		for (int i = 0; i < 5; i++) {
			lotteryPick.add(input.nextInt());
		}
		input.close();
	}

	// function to compare the corresponding elements in the two arrays and
	// returns the number of digits that match
	public int match() {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (lotteryNumber.get(i) == lotteryPick.get(i)) {
				count++;
			}
		}
		return count;
	}

	// function to display lottery number which is randomly generated
	public void displayLotteryNumber() {
		System.out.print("\nLottery Number :    ");
		for (int i = 0; i < 5; i++) {
			System.out.print(lotteryNumber.get(i) + " ");
		}
	}

	// function to display lottery pick which is taken from user
	public void displayLotteryPick() {
		System.out.print("\nUser lottery Pick : ");
		for (int i = 0; i < 5; i++) {
			System.out.print(lotteryPick.get(i) + " ");
		}
	}

	public static void main(String[] arg) {
		// object of lottery class
		lottery Lottery = new lottery();
		// generate array of 5 random integer (0-9)
		Lottery.AssignLotteryNumber();
		// take array of 5 integer (0-9) from user
		Lottery.AssignLotteryPick();
		// display lottery number
		Lottery.displayLotteryNumber();
		// display lottery pick taken from user
		Lottery.displayLotteryPick();
		System.out.println("\nNumber of digit match : " + Lottery.match());
		// If all of the digits match,
		// display a message proclaiming the user a grand prize winner
		if (Lottery.match() == 5) {
			System.out.println("grand prize winner");
		}
	}
}
