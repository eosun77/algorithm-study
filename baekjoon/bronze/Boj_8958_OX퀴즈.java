package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_8958_OX퀴즈 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String[] str = new String[N];
		
		for (int tc = 0; tc < N; tc++) {
			str[tc]= in.readLine();
		}
		for (int tc = 0; tc < N; tc++) {
			int score = 0;
			int power = 1;
			for(int i =0; i<str[tc].length();i++) {
				char answer = str[tc].charAt(i);
				if(answer=='O') {
					score += power;
					power++;
				}
				else {
					power=1;
				}
			}
			System.out.println(score);
		}
	}

}
