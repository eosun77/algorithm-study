package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj_17143_낚시왕 {

	static class shark{

		int s;
		int d;
		int z;
		public shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}

	}
	
	static int R, C, M;
	static shark[][] map;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new shark[R][C];

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = new shark(s, d, z);

		}
		for(int c=0;c<C;c++) {
			fishingShark(c);
			map = moveShark();
		}
		System.out.println(ans);
	}
	
	static shark[][] moveShark() {
		int[] dx = {-1, 1, 0 , 0};
		int[] dy = {0, 0, 1, -1};
		shark[][] newMap = new shark[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!=null) {
					shark s = map[i][j];
					int nx = i;
					int ny = j;
					for(int t=0; t<s.s;t++) {
						if(s.d==1&&nx==0) s.d=2;
						else if(s.d==2&&nx==R-1) s.d=1;
						else if(s.d==3&&ny==C-1) s.d=4;
						else if(s.d==4&&ny==0) s.d=3;
						nx += dx[s.d-1];
						ny += dy[s.d-1];
					}
					if(newMap[nx][ny]==null) {
						newMap[nx][ny] = map[i][j];
					} else if(newMap[nx][ny].z < map[i][j].z) {
						newMap[nx][ny] = map[i][j];
					}
				}
			}
		}
		return newMap;
	}
	
	
	static void fishingShark(int c) {
		int depth=0;
		while(depth<R&&map[depth][c]==null) {
			depth++;
		}
		if(depth!=R) {
			shark s = map[depth][c];
			ans += s.z;
			map[depth][c] = null;
		}
	}
}
