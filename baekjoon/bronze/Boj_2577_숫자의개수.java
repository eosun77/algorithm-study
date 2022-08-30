package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2577_숫자의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(in.readLine());
		int b = Integer.parseInt(in.readLine());
		int c = Integer.parseInt(in.readLine());

		int result = a * b * c;
		String strResult = Integer.toString(result);
		int[] cnt = { 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0};
		for (int i = 0; i < strResult.length(); i++) {
			cnt[strResult.charAt(i) - '0']++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(cnt[i]);
		}
	}

}
