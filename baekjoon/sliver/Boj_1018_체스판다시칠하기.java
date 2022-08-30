package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018_체스판다시칠하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			str = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int min = Integer.MAX_VALUE;
		int cnt;

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				cnt = 0;
				for (int k = i; k < 8 + i; k++) {
					for (int l = j; l < 8 + j; l++) {
						if (map[i][j] == 'B') {
							if ((k + l) % 2 == (i + j) % 2 && map[k][l] == 'W')
								cnt++;
							else if ((k + l) % 2 == (i + j + 1) % 2 && map[k][l] == 'B')
								cnt++;
						} else if (map[i][j] == 'W') {
							if ((k + l) % 2 == (i + j) % 2 && map[k][l] == 'B')
								cnt++;
							else if ((k + l) % 2 == (i + j + 1) % 2 && map[k][l] == 'W')
								cnt++;
						}
					}
				}
				if (min > cnt)
					min = cnt;
				cnt = 0;
				for (int k = i; k < 8 + i; k++) {
					for (int l = j; l < 8 + j; l++) {
						if (map[i][j] == 'B') {
							if ((k + l) % 2 == (i + j) % 2 && map[k][l] == 'B')
								cnt++;
							else if ((k + l) % 2 == (i + j + 1) % 2 && map[k][l] == 'W')
								cnt++;
						} else if (map[i][j] == 'W') {
							if ((k + l) % 2 == (i + j) % 2 && map[k][l] == 'W')
								cnt++;
							else if ((k + l) % 2 == (i + j + 1) % 2 && map[k][l] == 'B')
								cnt++;
						}
					}
				}
				if (min > cnt)
					min = cnt;
			}
		}
		System.out.println(min);

	}
}
