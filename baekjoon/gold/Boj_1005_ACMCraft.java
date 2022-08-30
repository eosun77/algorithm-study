package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1005_ACMCraft {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < t; tc++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int[] d = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				d[i] = Integer.parseInt(st.nextToken());
			}
			boolean[][] isLink = new boolean[n + 1][n + 1];
			int[] link = new int[n + 1];
			for (int i = 0; i < k; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				isLink[x][y] = true;
				link[y]++;
			}
			int op = Integer.parseInt(in.readLine());
			int[] result = build(d,isLink,link);
			sb.append(result[op]).append("\n");

		}
		System.out.println(sb);
	}

	private static int[] build(int[] d, boolean[][] isLink, int[] link) {
		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[link.length];
		for(int i=0;i<link.length;i++) {
			if(link[i]==0) {
				result[i] = d[i];
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int pre = queue.poll();
			
			for(int i=0;i<link.length;i++) {
				if(isLink[pre][i]) {
					result[i] = Math.max(result[i],result[pre]+d[i]);
					--link[i];
					if(link[i]==0) queue.add(i);
				}
			}
		}
		return result;
	}

}
