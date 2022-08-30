package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3040_백설공주와일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[9];
		boolean[] isSel = new boolean[9];
		for(int i=0;i<9;i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		comb(num, isSel, 0, 0);
	}	
	static void comb(int[] num, boolean [] isSel, int depth, int n) {
		if(n==7) {
			int sum = 0;
			for(int i=0;i<9;i++) {
				if(isSel[i]) { 
					sum+= num[i];
				}
			}
			if(sum==100) {
				for(int i=0;i<9;i++) {
					if(isSel[i]) { 
						System.out.println(num[i]);
					}
				}
			}
			return;
		}	
		if(depth==9) return;
		
		isSel[depth] = true;
		comb(num, isSel, depth+1, n+1);
		
		isSel[depth] = false;
		comb(num,isSel,depth+1, n);
	}
}
