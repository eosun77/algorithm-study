package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_10773_제로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		Stack<Integer> num = new Stack<>();
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0)
				num.pop();
			else
				num.add(n);
		}
		int sum = 0;
		while (!num.isEmpty()) {
			sum += num.pop();
		}
		System.out.println(sum);
	}
}
