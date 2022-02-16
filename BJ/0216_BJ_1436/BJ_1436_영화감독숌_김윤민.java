package study_Jan;

import java.util.Scanner;

public class BJ_1436_영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int cnt = 0;
		for (int i =666 ; i < Long.MAX_VALUE; i++) {
			//숫자에 666이 포함되어있다면
			if (Integer.toString(i).contains("666")) {
				cnt++; //cnt 1 추가
				if (cnt == N) { //cnt 값이 N번째라면 
					System.out.println(i); //출력후 break;
					break;
				}

			}
				
		}
		
	}

}
