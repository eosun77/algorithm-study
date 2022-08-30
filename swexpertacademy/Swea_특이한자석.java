package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_특이한자석 {
	static class Magnet {
		int[] edge = new int[8];

		public Magnet() {
			super();
		}
	}

	static Magnet[] magnets = new Magnet[4];

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(in.readLine());
			for (int i = 0; i < 4; i++) {
				magnets[i] = new Magnet();
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					magnets[i].edge[j] = Integer.parseInt(st.nextToken());
				}
			}
			int score = 0;
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int mgNum = Integer.parseInt(st.nextToken()) - 1;
				int op = Integer.parseInt(st.nextToken());
				MgTurn(mgNum, op);
				score = CalScore();
			}
			sb.append("#").append(tc).append(" ").append(score).append("\n");
		}
		System.out.println(sb);
	}

	static int CalScore() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += Math.pow(2, i) * magnets[i].edge[0];
		}
		return sum;
	}

	static void MgTurn(int mgNum, int op) {
		if (mgNum == 0) {
			if (canTurn(magnets[0], magnets[1])) {
				if (canTurn(magnets[1], magnets[2])) {
					if (canTurn(magnets[2], magnets[3])) {
						MagnetMove(magnets[3], -op);
					}
					MagnetMove(magnets[2], op);
				}
				MagnetMove(magnets[1], -op);
			}
			MagnetMove(magnets[0], op);
		} else if (mgNum == 1) {
			if (canTurn(magnets[0], magnets[1])) {
				MagnetMove(magnets[0], -op);
			}
			if (canTurn(magnets[1], magnets[2])) {
				if (canTurn(magnets[2], magnets[3])) {
					MagnetMove(magnets[3], op);
				}
				MagnetMove(magnets[2], -op);
			}
			MagnetMove(magnets[1], op);
		} else if (mgNum == 2) {
			if (canTurn(magnets[1], magnets[2])) {
				if (canTurn(magnets[0], magnets[1])) {
					MagnetMove(magnets[0], op);
				}
				MagnetMove(magnets[1], -op);
			}
			if (canTurn(magnets[2], magnets[3])) {
				MagnetMove(magnets[3], -op);
			}
			MagnetMove(magnets[2], op);
		} else if (mgNum == 3) {
			if (canTurn(magnets[2], magnets[3])) {
				if (canTurn(magnets[1], magnets[2])) {
					if (canTurn(magnets[0], magnets[1])) {
						MagnetMove(magnets[0], -op);
					}
					MagnetMove(magnets[1], op);
				}
				MagnetMove(magnets[2], -op);
			}
			MagnetMove(magnets[3], op);
		}
	}

	static boolean canTurn(Magnet mg1, Magnet mg2) {
		if (mg1.edge[2] != mg2.edge[6])
			return true;
		return false;

	}

	static void MagnetMove(Magnet mg, int op) {
		if (op == 1) {
			int temp = mg.edge[7];
			for (int i = 7; i > 0; i--) {
				mg.edge[i] = mg.edge[i - 1];
			}
			mg.edge[0] = temp;
		} else if (op == -1) {
			int temp = mg.edge[0];
			for (int i = 1; i <= 7; i++) {
				mg.edge[i - 1] = mg.edge[i];
			}
			mg.edge[7] = temp;
		}
	}

}
