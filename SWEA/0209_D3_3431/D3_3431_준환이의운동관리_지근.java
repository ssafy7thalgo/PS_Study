package im_D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_3431_준환이의운동관리_지근 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/input_D3_3431_준환이의운동관리.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int res = -1;
			
			if (X >= L && X <= U) {
				res = 0;
			} else if (X < L) {
				res = L - X;
			}
			
			System.out.printf("#%d %d%n", tc, res);
		}
	}

}
