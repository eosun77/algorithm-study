package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2562_최댓값 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[9];
		
		for (int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		int max = Integer.MIN_VALUE;
		int maxi = 0;
		for (int i = 0; i < 9; i++) {
			if(max<num[i]) {
				max = num[i];
				maxi = i;
			}
		}
		
		System.out.println(max);
		System.out.println(maxi+1);
	}

}
