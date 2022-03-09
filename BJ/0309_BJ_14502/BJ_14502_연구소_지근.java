package BOJ_Silver;

/*
BOJ G5 연구소 https://www.acmicpc.net/problem/14502
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14502_연구소 {

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

    // 안전 영역 크기 출력값
    static int answer;
    // 방향값
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 세로 크기
        int M = Integer.parseInt(st.nextToken()); // 가로 크기
        answer = Integer.MIN_VALUE; // 출력값

        int[][] graph = new int[N][M];  // 연구소 배열
        List<Coordinates> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) { // 바이러스 좌표 ArrayList에 삽입
                    list.add(new Coordinates(i, j));
                }
            }
        }

        combination(graph, list, 0);
        System.out.println(answer);
    }

    // 조합으로 빈 칸(0)인 곳들 중 벽 3개를 세우는 경우를 구한다.
    public static void combination(int[][] graph, List<Coordinates> list, int cnt) {
        // 기저
        if (cnt == 3) { // 벽을 3개 세우면
            int[][] copiedArr = copy(graph); // 이전 배열 복사해서 확인
            BFS(copiedArr, list); // 바이러스 전염 BFS
            return;
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                // 0 : 해당 좌표가 빈 칸일 때
                if (graph[i][j] == 0) {
                    graph[i][j] = 1; // 벽 세우는 경우
                    combination(graph, list, cnt + 1);
                    graph[i][j] = 0; // 벽 세우지 않는 경우
                }
            }
        }

    }

    // 배열 복사하기
    public static int[][] copy(int[][] graph) {
        int[][] copiedArr = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            System.arraycopy(graph[i], 0, copiedArr[i], 0, graph[i].length);
        }

        // 복사된 배열 반환
        return copiedArr;
    }

    public static void BFS(int[][] graph, List<Coordinates> list) {
        Queue<Coordinates> queue = new LinkedList<>();

        // 바이러스들을 큐에 삽입
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }

        // 큐가 빌 때 까지
        while(!queue.isEmpty()) {
            // 큐에서 바이러스를 꺼내서
            Coordinates cur = queue.poll();
            int curX = cur.getX();
            int curY = cur.getY();

            // 4방향 탐색해서
            for (int d = 0; d < 4; d++) {
                int nextX = curX + moveX[d];
                int nextY = curY + moveY[d];

                // 다음 좌표의 값이 범위 이내이고, 값이 0이라면
                if (isAvailable(nextX, nextY, graph)) {
                    graph[nextX][nextY] = 2; // 바이러스 전염시키기
                    queue.offer(new Coordinates(nextX, nextY)); // 해당 좌표 큐에 추가 BFS
                }
            }
        }

        // BFS가 끝날때마다 안전 영역 크기 찾기
        getSafeArea(graph);
    }

    public static void getSafeArea(int[][] graph) {
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0) { // 0 : 안전 영역 개수 카운팅
                    count++;
                }
            }
        }

        // 안전 영역 개수 중 최댓값 구하기
        answer = Math.max(answer, count);
    }

    // 범위 체크 (범위 이내이며, 빈칸인 경우 true)
    public static boolean isAvailable(int x, int y, int[][] graph) {
        if (x >= 0 && x < graph.length && y >= 0 && y < graph[x].length && graph[x][y] == 0) {
            return true;
        }

        return false;
    }
}