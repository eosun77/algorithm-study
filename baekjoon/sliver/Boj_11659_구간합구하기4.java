package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str= in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] num = new int[n]; 
		int[] sums = new int[n];
		str= in.readLine();
		st = new StringTokenizer(str, " ");
		for(int i=0;i<n;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		int sum;
		sums[0] = num[0];

		for(int i=1;i<n;i++) {
			sums[i] = sums[i-1] + num[i];
		}

		for (int tc = 0; tc < m; tc++) {
			str= in.readLine();
			st = new StringTokenizer(str, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==1)  sum = sums[b-1];
			else sum = sums[b-1]-sums[a-2];

			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
