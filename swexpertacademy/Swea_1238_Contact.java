package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1238_Contact {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc < 11; tc++) {

			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] contact = new ArrayList[101];
			for (int i = 0; i < 101; i++)
				contact[i] = new ArrayList<>();
			int[] vtime = new int[101];
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				contact[from].add(to);
			}
			sb.append("#" + tc + " ");
			BFS(contact, vtime, S);
		}
		System.out.println(sb);

	}

	static void BFS(ArrayList<Integer>[] con, int[] vtime, int V) {
		Queue<Integer> temp = new LinkedList<>();
		temp.add(V);
		vtime[V] = 1;
		int maxT = 0;
		while (!temp.isEmpty()) {
			int nv = temp.poll();

			for (int i = 0; i < con[nv].size(); i++) {
				int next = con[nv].get(i);

				if (vtime[next] != 0)
					continue;

				vtime[next] = vtime[nv] + 1;
				temp.add(next);
				maxT = Math.max(maxT, vtime[next]);
			}
		}
		
		for (int i = 100; i >= 1; i--) {
			if (maxT == vtime[i]) {
				sb.append(i + "\n");
				break;
			}
		}
	}
}
