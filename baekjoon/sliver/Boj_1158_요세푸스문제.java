package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1158_요세푸스문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> num = new LinkedList<Integer>();
		for (int i = 1; i < n + 1; i++) {
			num.add(i);
		}
		while (!num.isEmpty()) {
			for(int i=0;i<k-1;i++) num.add(num.poll());
			sb.append(num.poll()).append(", ");;
		}
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.println(sb);
	}
	
}
