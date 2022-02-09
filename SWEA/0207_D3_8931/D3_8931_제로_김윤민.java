package study_Jan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class D3_8931 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("docs/input_D3_8931.txt"));
		Scanner sc = new Scanner(System.in);
	
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			Stack<Integer> st = new Stack<Integer>();
			int N = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				int num = sc.nextInt();
				if(num != 0) {
					st.add(num);
				}else if(num==0) {
					st.pop();
				}
			}
			
			int sum =0;
			while(!st.empty()) {
				sum+= st.pop();
			}
			System.out.printf("#%d %d\n", test_case, sum);
			
		}
		
	}

}
