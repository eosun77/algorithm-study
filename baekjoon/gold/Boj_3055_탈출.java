package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3055_탈출 {
	static int R, C;
	static char[][] map;
	static int[][] waterTime;
	static int[][] hedgehogTime;

	static class Water {
		int x;
		int y;

		public Water(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static class Hedgehog {
		int x;
		int y;

		public Hedgehog(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		waterTime = new int[R][C];
		hedgehogTime = new int[R][C];
		ArrayList<Water> waters = new ArrayList<>();
		int x = 0;
		int y = 0;
		Hedgehog hedgehog = null;
		for (int i = 0; i < R; i++) {
			str = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				waterTime[i][j] = -1;
				hedgehogTime[i][j] = -1;
				if (map[i][j] == '*') {
					waters.add(new Water(i, j));
				} else if (map[i][j] == 'S') {
					hedgehog = new Hedgehog(i, j);
				} else if (map[i][j] == 'D') {
					x = i;
					y = j;
				}
			}
		}
		WaterMove(waters);
		HedgehogMove(hedgehog);
		if (hedgehogTime[x][y] == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(hedgehogTime[x][y]);
	}

	static void HedgehogMove(Hedgehog hedgehog) {

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };
		Queue<Hedgehog> q = new LinkedList<Hedgehog>();
		q.add(hedgehog);
		hedgehogTime[hedgehog.x][hedgehog.y] = 0;
		while (!q.isEmpty()) {
			Hedgehog h = q.poll();
			int x = h.x;
			int y = h.y;
			for (int i = 0; i < 4; i++) {
				int nx = h.x + dr[i];
				int ny = h.y + dc[i];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != 'X'
						&& (waterTime[nx][ny] > hedgehogTime[x][y] + 1 || waterTime[nx][ny] == -1)
						&& hedgehogTime[nx][ny] == -1) {
					hedgehogTime[nx][ny] = hedgehogTime[x][y] + 1;
					q.add(new Hedgehog(nx, ny));
				}
			}
		}
	}

	static void WaterMove(ArrayList<Water> waters) {

		int[] dr = { 1, -1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };
		Queue<Water> q = new LinkedList<Water>();
		for (int i = 0; i < waters.size(); i++) {
			q.add(waters.get(i));
			waterTime[waters.get(i).x][waters.get(i).y] = 0;
		}
		while (!q.isEmpty()) {
			Water w = q.poll();
			int x = w.x;
			int y = w.y;
			for (int i = 0; i < 4; i++) {
				int nx = w.x + dr[i];
				int ny = w.y + dc[i];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != 'X' && waterTime[nx][ny] == -1
						&& map[nx][ny] != 'D') {
					waterTime[nx][ny] = waterTime[x][y] + 1;
					q.add(new Water(nx, ny));
				}
			}
		}
	}
}
