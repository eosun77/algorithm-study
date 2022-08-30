package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1074_Z {
	static int num = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Zquest(N, r, c);

	}

	static void Zquest(int N, int r, int c) {
		if (N == 0) {
			System.out.println(num);
			return;
		}
		int size = (int)Math.pow(2, N - 1);
		if (r <size && c < size) {
			Zquest(N - 1, r, c);
		} else if (r < size && c >= size) {
			num += size*size;
			Zquest(N - 1, r, (int) (c - size));
		} else if (r >= size && c < size) {
			num += 2 * size*size;
			Zquest(N - 1, (int) (r - size), c);
		} else if (r >= size && c >= size) {
			num += 3 * size*size;
			Zquest(N - 1, (int) (r - size), (int) (c - size));
		}
	}
}
