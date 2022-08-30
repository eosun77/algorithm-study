package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(in.readLine());

		for (int tc = 0; tc < t; tc++) {

			String str = in.readLine();
			int[] b = new int[str.length()];
			for (int i = 0; i < str.length(); i++) {
				b[i] = str.charAt(i) - '0';
			}
			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				if (b[i] == 1) {
					cnt++;
					for (int j = i; j < str.length(); j++) {
						if (b[j] == 1)
							b[j] = 0;
						else
							b[j] = 1;
					}
				}
			}
			sb.append("#").append(tc+1).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
