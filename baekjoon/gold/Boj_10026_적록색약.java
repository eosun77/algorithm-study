package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10026_적록색약 {

	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		int[][] greed = new int[N][N];
		p = new int[N * N];
		int cnt=0;
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				greed[i][j] = str.charAt(j);
				p[(i * N) + j] = (i * N) + j;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (greed[i][j] == greed[i][j + 1]) {
					union((i * N) + j, (i * N) + j + 1);
				}
			}
		}
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N; j++) {
				if (greed[i][j] == greed[i + 1][j]) {
					union((i * N) + j, ((i + 1) * N) + j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(p[(i * N) + j] == (i * N) + j) cnt++;
			}
		}
		sb.append(cnt).append(" ");
		cnt=0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (greed[i][j] + greed[i][j + 1] == 'R' + 'G') {
					union((i * N) + j, (i * N) + j + 1);
				}
			}
		}
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N; j++) {
				if (greed[i][j] + greed[i+1][j] == 'R' + 'G') {
					union((i * N) + j, ((i + 1) * N) + j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(p[(i * N) + j] == (i * N) + j) cnt++;
			}
		}
		sb.append(cnt);
		System.out.print(sb);
	}

	static int FindSet(int x) {
		if (x == p[x])
			return x;
		return p[x] = FindSet(p[x]);
	}

	static void union(int x, int y) {
		if (FindSet(x) == FindSet(y))
			return;
		p[FindSet(y)] = FindSet(x);
	}
}
