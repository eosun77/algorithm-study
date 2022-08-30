package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10971_외판원순회2 {
	static int N;
	static int[][] W;
	static boolean[] isVisited;
	static int minPrice = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		W = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		isVisited = new boolean[N];
		CityVisit(0, 0, 0, 0);

		System.out.println(minPrice);
	}

	static void CityVisit(int start, int city, int w, int n) {

		if (minPrice < w)
			return;

		if (n == N - 1) {
			if (W[city][start] == 0)
				return;
			w += W[city][start];
			minPrice = Math.min(minPrice, w);
			return;
		}

		isVisited[city] = true;

		for (int i = 0; i < N; i++) {
			if (W[city][i] != 0 && !isVisited[i]) {
				w += W[city][i];
				CityVisit(start, i, w, n + 1);
				isVisited[i] = false;
				w -= W[city][i];
			}
		}

	}

}
