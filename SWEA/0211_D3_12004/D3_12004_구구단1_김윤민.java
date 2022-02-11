package study_Jan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_12004_구구단_1 {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new FileInputStream("docs/input_D3_12004.txt"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			int n = sc.nextInt();
			String ans = "No";
			//1부터 9까지 반복하면서
			for (int i = 1; i <= 9; i++) {
				//나누어 떨어지는 수 찾기
				if (n % i == 0) {
					//나누기 한 수가 1-9 사이에 있으면 ans를 yes로 변경, 나머지인 경우는 모두 no
					if (n / i>= 1 && n / i <= 9) {
						ans = "Yes";
						break;
					}
				}

			}

			System.out.printf("#%d %s\n", test_case, ans);
		}

	}
}
