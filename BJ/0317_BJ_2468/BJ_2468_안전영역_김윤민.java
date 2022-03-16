package study_mar;

import java.util.*;
import java.io.*;

public class BJ_2468_안전영역 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] move = {{1,0},{-1,0},{0,1},{0,-1}}; //이동 배열
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int minh = Integer.MAX_VALUE; //최대 높이
		int maxh = Integer.MIN_VALUE; //최소 높이

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minh = Math.min(minh, map[i][j]);
				maxh = Math.max(maxh, map[i][j]);
			}
		}
		int safeMax = 1; //safe존의 최대 개수
		for (int i = minh; i < maxh; i++) { //최소 높이부터 최대높이 까지 물에 잠기는 지점을 정하기
			//각 높이마다 안전지대 개수 구하기 
			int safeCnt=0;
			boolean[][] visited = new boolean[N][N]; //방문배열
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k] > i && !visited[j][k] ) { //잠긴 지점보다 더 높고, 아직 방문 안했으면
						//bfs시작
						safeCnt++; //safe존 추가 
						//bfs 탐색으로 연결된 주변 지역을 찾기
						Queue<int[]> que = new LinkedList<int[]>();
						que.add(new int[] {j,k});
						while(!que.isEmpty()) {
							int[] temp = que.poll();
							int p = temp[0];
							int q = temp[1];
							for (int l = 0; l < 4; l++) { //4방 탐색
								int np = p+move[l][0];
								int nq = q+move[l][1];
								if(np>=0 && np<N && nq>=0 &&nq<N //범위 체크
										&&!visited[np][nq] && map[np][nq] > i) { //아직 방문하지 않았고, 잠긴 높이보다 더 높은 경우
									visited[np][nq] = true;
									que.add(new int[] {np,nq});
								}
							}
							
						}
					}
				}
			}
			safeMax = Math.max(safeMax, safeCnt);
		}
		System.out.println(safeMax);
		
	}
}
