package study_Jan;

import java.io.*;
import java.util.Stack;

public class D4_5432_쇠막대기자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("docs/input_D4_5432.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 괄호 저장할 스택
			Stack<Character> stack = new Stack<Character>();
			char[] arr = br.readLine().toCharArray();

			// 첫번째 먼저 추가
			stack.add(arr[0]);
			// 잘라진 막대기 개수
			int cnt = 0;
			// 두번째 부터 시작
			for (int i = 1; i < arr.length; i++) {
				char ch = arr[i];
				if (ch == '(') { // ( 인 경우에는 스택에 넣기
					stack.add(ch);
				} else if (ch == ')') { // ) 인 경우에
					if (arr[i - 1] == '(') { // 만약 바로 전에 나왔던게 (이면 레이저이므로
						stack.pop(); // pop해주고
						cnt += stack.size(); // 현재 스택 사이즈 만큼 cnt 추가
					} else { // )가 연속으로 나온 경우 ex) ())
						if (stack.peek() == '(') { // top에 있는 원소가 ( 이라면 하나의 통나무가 완전히 다 잘린것
							stack.pop(); // pop해주고
							cnt++; // 1추가
						}
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, cnt);

		}

	}

}
