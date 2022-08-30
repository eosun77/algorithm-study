package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_암호문 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc = 0;tc<10;tc++) {
			int n = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			List<String> pwd = new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				pwd.add(st.nextToken());
			}
			int m = Integer.parseInt(in.readLine());
			str = in.readLine();
			st = new StringTokenizer(str, "I");
			for(int i=0;i<m;i++) {
				String comStr = st.nextToken();
				StringTokenizer comTk = new StringTokenizer(comStr, " ");
				int x = Integer.parseInt(comTk.nextToken());
				int y = Integer.parseInt(comTk.nextToken());
				String[] s = new String[y];
				for(int j=0;j<y;j++) {
					s[j] = comTk.nextToken();
					if(j>=n-x) break;
					pwd.add(x+j, s[j]);
				}
				

			}
			sb.append("#").append(tc+1).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(pwd.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	

}
