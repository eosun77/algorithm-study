package swexpertacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_1974_스도쿠검증 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/swea/input_1974.txt"))));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {

			int[][] map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[] answer = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			int[][] temp = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					temp[i][j] = map[i][j];
				}
			}

			int cnt = 0;
			for (int i = 0; i < 9; i++) {
				Arrays.sort(temp[i]);
				if (Arrays.equals(answer, temp[i])) {
					cnt++;
				} else
					break;
			}

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					temp[j][i] = map[i][j];
				}
			}

			for (int i = 0; i < 9; i++) {
				Arrays.sort(temp[i]);
				if (Arrays.equals(answer, temp[i])) {
					cnt++;
				} else
					break;
			}
			int x=0;
			int y=0;

			for (int n = 0; n < 3; n++) {
				for (int m = 0; m < 3; m++) {
					y=0;
					for (int i = 3 * n; i < 3 * n + 3; i++) {
						for (int j = 3 * m; j < 3 * m + 3; j++) {
							temp[x][y] = map[i][j];
							y++;
						}
					}
					x++;
				}
			}
			for (int i = 0; i < 9; i++) {
				Arrays.sort(temp[i]);
				if (Arrays.equals(answer, temp[i])) {
					cnt++;
				} else
					break;
			}
			if(cnt==27) {
				System.out.println("#"+tc+" 1");
			} else {
				System.out.println("#"+tc+" 0");
			}

		}
	}

}
