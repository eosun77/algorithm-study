package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.QueryEval;

public class Swea_암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<10;tc++) {
				int t = Integer.parseInt(in.readLine());
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				Queue<Integer> num = new LinkedList<Integer>();
				for(int i=0;i<8;i++) {
					num.offer(Integer.parseInt(st.nextToken()));
				}
				int n = 1;
				while(n>0) {
					for (int j = 1; j <= 5; j++) {
						n = num.poll()-j;
						if(n>0) {
							num.offer(n);
						}else {
							num.offer(0);
							break;
						}
					}
				}
				sb.append("#").append(t).append(" ");
				while(!num.isEmpty()) {
					sb.append(num.poll()).append(" ");	
				}

				sb.append("\n");
			} 
		System.out.println(sb);
	}

}
