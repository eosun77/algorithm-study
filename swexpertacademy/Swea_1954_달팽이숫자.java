package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			int dc[] = { 0, 1, 0, -1 };
			int dr[] = { 1, 0, -1, 0 };
			int cnt = 1;
			int n = 0;
			int m = 0;
			int d = 0;
			int s = N - 1;

			map[n][m] = cnt++;
			for (int j = 0; j < N - 1; j++) {
				n += dc[d % 4];
				m += dr[d % 4];
				map[n][m] = cnt++;
			}
			d++;
			while (s > 0) {
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < s; j++) {
						n += dc[d % 4];
						m += dr[d % 4];
						map[n][m] = cnt++;
					}
					d++;
				}
				s--;
			}
			sb.append("#").append(t+1).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		
	}
}
