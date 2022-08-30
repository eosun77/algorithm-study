package swexpertacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_2001_파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/swea/input_2001.txt"))));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0;tc<T;tc++) {
			int answer = 0;
			String strNK = in.readLine();

			StringTokenizer stNK = new StringTokenizer(strNK, " ");

			int N = Integer.parseInt(stNK.nextToken());
			int M = Integer.parseInt(stNK.nextToken());

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println("");
//			}
			int sum =0;
			int MAX = Integer.MIN_VALUE;
			for(int i=0;i<N-M+1;i++) {
				for(int j =0;j<N-M+1;j++) {
					sum = 0;
					for(int k=0;k<M;k++) {
						for(int l=0;l<M;l++) {
							sum += map[i+k][j+l];
						}
					}
					if(MAX<sum) {
						MAX= sum;
					}
				}
			}
			answer = MAX;

			sb.append("#").append(tc + 1).append(" ").append(answer).append("\n");
		}System.out.println(sb);
	}

}