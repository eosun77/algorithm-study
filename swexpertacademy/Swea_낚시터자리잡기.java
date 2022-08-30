package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_낚시터자리잡기 {
	static int[][] map;
	static int N;
	static int minSum;
	static int[] gate;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			minSum = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			map = new int[2][N];
			gate = new int[3];
			Arrays.fill(map[0], 0);
			for(int i=0;i<3;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int y = Integer.parseInt(st.nextToken())-1;
				int p = Integer.parseInt(st.nextToken()); 
				map[1][y] = p;
				gate[i] = y;
			}
			boolean[] isvisited = new boolean[3];
			int[] output = new int[3];
			perm(isvisited, output, 0);
			sb.append("#").append(tc).append(" ").append(minSum).append("\n");
		}
		System.out.println(sb);
	}
	static void perm(boolean[] isvisited, int[] output, int depth) {
		if(depth==3) {
//			for(int i=0;i<3;i++) {
//				place2(output[i]);
//			}
//			int sum = 0;
//			for(int i=0;i<N;i++) {
//				sum += map[0][i];
//			}
//			minSum = Math.min(sum, minSum);
//			Arrays.fill(map[0], 0);
//			for(int i=0;i<3;i++) {
//				place1(output[i]);
//			}
//			sum = 0;
//			for(int i=0;i<N;i++) {
//				sum += map[0][i];
//			}
//			minSum = Math.min(sum, minSum);
//			Arrays.fill(map[0], 0);
			return;
		}
		for(int i=0;i<3;i++) {
			if(!isvisited[i]) {
				output[depth] = gate[i];
				isvisited[i] = true;
				perm(isvisited, output, depth+1);
				isvisited[i] = false;
			}
		}
	}
	
	static void place1(int gate) {
		int cnt = 1;
		int p = map[1][gate];
		while(p!=0) {
			if(map[0][gate]==0) {
				map[0][gate]=1;
				p--;
				continue;
			}
			
			if(cnt%2==0) {
				if(gate-cnt/2>=0&&map[0][gate-cnt/2]==0) {
					map[0][gate-cnt/2]= 1 + cnt/2;
					p--;
				} else cnt++;
			} else {
				if(gate+cnt/2<N&&map[0][gate+cnt/2]==0) {
					map[0][gate+cnt/2]= 1 + cnt/2;
					p--;
				} else cnt++;
			}
		}
	}
	
	static void place2(int gate) {
		int cnt = 1;
		int p = map[1][gate];
		while(p!=0) {
			if(map[0][gate]==0) {
				map[0][gate]=1;
				p--;
				continue;
			}
			
			if(cnt%2==1) {
				if(gate-cnt/2>=0&&map[0][gate-cnt/2]==0) {
					map[0][gate-cnt/2]= 1 + cnt/2;
					p--;
				} else cnt++;
			} else {
				if(gate+cnt/2<N&&map[0][gate+cnt/2]==0) {
					map[0][gate+cnt/2]= 1 + cnt/2;
					p--;
				} else cnt++;
			}
		}
	}
}
