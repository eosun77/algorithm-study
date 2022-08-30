package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_무선충전 {
	static int MAXCHARGE;
	static int cnt;

	static class User {
		public User(int x, int y) {
			this.x = x;
			this.y = x;
		}

		List<Integer> charger = new ArrayList<Integer>();
		int x;
		int y;
	}

	static class AP {
		public AP(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		int x;
		int y;
		int c;
		int p;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			MAXCHARGE = 0;
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[] moveA = new int[M + 1];
			int[] moveB = new int[M + 1];
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			AP[] arrAP = new AP[N];
			for (int i = 0; i < N; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				arrAP[i] = new AP(x, y, c, p);
			}
//			입력
			User A = new User(1, 1);
			User B = new User(10, 10);
			for (int i = 0; i <= M; i++) {
				Charge(arrAP, A, B);
				A = moving(A, moveA[i]);
				B = moving(B, moveB[i]);
			}
			sb.append("#").append(tc).append(" ").append(MAXCHARGE).append("\n");
		}
		System.out.println(sb);
	}

	static void Charge(AP[] arrAP, User A, User B) {
		int maxC = 0;
		A.charger.clear();
		B.charger.clear();
		for (int i = 0; i < arrAP.length; i++) {
			if (Math.abs(A.x - arrAP[i].x) + Math.abs(A.y - arrAP[i].y) <= arrAP[i].c) {
				A.charger.add(i);
			}
			if (Math.abs(B.x - arrAP[i].x) + Math.abs(B.y - arrAP[i].y) <= arrAP[i].c) {
				B.charger.add(i);
			}
		}
		if (A.charger.size() > 0 && B.charger.size() > 0) {
			for (int i = 0; i < A.charger.size(); i++) {
				for (int j = 0; j < B.charger.size(); j++) {
					if (A.charger.get(i) == B.charger.get(j)) {
						maxC = Math.max(maxC, arrAP[A.charger.get(i)].p);
					} else {
						maxC = Math.max(maxC, arrAP[A.charger.get(i)].p + arrAP[B.charger.get(j)].p);
					}
				}
			}
		} else {
			for (int i = 0; i < A.charger.size(); i++) {
				maxC = Math.max(maxC, arrAP[A.charger.get(i)].p);
			}
			for (int i = 0; i < B.charger.size(); i++) {
				maxC = Math.max(maxC, arrAP[B.charger.get(i)].p);
			}
		}
		MAXCHARGE += maxC;
//		System.out.println(cnt + ". A(" + A.x + ", " + A.y + ") / B(" + B.x + ", " +B.y+ ") : " + MAXCHARGE + " maxc : " + maxC);
		cnt++;
	}

	static User moving(User user, int com) {
		switch (com) {
		case 0:
			break;
		case 1:
			user.y--;
			break;
		case 2:
			user.x++;
			break;
		case 3:
			user.y++;
			break;
		case 4:
			user.x--;
			break;
		}
		return user;
	}
}
