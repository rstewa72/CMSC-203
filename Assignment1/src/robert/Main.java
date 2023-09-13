package robert;

import java.util.Scanner;

/*
 * Class: CMSC203
 * Instructor: Ahmed Tarek
 * Description: A program that tests a user’s "ESP". The 
 * program picks colors from a predefined set and challenges 
 * the user to guess the color picked. After 10 rounds, the 
 * program displays to the user how many times they guessed 
 * correctly. 
 * Due: 09/12/2023
 * Platform/Compiler: Windows/openjdk 17.0.1 2021-10-19
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or 
 * any source. I have not given my code to any student.
 * - Robert Stewart
 */
public class Main
{
	public static void main(String[] args)
	{	
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String userName = scn.nextLine();
		System.out.print("Describe yourself: ");
		String userDescription = scn.nextLine();
		System.out.print("Due Date: ");
		String dueDate = scn.nextLine();
		
		int roundNumber = 1;
		int correctGuesses = 0;
		int number = 0;
		String input = null;
		
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		
		while (roundNumber <= 10) {
			number = (int) (Math.random() * 7 + 1);
			System.out.println("Round " + roundNumber);
			System.out.println();
			System.out.println("I am thinking of a color.");
			System.out.println("Is it Red, Green, Blue, Yellow, Purple, Brown, or Cyan?");
			System.out.println("Enter your guess:");
			
			boolean validInput;
			do {
				input = scn.nextLine().toLowerCase();
				validInput = true;
				
				if (input.equals("red")) {
					if (number == 1) correctGuesses++;
				}
				else if (input.equals("green")) {
					if (number == 2) correctGuesses++;
				}
				else if (input.equals("blue")) {
					if (number == 3) correctGuesses++;
				}
				else if (input.equals("yellow")) {
					if (number == 4) correctGuesses++;
				}
				else if (input.equals("purple")) {
					if (number == 5) correctGuesses++;
				}
				else if (input.equals("brown")) {
					if (number == 6) correctGuesses++;
				}
				else if (input.equals("cyan")) {
					if (number == 7) correctGuesses++;
				}
				else {
					System.out.println("You entered an incorrect color.");
					System.out.println("Enter your guess again: ");
					validInput = false;
				}
			} while (!validInput);
			
			// Switch expression, Java 12+
			String colorName = switch (number) {
				case 1 -> "Red";
				case 2 -> "Green";
				case 3 -> "Blue";
				case 4 -> "Yellow";
				case 5 -> "Purple";
				case 6 -> "Brown";
				case 7 -> "Cyan";
				default -> null;
			};
			
			System.out.println("I was thinking of " + colorName + ".");
			
			roundNumber++;
		}
		
		System.out.println("Game Over");
		System.out.println();
		System.out.println("You guessed " + correctGuesses + " out of 10 colors "
				+ "correctly.");
		System.out.println();
		System.out.println("User Name: " + userName);
		System.out.println("User Description: " + userDescription);
		System.out.println("Due Date: " + dueDate);
		
		System.out.println("Programmer: Robert Stewart");
	}
}
