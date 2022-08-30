package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Boj_1181_단어정렬 {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.readLine();
		}

		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				else {
					return s1.length() - s2.length();
				}
			}
		});


		sb.append(arr[0]).append('\n');

		for (int i = 1; i < N; i++) {
			// 중복되지 않는 단어만 출력
			if (!arr[i].equals(arr[i - 1])) {
				sb.append(arr[i]).append('\n');
			}
		}
		System.out.println(sb);
	}

}
