package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Boj_1992_쿼드트리 {
	static int[][] map;
	static Queue<Character> quadtree = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		QuadTree(0, 0, N);
		System.out.println(sb);
	}
	
	static void QuadTree(int x, int y, int N) {	
		int sum = 0;
		for(int i = 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				sum += map[i+x][j+y];
			}
		}
		if(sum==0) sb.append("0");
		else if(sum==N*N) sb.append("1");
		else {
			sb.append("(");
			QuadTree(x, y, N/2);
			QuadTree(x, y+N/2, N/2);
			QuadTree(x+N/2, y, N/2);
			QuadTree(x+N/2, y+N/2, N/2);
			sb.append(")");
		}
	}
}
