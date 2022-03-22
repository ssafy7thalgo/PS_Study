package BJ_14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] op = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		int[] ops = new int[n - 1];
		getcomb(arr, 0, 0, 0, 0, op, ops, 0);
		System.out.println(max);
		System.out.println(min);

	}

	private static void getcomb(int[] arr, int p, int m, int x, int d, int[] op, int[] ops, int cnt) {

		if (p == op[0] && m == op[1] && x == op[2] && d == op[3]) {
			int temp = arr[0];
			for (int i = 0; i < ops.length; i++) {
				switch (ops[i]) {
				case 0:
					temp += arr[i + 1];
					break;
				case 1:
					temp -= arr[i + 1];
					break;
				case 2:
					temp *= arr[i + 1];
					break;
				case 3:
					temp /= arr[i + 1];
					break;

				}
			}

			if (temp > max) {
				max = temp;
			}
			if (temp < min) {
				min = temp;
			}

		} else {
			if (p < op[0]) {
				ops[cnt] = 0;
				getcomb(arr, p + 1, m, x, d, op, ops, cnt + 1);
			}
			if (m < op[1]) {
				ops[cnt] = 1;
				getcomb(arr, p, m + 1, x, d, op, ops, cnt + 1);
			}
			if (x < op[2]) {
				ops[cnt] = 2;
				getcomb(arr, p, m, x + 1, d, op, ops, cnt + 1);
			}
			if (d < op[3]) {
				ops[cnt] = 3;
				getcomb(arr, p, m, x, d + 1, op, ops, cnt + 1);
			}
		}

	}

}
