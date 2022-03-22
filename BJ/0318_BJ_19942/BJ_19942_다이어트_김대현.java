package BJ_19942_다이어트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int min = Integer.MAX_VALUE;
	static int n, mp, mf, ms, mv;
	static int[][] arr;
	static boolean[] check;
	static int[] answer;
	static boolean checks = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		arr = new int[n][5];
		check = new boolean[n];
		answer = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		getPrice(0, 0, 0, 0, 0, 0);
		if (checks) {
			System.out.println(min);
			for (int i = 0; i < n; i++) {
				if (answer[i] == 0) {
					break;
				}
				System.out.print(answer[i] + " ");
			}

		} else {
			System.out.println("-1");
		}

	}

	private static void getPrice(int price, int num, int p, int f, int s, int v) {

		if (p >= mp && f >= mf && s >= ms && v >= mv) {
			checks = true;
			if (min > price) {
				min = price;
				int cnt = 0;
				for (int i = 0; i < n; i++) {
					if (check[i]) {
						answer[cnt++] = i + 1;
					}
				}
				for (int i = cnt; i < n; i++) {
					answer[i] = 0;
				}
			}
		} else if (price > min || num == n) {
			return;
		} else {
			check[num] = true;
			getPrice(price + arr[num][4], num + 1, p + arr[num][0], f + arr[num][1], s + arr[num][2], v + arr[num][3]);
			check[num] = false;
			getPrice(price, num + 1, p, f, s, v);
		}

	}

}
