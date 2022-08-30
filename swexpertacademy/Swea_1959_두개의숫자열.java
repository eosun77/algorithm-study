package swexpertacademy;

import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1959_두개의숫자열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/swea/input_1959.txt"))));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			int sum = 0;
			int max = 0;
			String str1 = in.readLine();
			String str2 = in.readLine();
			String str3 = in.readLine();
			StringTokenizer st1 = new StringTokenizer(str1, " ");
			StringTokenizer st2 = new StringTokenizer(str2, " ");
			StringTokenizer st3 = new StringTokenizer(str3, " ");
			int N = Integer.parseInt(st1.nextToken());
			int M = Integer.parseInt(st1.nextToken());

			int[] A = new int[N];
			int[] B = new int[M];
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st2.nextToken());
			}
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st3.nextToken());
			}

			if (M > N) {
				for (int i = 0; i < M - N + 1; i++) {
					sum = 0;
					for (int j = 0; j < N; j++) {
						sum += A[j] * B[j + i];
					}

					if (max < sum) {
						max = sum;
					}
				}
			} else {
				for (int i = 0; i < N - M + 1; i++) {
					sum = 0;
					for (int j = 0; j < M; j++) {
						sum += B[j] * A[j + i];

					}
					if (max < sum) {
						max = sum;

					}
				}
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}

		System.out.println(sb);
	}

}
