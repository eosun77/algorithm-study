package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11866_요세푸스문제0 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		while(!queue.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}

}
