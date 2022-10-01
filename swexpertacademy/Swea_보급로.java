package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swea_보급로 {

	static class xy {
		int x;
		int y;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			int[][] dp = new int[N][N];
			for(int i=0;i<N;i++) {
				String str = in.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = str.charAt(j)-'0';
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			dp[0][0] = 0;
			int[] dx = {1, 0, 0, -1};
			int[] dy = {0, 1, -1, 0};
			Queue<xy> q = new LinkedList<xy>();
			q.add(new xy(0, 0));
			while(!q.isEmpty()) {
				xy c = q.poll();
				for(int i=0;i<4;i++) {
					int nx = c.x+dx[i];
					int ny = c.y+dy[i];
					
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					
					if(dp[nx][ny] > dp[c.x][c.y] + map[nx][ny]) {
						dp[nx][ny] = dp[c.x][c.y] + map[nx][ny];
						q.add(new xy(nx,ny));
					}
			
				}
			}
			sb.append("#").append(tc+1).append(" ").append(dp[N-1][N-1]).append("\n");
		}
		System.out.println(sb);
	}
}
