package com.company.target.collections.ch04;

public class Hanoi {

	public void move(int n, char orig, char dest, char temp) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}

		if (n == 1) {
			System.out.println("Move disk 1 from " + orig + "to" + dest);
		} else {
			move(n - 1, orig, temp, dest);
			System.out.println("Move disk " + n + "from " + orig + "to" + dest);
			move(n - 1, temp, dest, orig);
		}
	}

}
