package study_Jan;

import java.util.Scanner;

public class BJ_1012_유기농배추 {
	public static int[][] map; // 배추 위치
	public static boolean[][] isChecked; // 탐색 확인용
	public static int M; // 가로
	public static int N; // 세로
	public static int cnt; // 벌레 수
	// 4방 탐색
	public static int[] dr = { 1, -1, 0, 0 };
	public static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int test_case = 1; test_case <= tc; test_case++) {

			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();

			map = new int[N][M];
			isChecked = new boolean[N][M];
			cnt = 0;
			// 배추 위치 정보 저장
			for (int c = 0; c < K; c++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				map[x][y] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 1를 만나고, isChecked가 false면 dfs 시작
					if (map[i][j] == 1 && !isChecked[i][j]) {
						cnt++; // 애벌레 개수 추가
						isChecked[i][j] = true;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void dfs(int i, int j) {
		// 4방 탐색
		for (int k = 0; k < 4; k++) {
			int x = i + dr[k];
			int y = j + dc[k];

			// 인덱스 범위 확인
			if (x >= 0 && y >= 0 && x < N && y < M) {
				// 1이고, isSelected가 false인지 확인
				if (map[x][y] == 1 && !isChecked[x][y]) {
					isChecked[x][y] = true;
					dfs(x, y);
				}
			}
		}

	}

}
