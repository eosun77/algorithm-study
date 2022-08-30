package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_준한이의양팔저울 {
	static int N;
	static int[] weight;
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			cnt = 0;
			N = Integer.parseInt(in.readLine());
			weight = new int[N];
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(weight);
			do {
				Scale(0, 0, 0);
			} while (nextPermutation(weight));
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void Scale(int left, int right, int depth) {
		if (depth == N) {
			cnt++;
			return;
		}

		int w = weight[depth];
		Scale(left+w, right, depth + 1);
		if (left >= right + w) {
			Scale(left, right+w, depth + 1);
		}

	}

	static boolean nextPermutation(int[] arr) {
		int N = arr.length - 1;

		int i = N;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;
		if (i == 0)
			return false;

		int j = N;
		while (arr[i - 1] >= arr[j])
			--j;
		swap(arr, i - 1, j);

		int k = N;
		while (i < k)
			swap(arr, i++, k--);

		return true;
	}

	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
