package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_7465_창용마을무리의개수 {
	
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<T+1;tc++) {
			int cnt =0;
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			for(int i=1;i<N+1;i++) {
				p[i] = i;
			}
			for(int i=0;i<M;i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				Union(x, y);
			}
			
			for(int i=1;i<N+1;i++) {
				if(p[i]==i) cnt++;
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static int FindSet(int x) {
		if(p[x]==x) return x;
		else return p[x] = FindSet(p[x]);
	}
	
	static void Union(int x, int y) {
		if(p[FindSet(x)]==p[FindSet(y)]) return;
		else {
			p[FindSet(y)] = FindSet(x);
		}
	}

}
