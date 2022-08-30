package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1244_스위치켜고끄기 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] swit = new int[N];
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		for (int i = 0; i < swit.length; i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}

		int num = Integer.parseInt(in.readLine());
		
		for(int i=0;i<num;i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int gen = Integer.parseInt(st.nextToken());
			int sn = Integer.parseInt(st.nextToken());
			if(gen==1) {
				boy(swit,sn);
			} else girl(swit,sn);
		}
		
		for (int i = 0; i < swit.length; i++) {
			if(i!=0&&i%20==0) 
				sb.append("\n");
			sb.append(swit[i]).append(" ");
		}

		System.out.println(sb);
	}
	
	static void onoff(int[] swit, int i) {
		switch(swit[i-1]) {
		case 1 : swit[i-1]=0;
		break;
		case 0 : swit[i-1]=1;
		break;
		}
	}
	
	static void boy(int[] swit, int n) {
		for (int i=n;i<swit.length+1;i+=n) {
			onoff(swit,i);
		}
	}
	
	static void girl(int[] swit, int n) {
		onoff(swit,n);
		for(int i=1; n-i>=1&&n+i<=swit.length;i++) {
			if(swit[n-i-1]==swit[n+i-1]) {
				onoff(swit,n-i);
				onoff(swit,n+i);
			}
			else break;
		} 
	}
}
