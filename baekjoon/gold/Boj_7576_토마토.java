package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_7576_토마토 {

	static class Tomato {
		int x;
		public Tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		int y;
	}
	
	static ArrayList<Tomato> tomatos = new ArrayList<>();
	static int[][] tomatoTime;
	static int[][] map;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tomatoTime = new int[N][M];
		for(int i=0;i<N;i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					tomatos.add(new Tomato(i,j));
				}
			}
		}
		Oneday();
		Print();
	}
	
	static void Oneday() {
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, 1, -1};
		Queue<Tomato> q = new LinkedList<>();
		for(int i=0;i<tomatos.size();i++) {
			q.add(tomatos.get(i));
		}

		while(!q.isEmpty()) {
			Tomato t = q.poll();
			for(int i=0;i<4;i++) {
				int nx = t.x+dr[i];
				int ny = t.y+dc[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&map[nx][ny]==0) {
					map[nx][ny] = map[t.x][t.y] + 1;
					q.add(new Tomato(nx, ny));
				}
			}
		}
		
	}
	
	static void Print() {
		int day = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					System.out.println("-1");
					return;
				}
				day = Math.max(day, map[i][j]);
			}
		}
		System.out.println(day-1);
	}
}
