package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] nums = new int[n][n];
		int[][] sums = new int[n][n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < n; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				if (i==0&&j == 0) {
					sums[i][j] = nums[i][j];
				} else if(j == 0) {
					sums[i][j] = sums[i-1][j] + nums[i][j];
				} else if(i == 0) {
					sums[i][j] = sums[i][j-1] + nums[i][j];
				}
				else
					sums[i][j] = sums[i][j-1] + sums[i-1][j] -sums[i-1][j-1] + nums[i][j];
			}
		}
		for (int i = 0; i < m; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			if(x1==1&&y1==1) sum = sums[x2-1][y2-1];
			else if(x1==1) sum = sums[x2-1][y2-1]-sums[x2-1][y1-2];
			else if (y1==1) sum = sums[x2-1][y2-1]-sums[x1-2][y2-1];
			else sum = sums[x2-1][y2-1]-sums[x2-1][y1-2]-sums[x1-2][y2-1]+sums[x1-2][y1-2];
			sb.append(sum+"\n");

		}
		System.out.println(sb);

	}
}
