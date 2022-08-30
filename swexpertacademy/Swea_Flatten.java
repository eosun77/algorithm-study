package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_Flatten {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int[] boxs = new int[100];
		for (int tc = 0; tc < 10; tc++) {
			int dump = Integer.parseInt(in.readLine());
			str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			for (int i = 0; i < 100; i++) {
				boxs[i] = Integer.parseInt(st.nextToken());
			}
			 
			dumping(boxs, dump);

			sb.append("#").append(tc + 1).append(" ").append(Arrays.stream(boxs).max().getAsInt() - Arrays.stream(boxs).min().getAsInt()).append("\n");
		}
		System.out.println(sb);
	}

	static void dumping(int[] boxs, int dump) {
		Arrays.sort(boxs);
		boxs[0]++;
		boxs[99]--;
		if(dump>0)
		dumping(boxs, dump-1);

	}
}
