package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3109_빵집_x {
	static int R;
	static int C;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			str = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		pipeline(map, 0, 0, 0);
	}

	static void pipeline(char[][] map, int x, int y, int depth) {

		if (y == C - 1) {
			pipeline(map, depth+1, 0, depth+1);
			return;
		}
		if (depth == R) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		map[depth][0] = '=';
		for (int i = 0; i < 3; i++) {
			int[] dr = { 1, 0, -1 };
			int cx = x + dr[i];
			int cy = y + 1;
			if (cx < R && cy < C && cx >= 0 && cy >= 0 && map[cx][cy] == '.') {
				map[cx][cy] = '=';
				pipeline(map, cx, cy, depth);
				map[cx][cy] = '.';
			}
			else {
				pipeline(map, depth+1, 0, depth+1);
			}
		}
	}

}
