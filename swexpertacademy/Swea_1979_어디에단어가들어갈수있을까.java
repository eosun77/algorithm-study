package swexpertacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1979_어디에단어가들어갈수있을까 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/swea/input_1979.txt"))));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			String strNK = in.readLine();

			StringTokenizer stNK = new StringTokenizer(strNK, " ");

			int N = Integer.parseInt(stNK.nextToken());
			int K = Integer.parseInt(stNK.nextToken());
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer=0;
			int cnt=0;
			

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]+ " ");
			}
				System.out.println("");
			}


			for (int i = 0; i < N; i++) {
				cnt = 0;
				for (int j = 0; j < N; j++) {
					if(map[i][j]==1) {
						cnt++;
					}
					if(map[i][j]==0||j==N-1) {
						if(cnt==K) answer++;
						if(map[i][j]==0) {
							cnt=0;
						}
					}
				}

			}
			for (int i = 0; i < N; i++) {
				cnt = 0;
				for (int j = 0; j < N; j++) {
					if(map[j][i]==1) {
						cnt++;
					}
					if(map[j][i]==0||j==N-1) {
						if(cnt==K) answer++;
						if(map[j][i]==0) {
							cnt=0;
						}
					}
				}

			}
			sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
