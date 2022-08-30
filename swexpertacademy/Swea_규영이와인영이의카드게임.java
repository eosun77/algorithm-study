package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_규영이와인영이의카드게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			List<Integer> card = new ArrayList<>();

			for (int i = 1; i <= 18; i++) {
				card.add(i);
			}
			int[] num1 = new int[9];
			int[] num2 = new int[9];
			for (int i = 0; i < 9; i++) {
				num1[i] = Integer.parseInt(st.nextToken());
				card.remove(card.indexOf(num1[i]));
			}
			for (int i = 0; i < 9; i++) {
				num2[i] = card.get(i);
			}
			int[] num3 = new int[9];
			boolean[] visited= new boolean[9];
			int cnt =perm(num1, num2, num3, visited, 0, 9, 9);
			sb.append("#").append(tc).append(" ").append(362880-cnt).append(" ").append(cnt).append("\n");
			
		}
		System.out.println(sb);

	}
	
	static int perm(int[] num1, int[] num2, int[] num3, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			int sum=0;
	    	for (int i = 0; i < 9; i++) {
	    		 if(num3[i]>num1[i]) sum += num1[i] + num3[i];
	    		  if(sum>=86) {
	    			  return 1;
	    		  }
	    	}
	        return 0;
	    }
		
		int cnt = 0;
	 
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            num3[depth] = num2[i];
	            cnt += perm(num1, num2, num3, visited, depth + 1, n, r);       
	            visited[i] = false;
	        }
	    }
	    return cnt;
	}

}
