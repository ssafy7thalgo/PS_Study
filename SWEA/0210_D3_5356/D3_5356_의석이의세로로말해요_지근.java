package im_D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_5356_의석이의세로로말해요_지근 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/input_D3_5356_의석이의세로로말해요.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			// 행 5줄, 열 최대 15자
			char[][] arr = new char[5][15];
			
			// 배열에 문자열 입력
			for (int i = 0; i < 5; i++) {
				String str = in.readLine();
				for (int j = 0; j < str.length(); j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {					
					if (arr[j][i] != 0) {
						sb.append(arr[j][i]);
					}
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
