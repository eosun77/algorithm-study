package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_10845_쿠 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String op = st.nextToken();
			if (op.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
			} else if (op.equals("pop")) {
				if (!queue.isEmpty())
					System.out.println(queue.poll());
				else
					System.out.println("-1");
			} else if (op.equals("size")) {
				System.out.println(queue.size());
			} else if (op.equals("empty")) {
				if (queue.isEmpty())
					System.out.println("1");
				else
					System.out.println("0");
			} else if (op.equals("front")) {
				if (!queue.isEmpty())
					System.out.println(queue.peek());
				else
					System.out.println("-1");
			} else if (op.equals("back")) {
				if (!queue.isEmpty()) {
					for(int j=0;j<queue.size()-1;j++) {
						queue.add(queue.poll());
					}
					System.out.println(queue.peek());
					queue.add(queue.poll());
				}
				else
					System.out.println("-1");
			}
		}
	}
}
