package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_11286_절댓값의힘 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> nums = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer n1, Integer n2) {
				if (Math.abs(n1)==Math.abs(n2))
					return n1 - n2;
				return Math.abs(n1) - Math.abs(n2);
			}

		});

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(in.readLine());

			if (num == 0) {
				if (nums.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(nums.poll()).append("\n");
				}
			} else {
				nums.add(num);
			}
		}
		System.out.println(sb);

	}
}
