package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987_알파벳 {
	static int[][] map;
	static int R, C;
	static int MAX = 0;
	static boolean[] used = new boolean[26];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			str = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j)-'A';
			}
		}
		moveNext(0, 0, 0);
		System.out.println(MAX);

	}

	static void moveNext(int x, int y, int cnt) {

		if (used[map[x][y]]) {
			MAX = Math.max(MAX, cnt);
			return;
		} else {
			used[map[x][y]] = true;
			for (int i = 0; i < 4; i++) {
				int cx = x + dr[i];
				int cy = y + dc[i];

				if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
					moveNext(cx, cy, cnt + 1);
				}

			}
			used[map[x][y]] = false;
		}

	}

}
