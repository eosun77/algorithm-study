package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[10];
		int[] re = new int[42];
		int cnt=0;
		for(int i=0;i<42;i++) {
			re[i] = 0;
		}
		for(int i=0;i<10;i++) {
			num[i] = Integer.parseInt(in.readLine());
			re[num[i]%42] += 1;
		}
		for(int i=0;i<42;i++) {
			if(re[i]>0) cnt++;
		}
		System.out.println(cnt);
	}

}
