package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(in.readLine());
		int[] dest = new int[n];
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			dest[i] = Integer.parseInt(in.readLine());
			num[i] = i+1;
		}
	
		System.out.println(sb);
	}

}
