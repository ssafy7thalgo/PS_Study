package study_Jan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 1주일에 L분 이상 U이하의 운동
 * 이번주 운동 시간 X분 
 */
public class D3_3431 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("docs/input_D3_3431.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			int min = 0;
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			if(L > X) {
				min = L-X;
			}else if(X > U) {
				min=-1;
			}
			System.out.printf("#%d %d\n", test_case, min );
		}
		
		
	}
}
