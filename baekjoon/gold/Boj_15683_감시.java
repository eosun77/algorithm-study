package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15683_감시 {
	static int N;
	static int M;
	static int[] dc = { 0, 0, -1, 1 };
	static int[] dr = { 1, -1, 0, 0 };
	static int cnt = 0;
	static int MINR = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		SearchCCTV(map, 0);
		System.out.println(MINR);

	}
	
	static int[][] copyArray(int[][] map) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}

	static void SearchCCTV(int[][] map, int depth) {
		if(depth==N*M) {
			int result=0;
			cnt++;
//			System.out.println(cnt+"----------------");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j]+" ");
					if(map[i][j]==0) {
						result++;
					}
				}
//				System.out.println();
			}
			MINR = Math.min(MINR, result);
			return;
		}
		int x = depth / M;
		int y = depth % M;
		switch (map[x][y]) {
		case 1:
			for (int i = 0; i < 4; i++) {
				int[][] temp = copyArray(map);
				cctv(temp, x, y, i);
				SearchCCTV(temp, depth + 1);
			}
			break;
		case 2:
			for (int i = 0; i < 4; i += 2) {
				int[][] temp = copyArray(map);
				cctv2(temp, x, y, i);
				SearchCCTV(temp, depth + 1);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				int[][] temp = copyArray(map);
				cctv3(temp, x, y, i);
				SearchCCTV(temp, depth + 1);
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				int[][] temp = copyArray(map);
				cctv4(temp, x, y, i);
				SearchCCTV(temp, depth + 1);
			}
			break;
		case 5:
			int[][] temp = copyArray(map);
			cctv5(temp, x, y);
			SearchCCTV(temp, depth + 1);
			break;
		default:
			SearchCCTV(map, depth + 1);
			break;
		}
	}

	static void cctv2(int[][] map,int x, int y, int com) {

		cctv(map, x, y, com);
		com = com + 1;
		cctv(map, x, y, com);
	}

	static void cctv3(int[][] map,int x, int y, int com) {
		int com1;
		int com2;
		if (com == 0) {
			com1 = 0;
			com2 = 2;
		} else if (com == 1) {
			com1 = 1;
			com2 = 3;
		} else if (com == 2) {
			com1 = 1;
			com2 = 2;
		} else {
			com1 = 0;
			com2 = 3;
		}

		cctv(map, x, y, com1);
		cctv(map, x, y, com2);
	}

	static void cctv4(int[][] map,int x, int y, int com) {
		int com1;
		int com2;
		int com3;

		if (com == 0) {
			com1 = 0;
			com2 = 1;
			com3 = 2;
		} else if (com == 1) {
			com1 = 1;
			com2 = 3;
			com3 = 0;
		} else if (com == 2) {
			com1 = 0;
			com2 = 2;
			com3 = 3;
		} else {
			com1 = 1;
			com2 = 2;
			com3 = 3;
		}

		cctv(map, x, y, com1);
		cctv(map, x, y, com2);
		cctv(map, x, y, com3);
	}

	static void cctv5(int[][] map, int x, int y) {
		cctv(map, x, y, 0);
		cctv(map, x, y, 1);
		cctv(map, x, y, 2);
		cctv(map, x, y, 3);
	}

	static void cctv(int[][] map, int x, int y, int com) {
		for (int j = 1; j < 8; j++) {
			if (x + j * dc[com] < 0 || x + j * dc[com] >= N || y + j * dr[com] < 0 || y + j * dr[com] >= M
					|| map[x + j * dc[com]][y + j * dr[com]] == 6)
				break;
			if (map[x + j * dc[com]][y + j * dr[com]] == 0)
				map[x + j * dc[com]][y + j * dr[com]] = 7;
		}
	}
}
