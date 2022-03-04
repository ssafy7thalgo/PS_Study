package study_mar;

import java.io.*;
import java.util.*;

public class BJ_5397_키로거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			Stack<Character> front = new Stack<>(); //커서를 기준으로 앞에 있는 문자들
			Stack<Character> back = new Stack<>(); //뒤에 있는 문자들
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(ch =='<') {
					if(front.size()>0) { //범위 확인 후 
						back.add(front.pop()); //앞에서 하나 꺼내서 뒤로 보내기
					}
				}
				else if(ch=='>') {
					if(back.size()>0) {
						front.add(back.pop()); //뒤에있던 문자 하나 꺼내서 앞에 집어 넣기 
					}
				}
				else if(ch=='-') {
					if(front.size()>0) {
						front.pop(); // front에서 하나 제거
					}
				}
				else {
					front.add(ch);
				}
			}
			while(!front.isEmpty()) { //front에 있는 값들을 뒤로 보내주기
				back.add(front.pop());
			}
			
			StringBuilder sb = new StringBuilder();
			while(!back.isEmpty()) {
				sb.append(back.pop()); //하나씩 꺼내면서 sb에 추가
			}
			System.out.println(sb);
		}
		
		//list 방식
//		for (int tc = 1; tc <= T; tc++) {
//			String str = br.readLine();
//			List<Character> list = new ArrayList<>();
//			int index = 0;
//			for (int i = 0; i < str.length(); i++) {
//				char ch = str.charAt(i);
//				if (ch == '<') {
//					if (index - 1 >= 0)
//						index--;
//				} else if (ch == '>') {
//					if (index + 1 <= list.size())
//						index++;
//				} else if (ch == '-') {
//					if (index - 1 >= 0)
//						list.remove(--index);
//				}else {
//					list.add(index, ch);
//					index++;
//				}
//			}
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(list.get(i));
//			}
//			System.out.println();
//		}

	}
}
