package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17406_배열돌리기4 {
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] r = new int[k];
		int[] c = new int[k];
		int[] s = new int[k];
		for (int tk = 0; tk < k; tk++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			r[tk] = Integer.parseInt(st.nextToken());
			c[tk] = Integer.parseInt(st.nextToken());
			s[tk] = Integer.parseInt(st.nextToken());
		}
		int[] wtk = new int[k];
		boolean[] isSel = new boolean[6];
		permu(wtk, 0, k, isSel, r, c, s, arr, n, m);
		System.out.println(MIN);

	}

	static void swing(int[][] arr, int s) {
		int temp = 0;
		for (int i = 0; i < s / 2; i++) {
			temp = arr[i][i];
			for (int j = 1 + i; j < s - i; j++) {
				arr[j - 1][i] = arr[j][i];
			}
			for (int j = 1 + i; j < s - i; j++) {
				arr[s - i - 1][j - 1] = arr[s - i - 1][j];
			}
			for (int j = 1 + i; j < s - i; j++) {
				arr[s - j][s - i - 1] = arr[s - j - 1][s - i - 1];
			}
			for (int j = 1 + i; j < s - i; j++) {
				arr[i][s - j] = arr[i][s - j - 1];
			}
			arr[i][i + 1] = temp;
		}
	}

	static void permu(int[] output, int depth, int tk, boolean[] isSel, int[] r, int[] c, int[] s, int[][] arr, int n,
			int m) {
		int[][] result = new int[n][m];
		if (tk == depth) {
			for(int i=0;i<n;i++) {
				System.arraycopy(arr[i], 0, result[i], 0, m);
			}
			for (int i = 0; i < tk; i++) {
				int[][] temp = new int[2 * s[output[i]] + 1][2 * s[output[i]] + 1];
				for (int k = 0; k < 2 * s[output[i]] + 1; k++) {
					for (int j = 0; j < 2 * s[output[i]] + 1; j++) {
						temp[k][j] = result[r[output[i]] - s[output[i]] - 1 + k][c[output[i]] - s[output[i]] - 1 + j];
					}
				}
				swing(temp, 2 * s[output[i]] + 1);
				for (int k = 0; k < 2 * s[output[i]] + 1; k++) {
					for (int j = 0; j < 2 * s[output[i]] + 1; j++) {
						result[r[output[i]] - s[output[i]] - 1 + k][c[output[i]] - s[output[i]] - 1 + j] = temp[k][j];
					}
				}
			}
			int sum = 0;
			for (int x = 0; x < n; x++) {
				sum = 0;
				for (int y = 0; y < m; y++) {
					sum += result[x][y];
				}
				MIN = Integer.min(MIN, sum);
			}
			return;
		}
		for (int i = 0; i < tk; i++) {
			if (!isSel[i]) {
				isSel[i] = true;
				output[depth] = i;
				permu(output, depth + 1, tk, isSel, r, c, s, arr, n, m);
				isSel[i] = false;
			}
		}
	}
}
