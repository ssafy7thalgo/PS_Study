package ps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_5432_쇠막대기자르기 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_D4_5432_쇠막대기자르기.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			// 괄호 저장
			char[] arr = br.readLine().toCharArray();
			Stack<Character> stk = new Stack<Character>();
			int count = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(') {	// 여는 괄호라면
					stk.push('(');	// 스택에 추가
				}
				else {	// 닫는 괄호라면
					if (arr[i - 1] == '(') {	// 바로 이전 괄호가 여는 괄호였다면 레이저
						stk.pop();	// 여는 괄호 제거하고 개수 측정
						count += stk.size(); // 쌓여있는 '('만큼 쇠막대기가 쌓여있음
					} else { // 또 닫는 괄호라면
						count++;	// 제일 짧은 쇠막대기 
						stk.pop();	// 쇠막대기 개수 감소
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.print(sb);
	}

}
