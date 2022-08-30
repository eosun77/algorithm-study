package swexpertacademy;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_요리사 {
	static int[][] S;
	static boolean[] isSel;
	static int N;
	static int MINF;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			MINF = Integer.MAX_VALUE;
			sb.append("#").append(t + 1).append(" ");
			N = Integer.parseInt(in.readLine());
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			isSel = new boolean[N];
			comb(0, 0);

			sb.append(MINF).append("\n");
		}
		System.out.println(sb);

	}

	static void comb(int depth, int R) {
		if (R == N / 2) {
			int[] selecA = new int[N / 2];
			int[] selecB = new int[N / 2];
			int cntA = 0;
			int cntB = 0;
			for (int i = 1; i <= N; i++) {
				if (isSel[i - 1]) {
					selecA[cntA++] = i;
				} else
					selecB[cntB++] = i;
			}
			int[] use = new int[2];
			boolean[] isUse = new boolean[N / 2];
			int flavorA = cooking(selecA, use, isUse, 0, 0);
			int flavorB = cooking(selecB, use, isUse, 0, 0);
			MINF = Math.min(MINF, Math.abs(flavorA - flavorB));
			return;
		}
		if (depth == N)
			return;
		isSel[depth] = true;
		comb(depth + 1, R + 1);
		isSel[depth] = false;
		comb(depth + 1, R);
	}

	static int cooking(int[] selec, int[] use, boolean[] isUse, int depth, int R) {
		int flavor =0;
		if(R==2) {
			return S[use[0]-1][use[1]-1] + S[use[1]-1][use[0]-1];
		}
		if(depth==N/2) return 0;
		
				isUse[depth] = true;
				use[R] = selec[depth];
				flavor +=cooking(selec, use, isUse, depth+1, R+1);
				isUse[depth] = false;
				flavor +=cooking(selec, use, isUse, depth+1, R);
		
		return flavor;
	}
}
