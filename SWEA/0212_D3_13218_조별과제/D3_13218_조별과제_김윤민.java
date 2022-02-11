package study_Jan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_13218_조별과제 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("docs/input_D3_13218.txt"));

		int tc = sc.nextInt();
		
		for (int test_case = 1; test_case <= tc;test_case++) {
			int n = sc.nextInt();
			
			System.out.printf("#%d %d", test_case, n/3);
		}
	}

}
