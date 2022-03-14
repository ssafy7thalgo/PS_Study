package BOJ_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {

    static int N; // 지도 크기
    static int[][] map; // 지도 배열
    static boolean[][] visited; // 방문 체크용 배열
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상, 하, 좌, 우
    static int count = 1; // 단지 번호 카운트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new int[N][N]; // N x N 지도 생성
        visited = new boolean[N][N]; // 방문 체크용 배열

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 해당 지역이 단지고, 방문하지 않았다면 탐색하고 단지의 개수 증가
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }

            }
        }

        // 단지 개수 출력
        sb.append(count - 1).append('\n');
        // 단지마다 집의 개수를 담을 배열 생성
        int[] answer = new int[count];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 해당 지역이 단지라면
                if (map[i][j] != 0) {
                    // 단지 번호 인덱스에 집의 개수 저장
                    answer[map[i][j]]++;
                }
            }
        }

        // 오름차순 정렬
        Arrays.sort(answer);

        // 0번 인덱스는 버리고 1번 인덱스부터 단지 개수 출력
        for (int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y) {
        map[x][y] = count; // 해당 집을 단지 번호로 초기화
        visited[x][y] = true; // 방문 체크

        // 4방 탐색
        for (int d = 0; d < 4; d++) {
            int nx = x + deltas[d][0];
            int ny = y + deltas[d][1];

            // 배열 범위를 벗어나면 넘어가기
            if (nx >= N || ny >= N || nx < 0 || ny < 0) {
                continue;
            }

            // 다음 좌표가 집이고, 방문하지 않았다면 탐색
            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
