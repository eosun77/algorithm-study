package baekjoon.sliver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2615_오목 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[19][19];
		for (int i = 0; i < 19; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dc = {-1, 0, 1, 1};
		int[] dr = {1, 1, 1, 0};
		int result = 0;
		int resulti = 20;
		int resultj = 20;

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int cnt = 0;
						for (int l = 1; l < 5; l++) {
							if (i + (dc[k] * l) >= 19 || i + (dc[k] * l) < 0 || j + (dr[k] * l) >= 19
									|| j + (dr[k] * l) < 0)
								break;
							else if (map[i + (dc[k] * l)][j + (dr[k] * l)] == 1) {
								cnt++;
							}
						}
						for (int l = -1; l < 6; l += 6) {
							if (i + (dc[k] * l) >= 19 || i + (dc[k] * l) < 0 || j + (dr[k] * l) >= 19
									|| j + (dr[k] * l) < 0 || map[i + (dc[k] * l)][j + (dr[k] * l)] != 1) {
								cnt++;
							}
						}
						if (cnt == 6) {
							result = 1;
							if (j < resultj) {
								resulti = i + 1;
								resultj = j + 1;
							}
						}

					}
				} else if (map[i][j] == 2) {
					for (int k = 0; k < 4; k++) {
						int cnt = 0;
						for (int l = 1; l < 5; l++) {
							if (i + (dc[k] * l) >= 19 || i + (dc[k] * l) < 0 || j + (dr[k] * l) >= 19
									|| j + (dr[k] * l) < 0)
								break;
							else if (map[i + (dc[k] * l)][j + (dr[k] * l)] == 2) {
								cnt++;
							}
						}
						for (int l = -1; l < 6; l += 6) {
							if (i + (dc[k] * l) >= 19 || i + (dc[k] * l) < 0 || j + (dr[k] * l) >= 19
									|| j + (dr[k] * l) < 0 || map[i + (dc[k] * l)][j + (dr[k] * l)] != 2) {
								cnt++;
							}
						}
						if (cnt == 6) {
							result = 2;
							if (j < resultj) {
								resulti = i + 1;
								resultj = j + 1;
							}
						}

					}
				}
			}
		}
		System.out.println(result);
		if(result!=0)
		System.out.println(resulti + " " + resultj);

	}
}
