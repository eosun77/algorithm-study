package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11720_숫자의합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum += str.charAt(i)-'0';
		}
		System.out.println(sum);
	}

}
