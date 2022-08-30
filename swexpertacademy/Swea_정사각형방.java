package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_정사각형방 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(in.readLine());
			int[][] room = new int[n][n];
			for(int i=0;i<n;i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for(int j=0;j<n;j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt =0;
			int cntMax=Integer.MIN_VALUE;
			int roomMax = Integer.MAX_VALUE;
			boolean[][] isV = new boolean[n][n];

			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!isV[i][j]) {
						cnt = find(room, i, j, isV);
						cnt++;
						if(cntMax==cnt) {
							if(roomMax>room[i][j]) roomMax = room[i][j];
						}
						if(cntMax<=cnt) {
							roomMax = room[i][j];
							cntMax = cnt;
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(roomMax).append(" ").append(cntMax).append("\n");
		}
		System.out.println(sb);
	}
	
	static int find(int[][] room, int i, int j, boolean[][] isV) {
		isV[i][j] = true;
		int num = room[i][j];
		int[] dr = {-1, 0, 1, 0};
		int[] dc = { 0, 1, 0 ,-1};
		for(int k=0;k<4;k++) {
			if(i+dr[k]<0||i+dr[k]>=room.length||j+dc[k]<0||j+dc[k]>=room.length) continue;
			else {
				if(num+1==room[i+dr[k]][j+dc[k]]) {
					return 1 + find(room, i+dr[k], j+dc[k], isV);
				}
			}
		}
		return 0;
	}
}
