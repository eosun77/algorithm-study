package baekjoon.sliver;

import java.io.BufferedReader;
<<<<<<< HEAD
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11048_이동하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N+1][M+1];
		dp[1][1] = map[1][1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
			}
		}
		System.out.println(dp[N][M]);
=======
import java.io.InputStreamReader;

public class Boj_11048_이동하기 {

	public static void main(String[] args) {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
>>>>>>> d8dd7ff0c6ea2c6d9a0af4657317452b26e6309a
	}
}
