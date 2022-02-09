package im_D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_10912_외로운문자 {

	/*
	 * 1. 입력한 문자의 개수를 배열에 저장
	 * 2. 입력한 문자가 홀수면 외로운 문자이므로 출력
	 * 3. 외로운 문자가 발견되지 않았으면 Good 출력
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/input_D3_10912_외로운문자.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int[] count = new int['z' + 1];
			String str = in.readLine();
			char ch = 0;
			
			for (char c : str.toCharArray()) {
				count[c]++;
			}
			
			System.out.printf("#%d ", tc);
			for (int i = 0; i < count.length; i++) {
				if (count[i] != 0 && count[i] % 2 != 0) {
					ch = (char)i;
					System.out.print(ch);
				}
			}
			
			if (ch == 0) {
				System.out.print("Good");
			}
			
			System.out.println();				
		}
	}

}
