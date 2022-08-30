package swexpertacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1961_숫자배열회전 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("src/swea/input_1961.txt"))));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < T; tc++) {
			String strNK = in.readLine();

			StringTokenizer stN = new StringTokenizer(strNK, " ");

			int N = Integer.parseInt(stN.nextToken());

			char[][] map = new char[N][N];
			String[][] result = new String[N][3];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				result[cnt][0] = "";
				for (int i = N - 1; i >= 0; i--) {
					result[cnt][0] = result[cnt][0] + map[i][j];
				}
				cnt++;
			}

			cnt = 0;

			for (int i = N - 1; i >= 0; i--) {
				result[cnt][1] = "";
				for (int j = N - 1; j >= 0; j--) {
					result[cnt][1] = result[cnt][1] + map[i][j];
				}
				cnt++;
			}

			cnt = 0;

			for (int j = N - 1; j >= 0; j--) {
				result[cnt][2] = "";
				for (int i = 0; i < N; i++) {
					result[cnt][2] = result[cnt][2] + map[i][j];
				}
				cnt++;
			}
			System.out.println("#" + (tc + 1));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println("");
			}
		}
		in.close();
	}

}
