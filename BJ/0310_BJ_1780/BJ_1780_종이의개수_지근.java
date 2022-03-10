package BOJ_Silver;

/*
BOJ S2 1780 종이의 개수
https://www.acmicpc.net/problem/1780
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {

    static int[][] arr;
    static int[] answer = new int[3]; // 0번 인덱스부터 -1, 0, 1로 채워진 종이 개수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 배열 크기
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, N);

        // 출력
        sb.append(answer[0]).append("\n").append(answer[1]).append("\n").append(answer[2]);
        System.out.print(sb);
    }

    public static void recursion(int r, int c, int size) {
        if (size == 0) {
            return;
        }

        // 해당 영역이 같은 색(숫자)이면 카운팅하고 종료
        if (check(r, c, size)) {
            answer[++arr[r][c]]++;
            return;
        }

        // 분할할 크기 (3개로)
        int nextSize = size / 3;

        // 현재위치+분할한크기마다 반복하며 재귀
        for (int i = r; i < r + size; i+=nextSize) {
            for (int j = c; j < c + size; j+=nextSize) {
                recursion(i, j, nextSize);
            }
        }
    }

    // 현재 위치에서 size만큼을 확인해 모두 같은 색(숫자)이면 true 반환
    public static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != arr[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
