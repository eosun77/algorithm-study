package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_17135_캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	static int[][] map;
	static int kill=0;
	static int maxkill = 0;
	static ArrayList<Integer> enemyX;
	static ArrayList<Integer> enemyY;
	static int cnt =0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] arrow = new boolean[M];
		Position(arrow, 0, 0);
		System.out.println(maxkill);
	}

	static void Position(boolean[] arrow, int depth, int cnt) { // 위치변경
		if (cnt == 3) {
			kill = 0;
			CastleDefense(arrow);
			return;
		}
		if (depth == M)
			return;
		arrow[depth] = true;
		Position(arrow, depth + 1, cnt + 1);
		arrow[depth] = false;
		Position(arrow, depth + 1, cnt);
	}

	static void CastleDefense(boolean[] arrow) { // 활쏘기
		int[][] temp = CopyArray(map);
		for(int i=N;i>0;i--) {
			cnt =0;
			enemyX = new ArrayList<>();
			enemyY = new ArrayList<>();
			for(int j=0;j<M;j++) {
				if(arrow[j]) {
					Shoot(temp, i,j);
				}
			}
			for(int k=0;k<enemyX.size();k++) {
				if(temp[enemyX.get(k)][enemyY.get(k)]==1) kill++;
				temp[enemyX.get(k)][enemyY.get(k)]=0;
			}
//			CheckMap(temp);
		}
//		for(int j=0;j<M;j++) System.out.print(arrow[j]+" ");
//		CheckMap(temp);
//		System.out.println(kill);
		maxkill = Math.max(maxkill, kill);
	}
	
	static void Shoot(int[][] temp, int x, int y) {   // 사거리안에 있는 적 List에 넣기
		for(int d=1;d<=D;d++) {
			int i = 1;
			boolean flag=true;
			for(int j=1-d;j<=d-1;j++) {
				if(y+j>=0&&y+j<M&&x-i>=0&&x-i<N) {
					if(temp[x - i][y + j]==1) {
						enemyX.add(x-i);
						enemyY.add(y+j);
						return;
					}
				}
				if(i==d) {
					flag=false;
				}
				if(flag) i++;
				else i--;
			}
		}
	}
	
	static int[][] CopyArray(int[][] map) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
	
	static void CheckMap(int[][] map) {
		System.out.println("");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
