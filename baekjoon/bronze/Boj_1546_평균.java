package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1546_평균 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		double[] score = new double[N];
		double sum = 0;

		for (int i = 0; i < N; i++) {
			score[i] = Double.parseDouble(st.nextToken());
		}

		Arrays.sort(score);
		for (int i = 0; i < N; i++) {
			score[i] = score[i] / score[N - 1] * 100;
			sum += score[i];
		}
		System.out.println(sum / N);

	}

}
