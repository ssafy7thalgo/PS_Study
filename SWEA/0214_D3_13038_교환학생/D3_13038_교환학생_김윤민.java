package study_Jan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class D3_13038_교환학생 {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new FileInputStream("docs/input_D3_13038.txt"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {
			//1이 있는 인덱스를 저장할 list 
			List<Integer> starts = new ArrayList<Integer>();
			int n = sc.nextInt(); //들어야하는 수업 일수 
			int[] days = new int[7]; //수업 정보 
			for (int i = 0; i < 7; i++) {
				days[i] = sc.nextInt();
				if (days[i] == 1) //수업이 있는 경우 list에 인덱스 넣기
					starts.add(i);
			}

			int min = Integer.MAX_VALUE; // 지낸 최소 일수
			int i = 0; // 인덱스
			int day = 0; 
			//1이 있는 위치부터 시작
			for (int j = 0; j < starts.size(); j++) {
				i = starts.get(j); //인덱스 가져오기
				day = 0; // 지낸 일수
				int cnt = 0; // 수업 들은 횟수
				while (true) {
					//요일을 바꿔가면서 수업이 있는 경우 cnt 1 증가
					if (days[i++ % 7] == 1) { 
						cnt++;
					}
					day++; //지낸 일 수 증가
					if (cnt == n) { //수업 일수가 들어야하는 일수와 동일하면 반복문 빠져나오기
						break;
					}
				}
				//최소값 비교
				min = Math.min(day, min);
			}

			System.out.printf("#%d %d\n", test_case, min);
		}

	}

}
