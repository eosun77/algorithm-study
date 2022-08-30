package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2961_도영이가만든맛있는음식 {
	static int minSB = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		int[] s = new int[n];
		int[] b = new int[n];
		boolean[] isSel = new boolean[n];
 		for(int i=0;i<n;i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
 		cooking(s, b, isSel, n, 0);
 		System.out.println(minSB);
	}
	
	static void cooking(int[] s, int[] b, boolean[] isSel, int n, int depth) {
		
		if(depth==n) {
			boolean chk = false;
			int sort =1;
			int bitter = 0;
			for(int i=0;i<n;i++) {
				if(isSel[i]) {
					sort *= s[i];
					bitter += b[i];
					chk = true;
				}
			}
			if(chk) minSB = Math.min(minSB, Math.abs(sort-bitter));
			return;
		}		
		isSel[depth] = true;
		cooking(s, b, isSel, n, depth+1);
		
		isSel[depth] = false;
		cooking(s, b, isSel, n, depth+1);
	}
}
