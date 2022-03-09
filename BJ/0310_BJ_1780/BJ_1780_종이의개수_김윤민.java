package study_mar;

import java.io.*;
import java.util.*;

public class BJ_1780_종이의개수 {
	static int N;
	static int[][] map;
	static int[] cnt; // -1, 0, 1 순서대로 종이의 개수를 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cnt = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0, 0, N); //분할 시작
		
		for (int i : cnt) {
			sb.append(i+"\n");
		}
		System.out.println(sb);
	}

	private static void divide(int i, int j, int n) { // 시작 좌표와 길이
		int t = map[i][j];

		if (n == 1) { // 기저 조건
			cnt[get(t)]++;
			return;
		}
		// 전체가 같은지 확인
		boolean check = false;
		for (int k = i; k < i + n; k++) {
			for (int z = j; z < j + n; z++) {
				if (map[k][z] != t) { //하나라도 다른게 있다면 check변수 true로
					check = true;
					break;
				}
			}
		}
		if (check) { // 전체가 전부 같지 않는 경우 3분할 , 3분할 해서 재귀함수
			for (int k = 0; k < 3; k++) {
				for (int z = 0; z < 3; z++) {
					divide(i + n / 3 * k, j + n / 3 * z, n / 3);
				}
			}

		} else { // 전체가 같은 경우
			cnt[get(t)]++; 
		}
	}

	static int get(int t) { //인덱스를 가져오는 함수
		if (t == -1) return 0;
		else if (t == 0) return 1;
		else return 2;
	}
}
