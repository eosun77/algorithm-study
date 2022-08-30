package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj_16236_아기상어 {

	static class Shark {
		int x;
		int y;
		int size;
		int eat;
		int time;
		boolean flag = true;

		public Shark(int x, int y, int size, int eat, int time) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.eat = eat;
			this.time = time;
		}

	}

	static Shark baby;
	static int[][] sharkTime;
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		sharkTime = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				sharkTime[i][j] = -1;
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9)
					baby = new Shark(i, j, 2, 0, 0);
			}
		}

		while (baby.flag) {
			baby = SharkMove(baby);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(sharkTime[i][j] + "  ");
//				}
//				System.out.println();
//			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + "  ");
//				}
//				System.out.println();
//			}
//			System.out.println("eat : " + baby.eat + " size : " + baby.size + " time " + baby.time);
			Init();
		}
		System.out.println(baby.time);

	}

	static Shark SharkMove(Shark shark) {
		int[] dr = { -1, 0, 0, 1 };
		int[] dc = { 0, -1, 1, 0 };
		Queue<Shark> q = new LinkedList<>();
		q.add(shark);
		sharkTime[shark.x][shark.y] = shark.time;
		ArrayList<Shark> canEat = new ArrayList<>();
		int nowtime = -2;
		while (!q.isEmpty()) {
			Shark s = q.poll();
			if (s.time == nowtime + 1)
				break;
			for (int i = 0; i < 4; i++) {
				int nx = s.x + dr[i];
				int ny = s.y + dc[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] <= s.size && sharkTime[nx][ny] == -1) {
					if (map[nx][ny] == 0 || map[nx][ny] == s.size) {
						q.add(new Shark(nx, ny, s.size, s.eat, s.time + 1));
						sharkTime[nx][ny] = sharkTime[s.x][s.y] + 1;
					} else if (map[nx][ny] < s.size) {
						sharkTime[nx][ny] = sharkTime[s.x][s.y] + 1;
						canEat.add(new Shark(nx, ny, s.size, s.eat, s.time));
						nowtime = s.time;
					}
				}
			}
		}
		if (!canEat.isEmpty()) {
			Collections.sort(canEat, new Comparator<Shark>() {

				@Override
				public int compare(Shark o1, Shark o2) {
					if (o1.x != o2.x) {
						return o1.x - o2.x;
					} else
						return o1.y - o2.y;
				}
			});
			Shark s = canEat.get(0);
			map[s.x][s.y] = 9;
			map[shark.x][shark.y] = 0;
			s.eat++;
			s.time++;
			if (s.eat == s.size) {
				s.eat = 0;
				s.size++;
			}
			return canEat.get(0);
		} else {
			shark.flag = false;
			return shark;
		}
	}

	static void Init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sharkTime[i][j] = -1;
			}
		}
	}

}
