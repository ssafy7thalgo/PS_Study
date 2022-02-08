package im_D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D3_8931_제로 {

	/*
	 * 스택의 특징 LIFO(후입선출 : 가장 나중에 넣은 데이터를 가장 먼저 꺼냄)
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/input_D3_8931_제로.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(in.readLine());
			int[] stk = new int[K + 1];
			int ptr = 0;
			int sum = 0;
			
			for (int i = 0; i < K; i++) {
				int n = Integer.parseInt(in.readLine());
				if (n == 0 && ptr >= 0) {
					ptr--;
				} else {
					stk[++ptr] = n;
				}
			}
			
			for (int i = 0; i <= ptr; i++) {
				sum += stk[i];
			}
			
//			Stack<Integer> stk = new Stack<>();
//			
//			for (int i = 0; i < K; i++) {
//				int n = Integer.parseInt(in.readLine());
//				// 입력값이 0이면 pop (가장 최근에 저장한 값 꺼내기)
//				if (n == 0) {
//					stk.pop();
//				// 입력값이 0이 아니면 push (스택에 입력값 저장하기)
//				} else {
//					stk.push(n);
//				}
//			}
//			
//			while (!stk.isEmpty()) {
//				sum += stk.pop();
//			}
			
			System.out.printf("#%d %d%n", tc, sum);
			
		}
	}

}
