package study_mar;

import java.io.*;
import java.util.*;

public class BJ_14502_연구소 {
	static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int[][] map;
	static int[][] select;
	static List<int[]> virus;
	static List<int[]> walls;
	static int N, M, S, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M]; // 연구소 정보
		virus = new ArrayList<>(); // 바이러스 목록
		walls = new ArrayList<int[]>(); // 가능성 있는 벽들(0인 곳들)

		select = new int[3][2]; // 선택한 벽
		S = 3;
		max = Integer.MIN_VALUE;

		// 연수소 정보 저장 하기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) { // 바이러스인 경우 list에 넣기
					virus.add(new int[] { i, j });
				}
			}
		}
		for (int i = 0; i < N; i++) { // 0인 좌표들을 넣기(벽이 될 가능성이 있는 좌표들)
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					walls.add(new int[] { i, j });
			}
		}

		// walls 목록에서 3개 선택하기
		Combi(0, 0);
		System.out.println(max);

	}

	private static void Combi(int cnt, int start) {
		if (cnt == S) { // 기저조건
			int[][] m = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, m[i], 0, M);
			}
			// 골랐으면 안전영역 구하러가기
			calcSave(m);
			return;
		}
		for (int i = start; i < walls.size(); i++) {
			select[cnt] = walls.get(i);
			Combi(cnt + 1, i + 1);
		}
	}

	private static void calcSave(int[][] nmap) { // 안전지역 구하기
		// 벽 세우기
		for (int i = 0; i < S; i++) {
			nmap[select[i][0]][select[i][1]] = 1;
		}

		// 바이러스 퍼지기
		Queue<int[]> que = new LinkedList<int[]>();
		for (int i = 0; i < virus.size(); i++) {
			que.offer(virus.get(i));
		}
		while (!que.isEmpty()) {
			int[] p = que.poll();
			for (int j = 0; j < 4; j++) { // 4방탐색
				int ni = p[0] + move[j][0];
				int nj = p[1] + move[j][1];
				if (check(ni, nj) && nmap[ni][nj] == 0) {
					nmap[ni][nj] = 2;
					que.offer(new int[] { ni, nj });
				}
			}
		}
		//안전지역 개수 구하기
		int cnt = 0; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (nmap[i][j] == 0)
					cnt++;
			}
		}
		max = Math.max(max, cnt);
	}

	static boolean check(int i, int j) { // 범위안에 있으면 true, 범위 벗어나면 false
		if (i >= 0 && i < N && j >= 0 && j < M)
			return true;
		return false;
	}
}
