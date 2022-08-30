package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj_15649_N과M1 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] output = new int[m];
		boolean[] isSel = new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i] = i+1;
		}
		permu(arr, output, 0, n, m, isSel);
		System.out.println(sb);

		
	}
	
	static void permu (int[] arr, int[] output, int depth, int n , int m, boolean[] isSel) {
		if(m==depth) {
			for(int i=0;i<m;i++) sb.append(output[i]).append(" ");
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!isSel[i]) {
				isSel[i] = true;
				output[depth] = arr[i];
				permu(arr, output, depth+1, n, m, isSel);
				isSel[i] = false;
			}
		}
	}
}
