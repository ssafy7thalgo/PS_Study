package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	
	static int N, M, K; // 세로길이, 가로길이, 배추개수
	static int[][] map; // 배추밭
	static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
	static boolean[][] visited;	// 방문 체크

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());	// 가로 길이 = 열의 개수
			N = Integer.parseInt(st.nextToken());	// 세로 길이 = 행의 개수
			K = Integer.parseInt(st.nextToken());	// 배추 개수
			map = new int[N][M];
			visited = new boolean[N][M];
			int count = 0;	// 인접한 배추 그룹의 개수

			for (int i = 0, x, y; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x = Integer.parseInt(st.nextToken()); // 배추의 X좌표
				y = Integer.parseInt(st.nextToken()); // 배추의 Y좌표
				map[y][x] = 1;
			}			

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 해당 지역에 배추가 있고 방문하지 않은 곳이라면 탐색, 배추 그룹의 개수 증가
					if (map[i][j] == 1 && !visited[i][j]) {
						solve(i, j);
						count++;
					}
				}
			}
			
			sb.append(count).append('\n');
		}
		
		System.out.print(sb);
	}
	
	static void solve(int x, int y) {
		// 해당 지역 방문 체크
		visited[x][y] = true;
		
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			// 배열 범위 바깥이면 넘어가기
			if (nx >= N || nx < 0 || ny >= M || ny < 0) {
				continue;
			}
			
			// 해당 지역에 배추가 있고 방문하지 않은 곳이라면 탐색
			if (map[nx][ny] == 1 && !visited[nx][ny]) {
				solve(nx, ny);
			}
		}

	}

}
