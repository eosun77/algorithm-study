package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17472_다리만들기 {

	static int cnt =1;
	static int minAns = Integer.MAX_VALUE;
	static class point {
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge> {
		int node;
		int dis;

		public Edge(int node, int dis) {
			this.node = node;
			this.dis = dis;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.dis, o.dis);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					cnt++;
					map[i][j] = cnt;
					Queue<point> q = new LinkedList<point>();
					q.add(new point(i, j));
					while(!q.isEmpty()) {
						int[] dx = {1, -1, 0, 0};
						int[] dy = {0, 0, 1, -1};
						point island = q.poll();
						for(int n=0;n<4;n++) {
							int nx = island.x + dx[n];
							int ny = island.y + dy[n];
							if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]!=1) continue;
							
							map[nx][ny] = cnt;
							q.add(new point(nx, ny));
						}
					}
				}
			}
		}
		cnt-=1;
		
		 ArrayList<ArrayList<Edge>> bridge = new ArrayList<>();
		 for(int i=0;i<cnt;i++) {
			 bridge.add(new ArrayList<>());
		 }
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>=2) {
					int[] dx = {1, -1, 0, 0};
					int[] dy = {0, 0, 1, -1};
					point island = new point(i,j);
					for(int n=0;n<4;n++) {
						int b = 1;
						while(true) {
						int nx = island.x + dx[n]*b;
						int ny = island.y + dy[n]*b;
						if(nx<0||ny<0||nx>=N||ny>=M||map[nx][ny]==map[i][j]) break;
						
						if(map[nx][ny]==0) {
							b++;
						} else {
							if(b==2) break;
							else {
								bridge.get(map[i][j]-2).add(new Edge(map[nx][ny]-2,b-1));
								break;
								}
							}
						}
					}
				}
			}
		}
		int ans = 0;
		boolean[] visit = new boolean[cnt];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0,0));
		int depth = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(visit[edge.node]) continue;
			visit[edge.node] = true;
			ans += edge.dis;
			for (Edge next : bridge.get(edge.node)) {
				if(!visit[next.node]) {
					pq.add(next);
				}
			}
			if (++depth == cnt) break;
		}
		for(int i=0;i<cnt;i++) {
			if(!visit[i]) ans = -1;
		}
		System.out.println(ans);
	}
}