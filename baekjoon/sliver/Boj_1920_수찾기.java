package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1920_수찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(in.readLine());
		int[] num = new int[M];
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		for (int i = 0; i < M; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int i = 0; i < M; i++) {
		System.out.println(binarySearch(arr, num[i]));
		}
	}

	public static int binarySearch(int[] arr, int key) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (key < arr[mid]) {
				hi = mid - 1;
			}
			else if (key > arr[mid]) {
				lo = mid + 1;
			}
			else {
				return 1;
			}
		}
		return 0;
	}
}
