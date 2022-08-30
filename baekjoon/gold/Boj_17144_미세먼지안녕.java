package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17144_미세먼지안녕 {
	static int R, C, T, acX;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					acX = i;
				}
			}
		}

		for(int i=0;i<T;i++) {
//			System.out.println();
			Diffusion();
//			for (int k = 0; k < R; k++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[k][j]+" ");
//				}
//				System.out.println();
//			}
			AirCleaner();
//			System.out.println();
//			for (int k = 0; k < R; k++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[k][j]+" ");
//				}
//				System.out.println();
//			}
		}

		int cnt=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]>0) cnt+=map[i][j];
			}

		}
		System.out.println(cnt);

	}

	static void AirCleaner() {
		int[][] nM = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				nM[i][j]=map[i][j];
			}
		}
		for(int i=1;i<C-1;i++) {
			nM[acX-1][i+1] = map[acX-1][i];
		}
		for(int i=1;i<C;i++) {
			nM[0][i-1] = map[0][i];
		}
		for(int i=1;i<C-1;i++) {
			nM[acX][i+1] = map[acX][i];
		}
		for(int i=1;i<C;i++) {
			nM[R-1][i-1] = map[R-1][i];
		}
		for(int i=acX-1;i>0;i--) {
			nM[i-1][C-1] = map[i][C-1];
		}
		for(int i=acX;i<R-1;i++) {
			nM[i+1][C-1] = map[i][C-1];
		}
		for(int i=0;i<acX-2;i++) {
			nM[i+1][0] = map[i][0];
		}
		for(int i=R-1;i>acX+1;i--) {
			nM[i-1][0] = map[i][0];
		}
		nM[acX-1][1]=0;
		nM[acX][1]=0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = nM[i][j];
			}
		}
	}

	static void Diffusion() {
		int[][] nM = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				nM[i][j] = map[i][j];
			}
		}

		int[] dc = { 1, -1, 0, 0 };
		int[] dr = { 0, 0, 1, -1 };
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					boolean[] canDiffuse = new boolean[4];
					for (int k = 0; k < 4; k++) {
						int nx = i + dc[k];
						int ny = j + dr[k];

						if (nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1) {
							canDiffuse[k] = false;
							continue;
						}
						canDiffuse[k] = true;
					}
					for (int k = 0; k < 4; k++) {
						if (canDiffuse[k]) {
							int nx = i + dc[k];
							int ny = j + dr[k];
							nM[nx][ny] += map[i][j] / 5;
							nM[i][j] -= map[i][j] / 5;
						}
					}

				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = nM[i][j];
			}
		}
	}

}
