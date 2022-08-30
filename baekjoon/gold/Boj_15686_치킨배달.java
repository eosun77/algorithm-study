package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15686_치킨배달 {
	static int MINSUM = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		List<Integer> bbq = new ArrayList<>();
		boolean[][] ishouse = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					bbq.add(i);
					bbq.add(j);
				} else if (map[i][j] == 1)
					ishouse[i][j] = true;

			}
		}
		boolean[] isbbq = new boolean[bbq.size() / 2];
		comb(bbq, isbbq, 0, n, m, ishouse);
		System.out.println(MINSUM);

	}

	static void comb(List<Integer> bbq, boolean[] isbbq, int depth, int n, int m, boolean[][] ishouse) {
		int[][] selectbbq = new int[13][2];
		int cnt = 0;
		if (m == 0) {
			for (int i = 0; i < bbq.size() / 2; i++) {
				if (isbbq[i]) {
					selectbbq[cnt][0] = bbq.get(2 * i);
					selectbbq[cnt++][1] = bbq.get(2 * i + 1);
				}
			}
			int dis;
			int sum = 0;
//			for (int k = 0; k < cnt; k++) {
//				System.out.print("(" + selectbbq[k][0] + ", " + selectbbq[k][1] + ") ");
//			}
//			System.out.println("");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {  
					
					
					
					
					
					dis = Integer.MAX_VALUE;
					if (ishouse[i][j]) {
						for (int k = 0; k < cnt; k++) {
							dis = Math.min(dis, Math.abs(selectbbq[k][0] -i) + Math.abs(selectbbq[k][1] - j));
						}
//						System.out.println((i+1)+", " + (j+1) + " : " + dis);
						sum += dis;
					}
				}
			}
			MINSUM = Math.min(MINSUM, sum);
			return;
		}
		if (depth == bbq.size() / 2)
			return;

		isbbq[depth] = true;
		comb(bbq, isbbq, depth + 1, n, m - 1, ishouse);
		isbbq[depth] = false;
		comb(bbq, isbbq, depth + 1, n, m, ishouse);

	}

}
