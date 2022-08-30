package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_한빈이와SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		for (int t = 0; t < tc; t++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int[] snack = new int[n];
			int[] sum = new int[n * (n - 1) / 2];
			int sMax = -1;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					sum[cnt] = snack[i] + snack[j];
					if (sum[cnt] <= m && sMax < sum[cnt])
						sMax = sum[cnt];
				}
			}

			sb.append("#").append(t + 1).append(" ").append(sMax).append("\n");
		}
		System.out.println(sb);
	}
}
