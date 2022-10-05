package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_14502_연구소 {
	static class virus {
		int x;
		int y;
		public virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static class empty {
		int x;
		int y;
		public empty(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static List<virus> virusList;
	static List<empty> emptyList;
	static int N, M;
	static int maxAns = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		virusList = new ArrayList<>();
		emptyList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					virus v = new virus(i, j);
					virusList.add(v);
				} else if(map[i][j]==0) {
					empty e = new empty(i, j);
					emptyList.add(e);
				}
			}
		}
		boolean[] isSelected = new boolean[emptyList.size()];
		buildWall(map, isSelected, 0, 0);
		System.out.println(maxAns);
		
	}
	
	static int[][] copyMap(int[][] map) {
		int[][] temp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				temp[i][j] = map[i][j];
			}
		}
		return temp;
	}
	
	static int findZero(int[][] map) {
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	static void buildWall(int[][] map, boolean[] isSelected, int depth, int n) {
		if(n==3) {
			int[][] temp = copyMap(map);
			for(int i=0;i<isSelected.length;i++) {
				if(isSelected[i]) {
					temp[emptyList.get(i).x][emptyList.get(i).y]=1;
				}
			}
			for(int i=0;i<virusList.size();i++) {
				virus v = virusList.get(i);
				virusSpread(temp, v);
			}
			maxAns = Math.max(maxAns, findZero(temp));
			return;
		}
		
		if(depth==emptyList.size()) return;
		
		isSelected[depth] = true;
		buildWall(map, isSelected, depth+1, n+1);
		isSelected[depth] = false;
		buildWall(map, isSelected, depth+1, n);
	}
	
	static void virusSpread(int[][] map, virus v) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int j=0;j<4;j++) {
			int nx = v.x+dx[j];
			int ny = v.y+dy[j];
			
			if(nx<0||ny<0||nx>=N||ny>=M) continue;
			
			if(map[nx][ny]==0) {
				map[nx][ny] = 2;
				virusSpread(map, new virus(nx, ny));
			}
		}
	}
}
