package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1436_영화감독숌 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		int n=0;
		int num = 666;
		while(n<t) {
			String numS = Integer.toString(num);
			for(int i=0;i<numS.length()-2;i++) {
				if(numS.charAt(i)=='6'&&numS.charAt(i+1)=='6'&&numS.charAt(i+2)=='6') {
					n++;
					break;
				}
			}
			num++;
		}
		System.out.println(num-1);
	}

}
