package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_4485_녹색옷입은애가젤다지 {
	static int[][] cave;
	static int N = 1;

	static class Rupee implements Comparable<Rupee> {
		int x;
		int y;
		int w;

		public Rupee(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Rupee o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		int cnt = 0;
		while (N != 0) {
			cnt++;
			cave = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(cnt).append(": ").append(CaveExplore()).append("\n");
			N = Integer.parseInt(in.readLine());
		}
		System.out.println(sb);
	}

	static int CaveExplore() {
		PriorityQueue<Rupee> pQ = new PriorityQueue<>();
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int[][] rupee = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(rupee[i], 9*N*N);
		}
		rupee[0][0] = cave[0][0];
		pQ.add(new Rupee(0, 0, rupee[0][0]));
		while (!pQ.isEmpty()) {
			Rupee r = pQ.poll();
			if (r.x == N - 1 && r.y == N - 1) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = r.x + dr[i];
				int ny = r.y + dc[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && rupee[nx][ny] > cave[nx][ny] + r.w) {
					rupee[nx][ny] = cave[nx][ny] + r.w;
					pQ.add(new Rupee(nx, ny, rupee[nx][ny]));
				}
			}
		}
		return rupee[N - 1][N - 1];
	}
}
