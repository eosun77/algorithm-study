package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1003_피보나치함수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] fibo0 = new int[41];
		fibo0[0] = 1;
		fibo0[1] = 0;
		int[] fibo1 = new int[41];
		fibo1[0] = 0;
		fibo1[1] = 1;
		for(int i =2; i<41;i++) {
			fibo0[i] = fibo0[i-1] + fibo0[i-2];
			fibo1[i] = fibo1[i-1] + fibo1[i-2];
		}
		for (int tc = 0; tc < T; tc++) {
			int num = Integer.parseInt(in.readLine());
			System.out.println(fibo0[num] + " " + fibo1[num]);
		}
	}
}
