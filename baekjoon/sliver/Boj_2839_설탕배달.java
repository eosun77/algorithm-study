package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] sugar = {0, 3, 6, 9, 12};
		int sum = -1;
		if(N>=3) {
			for(int i=0;i<5;i++) {
				if(N-sugar[i]<0) break;
				if((N-sugar[i])%5==0) {
					sum = i + (N-sugar[i])/5;
				}
			}	
		}
		System.out.println(sum);
	}

}
