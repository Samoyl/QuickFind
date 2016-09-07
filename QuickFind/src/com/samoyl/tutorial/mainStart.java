package com.samoyl.tutorial;

import java.util.Scanner;

public class mainStart {

	public static void main(String[] args) {
		QuickUnionUF qu = new QuickUnionUF(10);
		Scanner input = new Scanner(System.in);
		String check;
		boolean loop = true;
		int aUnion;
		int bUnion;

		while (loop) {
			System.out.println("Please choose one of these alternatives:" + "\n" + "U = Unified tow numbers" + "\n"
					+ "C = Check tow numbers" + "\n" + "E = To exit from the program");
			check = input.next();
			if (check.equals("U") || check.equals("u")) {
				System.out.println("Enter two number to Unified:");
				aUnion = input.nextInt();
				bUnion = input.nextInt();
				System.out.println("Union (" + aUnion + ", " + bUnion + ")");
				qu.union(aUnion, bUnion);
			} else if (check.equals("C") || check.equals("c")) {
				System.out.println("Enter two number to Check if the have th same root:");
				aUnion = input.nextInt();
				bUnion = input.nextInt();
				System.out.println("Connected (" + aUnion + ", " + bUnion + ")");
				System.out.println(qu.connected(aUnion, bUnion));
			} else if (check.equals("E") || check.equals("e")) {
				loop = false;
				int i;
				for (i = 0 ; i < 10; i++) {
					System.out.print(i);
					if (i != 9) {
						System.out.print(", ");
					} else {
						System.out.println();
					}
				}
				i = 0;
				for (int id : qu.id) {
					
					System.out.print(id);
					if (i != 9) {
						System.out.print(", ");
					} else {
						System.out.println();
					}
					i++;
				}
				i = 0;
				for (int sz : qu.sz) {
				
					System.out.print(sz);
					if (i != 9) {
						System.out.print(", ");
					} else {
						System.out.println();
					}
					i++;
				}
				System.out.println("Bye Bye");
			}
			check = null;
		}
		input.close();

	}

}
