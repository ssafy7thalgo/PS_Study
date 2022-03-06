package BOJ_Silver;

/*
BOJ S1 미로탐색 https://www.acmicpc.net/problem/2178
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

    static class Coordinates {
        private int x;
        private int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    // 방향값 - 상, 우, 하, 좌
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // (1, 1)에서 시작할 것이기 때문에 1씩 더하기.
        int[][] graph = new int[N + 1][M + 1];
        int[][] visited = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }

        BFS(graph, visited, N, M);
    }

    // BFS
    public static void BFS(int[][] graph, int[][] visited, int N, int M) {
        // Queue 생성
        Queue<Coordinates> queue = new LinkedList<>();

        // 시작 좌표
        Coordinates start = new Coordinates(1, 1);
        // 큐에 시작점 추가
        queue.offer(start);
        // 해당 좌표 방문 처리 -- 1 (거리체크)
        visited[start.getY()][start.getX()] = 1;

        while (!queue.isEmpty()) {
            // 큐에서 노드 꺼내기
            Coordinates cur = queue.poll();
            int curX = cur.getX();
            int curY = cur.getY();

            for (int d = 0; d < 4; d++) {
                // 다음 노드
                int nextX = curX + moveX[d];
                int nextY = curY + moveY[d];

                // 유망한 경우에만
                if(isAvailable(nextX, nextY, graph, visited)) {
                    // 큐에 다음 좌표 삽입
                    queue.offer(new Coordinates(nextX, nextY));
                    // 거리 체크 (다음좌표까지의 거리는 현재 좌표 + 1)
                    visited[nextY][nextX] = visited[curY][curX] + 1;
                }
            }
        }

        // 출력
        System.out.println(visited[N][M]);
    }

    // 범위 이내이면서, 방문하지 않았고 이동할수 있는 칸(1)일 경우 true 리턴
    public static boolean isAvailable(int x, int y, int[][] graph, int[][] visited) {
        return y >= 1 && y < graph.length && x >= 1 && x < graph[y].length && graph[y][x] != 0 && visited[y][x] == 0;
    }
}
