package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_서로소집합 {

	static int[] p;
	static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			sb.append("#").append(tc).append(" ");
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			p = new int[n+1];
			rank = new int[n+1];
			for(int i=0;i<n;i++) {
				MakeSet(i);
				rank[i] = 0;
			}
			for(int i=0;i<m;i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				int com = Integer.parseInt(st.nextToken());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				
				if(com==0) {
					Union(n1, n2);
				} else if(com==1) {
					if(FindSet(n1)==FindSet(n2)) {
						sb.append("1");
					} else sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void MakeSet(int x) { 
		p[x] = x;
	}
	static int FindSet(int x) { 
		if(p[x] == x) return x;
		else return p[x] = FindSet(p[x]);
	}
	static void Union(int x, int y) { 
		int a = FindSet(x);
		int b = FindSet(y);
		if(a == b) return;
		if(rank[a]==rank[b]) {
			p[b] = a;
			rank[a]++;
		}
		if(rank[a]>rank[b]) {
			p[b] = a;
		} else p[a] = b;
	}
}
