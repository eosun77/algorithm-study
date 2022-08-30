package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2884_알람시계 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if (M >= 45)
			M -= 45;
		else {
			H -= 1;
			M = 15 + M;
		}
		if(H==-1) H=23;
		System.out.println(H + " " + M);
	}
}
