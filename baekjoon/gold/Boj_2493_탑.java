package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int[] high = new int[n + 1];
		int[] answer = new int[n + 1];
		Stack<Integer> tmp = new Stack<Integer>();
		Stack<Integer> tower = new Stack<Integer>();
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 1; i <= n; i++) {
			high[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			tower.add(i);
		}

		int t;
		while (!tower.isEmpty()) {
			if (tmp.isEmpty()) {
				t = tower.pop();
				tmp.push(t);
			} else if (high[tmp.peek()] < high[tower.peek()]) {
				answer[tmp.pop()] = tower.peek();
			} else {
				t = tower.pop();
				tmp.push(t);
			}
		}
		while (!tmp.isEmpty()) {
			answer[tmp.pop()] = 0;
		}
		for (int i = 1; i <= n; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

}
