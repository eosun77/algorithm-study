package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16926_배열돌리기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int temp;
		for(int c = 0;c<r;c++) {
			for (int i = 0; i < Math.min(n, m) / 2; i++) {
				temp = arr[i][i];
				for (int j = 1 + i; j < m - i; j++) {
					arr[i][j - 1] = arr[i][j];
				}
				for (int j = 1 + i; j < n - i; j++) {
					arr[j - 1][m - i - 1] = arr[j][m - i - 1];
				}
				for (int j = 1 + i; j < m - i; j++) {
					arr[n - i - 1][m - j] = arr[n - i - 1][m- j - 1];
				}
				for (int j = 1 + i; j < n - i; j++) {
					arr[n - j][i] = arr[n - j - 1][i];
				}
				arr[i + 1][i] = temp;
			}
		}
		
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				sb.append(arr[x][y]).append(" ");
			}
			sb.append("\n");
		}
	System.out.println(sb);
	}

}
