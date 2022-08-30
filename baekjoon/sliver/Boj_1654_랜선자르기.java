package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long[] line = new long[k];

		long max = 0;
		long min = 0;
		long mid = 0;

		for (int i = 0; i < k; i++) {
			line[i] = Integer.parseInt(in.readLine());
			if (max < line[i]) {
				max = line[i];
			}
		}

		max++;

		while (min < max) {

			mid = (max + min) / 2;
			long count = 0;

			for (int i = 0; i < line.length; i++) {
				count += (line[i] / mid);
			}

			if (count < n) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}

}
