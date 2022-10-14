package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012_유기농배추 {

	static class baechu {
		int x;
		int y;
		public baechu(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for(int i=1;i<=K;i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			int cnt = 2;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					Queue<baechu> q = new LinkedList<baechu>();
					if(map[i][j]==1) {
						q.add(new baechu(i, j));
						map[i][j] = cnt;
						int[] dx = {0, 0, 1, -1};
						int[] dy = {1, -1, 0, 0};
						while(!q.isEmpty()) {
							baechu b = q.poll();
							int x = b.x;
							int y = b.y;
							for(int k=0;k<4;k++) {
								int nx = x + dx[k];
								int ny = y + dy[k];
						
								if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]==0) continue;
						
								if(map[nx][ny]==1) {
									map[nx][ny] = cnt;
									q.add(new baechu(nx, ny));
								}
							}
						}
						cnt++;
					}
				}
			}
			sb.append(cnt-2).append("\n");
		}
		System.out.println(sb);
	}
}
