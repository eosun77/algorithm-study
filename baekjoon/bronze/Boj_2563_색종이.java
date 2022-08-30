package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int cnt = 0;
		boolean[][] paper = new boolean[100][100];
		for (int i = 0; i < n; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int pX = Integer.parseInt(st.nextToken());
			int pY = Integer.parseInt(st.nextToken());
			for (int x = pX; x < pX + 10; x++) {
				for (int y = pY; y < pY + 10; y++) {
					paper[x][y] = true;
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j])
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
