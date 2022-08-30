package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2439_별찍기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i -1 ; j++) {
				System.out.printf(" ");
			}
			for (int j = 0; j < i +1 ; j++) {
				System.out.printf("*");
			}
			System.out.println("");
			
		}
	}

}
