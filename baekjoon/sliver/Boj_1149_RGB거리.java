package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1149_RGB거리 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] paint = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<3;j++) {
				paint[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] R = new int[N];
		int[] G = new int[N];
		int[] B = new int[N];
		R[0] = paint[0][0];
		G[0] = paint[0][1];
		B[0] = paint[0][2];
		
		for(int i=1;i<N;i++) {
			R[i] = paint[i][0] + Math.min(G[i-1], B[i-1]);
			G[i] = paint[i][1] + Math.min(R[i-1], B[i-1]);
			B[i] = paint[i][2] + Math.min(R[i-1], G[i-1]);
		}
		System.out.println(Math.min(Math.min(R[N-1], G[N-1]),B[N-1]));
	}
}
