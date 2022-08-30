package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_햄버거다이어트 {

	static int MaxS;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		for (int t = 1; t <= tc; t++) {
			MaxS = 0;
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[] score = new int[n];
			int[] cal = new int[n];
			for (int i = 0; i < n; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			comb(score, cal, 0, n, 0, 0, l);
			sb.append("#").append(t).append(" ").append(MaxS).append("\n");
		}
		System.out.println(sb);

	}

	static void comb(int[] score, int[] cal, int depth, int n, int sumC, int sumS, int l) {

		if (sumC> l) {
			return;
		}
		if (n == depth) {
			MaxS = Integer.max(sumS, MaxS);
			return;
		}

		comb(score, cal, depth + 1, n, sumC + cal[depth], sumS + score[depth], l);
		comb(score, cal, depth + 1, n, sumC, sumS, l);
	}
}
