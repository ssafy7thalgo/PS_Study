package im_D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_13218_조별과제 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/input_D3_13218_조별과제.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int max = N / 3;
			
			System.out.printf("#%d %d%n", tc, max);
		}
	}

}
