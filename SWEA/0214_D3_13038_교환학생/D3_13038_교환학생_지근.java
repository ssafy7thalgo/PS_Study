package ps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 총 목표일 수가 3일 때 주당 수업 횟수가 2면 통으로 보내야 하는 주는 1개 n = 3, day = 2 -> week = 1
 * 총 목표일 수가 100000일 때 주당 수업 횟수가 3이면 통으로 보내야 하는 주는 33333개 n = 100000, day = 3 -> week = 33333
 * 총 목표일 수가 1일 때 주당 수업 횟수가 1이면 통으로 보내야 하는 주는 0개 n = 1, day = 1 -> week = 0
 * n = 1, day = 2 -> week = 0
 * n = 10, day = 3 -> week = 3
 * n = 12, day = 4 -> week = 2 ~ 3
 */
public class D3_13038_교환학생 {
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_D3_13038_교환학생.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] days = new int[7];
			int[] count = new int[7];
			int day = 0;
			int week = 0;
			
			for (int i = 0; i < 7; i++) {
				// 일주일 배열
				days[i] = Integer.parseInt(st.nextToken());
				// 수업이 열리면 일수 증가
				if (days[i] == 1) {
					day++;
				}
			}
			
			// 목표 일수가 주마다 열리는 수업일수로 나누어 떨어지면
			if (n % day == 0) {
				// 총 지내야 하는 주
				week = n / day - 1;
			// 나누어 떨어지지 않으면
			} else {
				week = n / day;
			}
			
			// 총 몇 주동안 지내야하는지는 구했으니 
			// 마지막 남은 주에 들어야 하는 목표일수로 초기화한다.
			n -= day * week;
			
			
			
			for (int i = 0; i < 7; i++) {
				int cnt = 0; // 수업 일수
				int j = i;
				
				// 해당 요일부터 일주일 동안
				for (j = i; j < i + 7; j++) {
					// 수업이 있으면 수업 일수 증가
					if (days[j % 7] == 1) {
						cnt++;
					}
					// 수업 일수가 목표일수와 같아지면 탈출
					if (cnt == n) {
						break;
					}
				}
				count[i] = j - i + 1;
//				System.out.println(tc + " " + count[i]);
			}
			
			int min = 7;
			for (int i = 0; i < 7; i++) {
				if (count[i] < min) {
					min = count[i];
				}
			}
			
			// 주에 지내야하는 일수 + 보내야하는 주 * 7 = 최소 일수
			min += week * 7;
			
			sb.append('#').append(tc).append(' ').append(min).append('\n');
		}
		System.out.print(sb);
	}

}
