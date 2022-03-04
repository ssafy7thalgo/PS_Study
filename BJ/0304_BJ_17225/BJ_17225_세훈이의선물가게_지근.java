package BOJ_Silver;
/*
BOJ S1 17225 https://www.acmicpc.net/problem/17225
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17225_세훈이의선물가게 {

    static class Present implements Comparable<Present> {
        private int time;
        private char color;

        public Present(int no, char color) {
            this.time = no;
            this.color = color;
        }

        private int getTime() {
            return time;
        }

        private char getColor() {
            return color;
        }

        @Override
        public int compareTo(Present o) {
            if (time == o.time) {
                // 시간이 같으면 상민이부터
                return color - o.color;
            }
            // 오름차순 (최소힙)
            return time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());   // 상민이의 포장시간
        int B = Integer.parseInt(st.nextToken());   // 지수의 포장시간
        int N = Integer.parseInt(st.nextToken());   // 총 손님의 수

        int sEnd = -1;  // 상민의 포장 끝나는 시간
        int jEnd = -1;  // 지수의 포장 끝나는 시간
        int count = 1;

        PriorityQueue<Present> pq = new PriorityQueue<Present>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());   // 주문 시각
            char c = st.nextToken().charAt(0);  // 선택한 포장지 색깔
            int m = Integer.parseInt(st.nextToken());   // 주문한 선물의 개수

            // 포장지 색깔이 B면 상민이 R이면 지수
            if (c == 'B') {
                // 전에 주문했던 포장의 끝나는 시간보다 현재 주문시각이 빠르면
                if (sEnd > t) {
                    t = sEnd;   // 현재 주문 시각을 전에 주문했던 포장의 끝나는 시간으로
                }

                // 포장에 걸리는 시간을 계산해 큐에 삽입
                for (int j = 0; j < m; j++) {
                    pq.offer(new Present((t + A * j), 'B'));
                }

                // 마지막으로 포장한 시간 계산 (다음 주문때 시작 시간)
                sEnd = t + m * A;
            } else {
                if (jEnd > t) {
                    t = jEnd;
                }

                for (int j = 0; j < m; j++) {
                    pq.offer(new Present((t + B * j), 'R'));
                }
                jEnd = t + m * B;
            }
        }

        ArrayList<Integer> blue = new ArrayList<>();
        ArrayList<Integer> red = new ArrayList<>();

        // 큐에서 꺼내 포장 색깔에 따라 분리하기.
        while(!pq.isEmpty()) {
            Present present = pq.poll();
            if (present.getColor() == 'B') {
                blue.add(count++);
            } else {
                red.add(count++);
            }
        }

        sb.append(blue.size()).append("\n");
        for (int n : blue) {
            sb.append(n).append(" ");
        }
        sb.append("\n");
        sb.append(red.size()).append("\n");
        for (int n : red) {
            sb.append(n).append(" ");
        }

        System.out.print(sb);
    }
}
