package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		int max = Integer.MIN_VALUE;
		char maxalpa = 0;
		char[] words = new char[str.length()];
		for (int i = 0; i < words.length; i++) {
			words[i] = str.charAt(i);
			if(words[i]>'Z') {
				words[i] -=32;
			}
		}
		for (int i = (int)'A'; i <= (int)'Z'; i++) {
			int cnt=0;
			for (int j = 0; j < words.length; j++) {
				if(words[j]==i) cnt++;
			}
			if(max < cnt) {
				max = cnt;
				maxalpa = (char) i;
			} else if(max == cnt) maxalpa = '?'; 
		}
		System.out.println(maxalpa);
	}

}
