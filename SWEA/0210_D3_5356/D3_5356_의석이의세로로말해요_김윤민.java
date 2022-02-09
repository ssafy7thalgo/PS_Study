package study_Jan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_5356 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("docs/input_D3_5356.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int test_case = 1; test_case <=tc; test_case++) {
			int N = 5;
			int max =0;
			char[][] arr = new char[5][];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				arr[i] = str.toCharArray();
				max = Math.max(str.length() , max);
			}
			
			
			System.out.printf("#%d ",test_case);
			for (int i = 0; i < max; i++) { // 열
				for (int j = 0; j < N; j++) { //행
					if(arr[j].length <= i) continue;
					System.out.print(arr[j][i]);;
				}
			}
			System.out.println();
			
		}
	}
}
