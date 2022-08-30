package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BoJ_10818_최소최대{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int num[] = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int MAX = Integer.MIN_VALUE;
		int MIN = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			if(MAX < num[i]) {
				MAX = num[i];
			}
			if(MIN > num[i]) {
				MIN = num[i];
			}
		}
		
		System.out.println(MIN + " " + MAX);
		
		
	}
}
