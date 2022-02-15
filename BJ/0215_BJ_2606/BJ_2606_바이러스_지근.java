package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {

	static int N, M, count = 0;
	static boolean[][] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		M = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍의 수
		arr = new boolean[N + 1][N + 1]; 
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int nc = Integer.parseInt(st.nextToken());
			
			// 연결된 컴퓨터 체크
			arr[c][nc] = true;
			arr[nc][c] = true;
			
		}
		
		dfs(1); // 바이러스는 1번 컴퓨터에서 시작
		
		System.out.print(count); // 감염된 컴퓨터 개수 출력
	}
	
	static void bfs(int virus) {
		Queue<Integer> queue = new LinkedList<Integer>();
		// 컴퓨터 넣고
		queue.offer(virus);
		// 방문 체크
		visited[virus] = true;
		// 큐가 빌때까지
		while (!queue.isEmpty()) {
			int nq = queue.poll();
						
			for (int i = 1; i <= N; i++) {
				// 방문한 컴퓨터거나 컴퓨터간 연결되지 않았으면 패스
				if (visited[i] || !arr[nq][i]) {
					continue;
				}		
				
				// 그렇지 않으면 큐에 삽입하고
				queue.offer(i);
				// 방문 체크하고
				visited[i] = true;
				// 감염된 컴퓨터 개수 카운팅
				count++;
			}
		}
	}
	
	static void dfs(int virus) {
		// 방문 체크
		visited[virus] = true;
		
		for (int i = 1; i <= N; i++) {
			// 방문한 컴퓨터거나 컴퓨터간 연결되지 않았으면 패스
			if (visited[i] || !arr[virus][i]) {
				continue;
			}
			
			// 그렇지 않으면 감염된 컴퓨터 개수 카운팅하고
			count++;
			// 연결된 컴퓨터 탐색
			dfs(i);
		}
	}

}
