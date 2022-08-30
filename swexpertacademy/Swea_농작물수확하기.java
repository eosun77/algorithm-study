package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_농작물수확하기 {
	
	static int farming (int[][] farm, int n, int m, int t) {
		int sum=0;
		int dc[] = {1, 1, -1, -1};
		int dr[] = { 1, -1, -1, 1};
		for(int i =0;i<4;i++) {
			for(int j=0;j<t;j++) {
				n+=dc[i];
				m+=dr[i];
				sum += farm[n][m];
			}	
		}
		if(t==0) sum=farm[n][m];
		return sum;
	}


	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(in.readLine());
		
		for(int tc=0;tc<t;tc++) {
			int n = Integer.parseInt(in.readLine());
			int[][] farm = new int[n][n];
			
			for(int i=0;i<n;i++) {
				String str = in.readLine();
				for(int j=0;j<n;j++) {
					System.out.println(j);
					farm[i][j] = str.charAt(j)-'0';
				}
			}
			int sum=0;
			for(int i=0;i<n/2+1;i++) {
				sum += farming(farm, n/2-i, n/2, i);
			}
			System.out.println("#" + (tc+1) + " " +sum);
					
			
		}
		
		
	}

}
