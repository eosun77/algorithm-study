package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea_벽돌깨기 {
	static int H, W;
	static int minAns;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1;tc<=T;tc++) {
			minAns=Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
		    H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			play(map, N, 0);
			sb.append("#").append(tc).append(" ").append(minAns).append("\n");
		}
		System.out.println(sb);
	}
	
	static void play(int[][] map, int N, int depth) {

		if(N==depth) {
			minAns = Math.min(minAns, countBrick(map));
			return;
		}
		for(int w=0;w<W;w++) {
			int[][] temp = new int[H][W];
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					temp[i][j] = map[i][j];
				}
			}
			brick(temp, w);
			play(temp, N, depth+1);
		}
	}
	
	static void brick(int[][] map , int y) {
		int depth=0;
		
		while(depth<H&&map[depth][y]==0) {
			depth++;
		}
		if(depth<H) {
			breakBrick(map, depth, y);
			downBrick(map);
		}
		
	}
	
	static void breakBrick(int[][] map, int x, int y) {
		int n = map[x][y];
		map[x][y] = 0;
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int j=1;j<n;j++) {
			for(int i=0;i<4;i++) {
				int nx = x+dx[i]*j;
				int ny = y+dy[i]*j;
				
				if(nx<0||ny<0||nx>=H||ny>=W) continue;
				
				if(map[nx][ny]>0) {
					breakBrick(map, nx, ny);

				}
				
			}
		}
		
	}
	
	static void downBrick(int[][] map) {
		for(int i=0;i<W;i++) {
			Stack<Integer> temp = new Stack<>();
			for(int j=0;j<H;j++) {
				if(map[j][i]>0) {
					temp.add(map[j][i]);
					map[j][i]=0;
				}
			}
			int n = temp.size();
			for(int j=0;j<n;j++) {
				map[H-1-j][i] = temp.pop();
			}
		}
	}
	
	static int countBrick(int[][] map) {
		int cnt = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
//				System.out.print(map[i][j] + " ");
				if(map[i][j]>0) cnt++;
			}
//			System.out.println();
		}
		return cnt;

	}

}
