package BOJ_Silver;

/*
BOJ
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15663_N과M9 {

    static int N, M;
    static int[] input, numbers;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        numbers = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        permutation(0);
        System.out.print(sb);
    }

    public static void permutation(int cnt) {

        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int n = 0;

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) {
                continue;
            }

            if (n == input[i]) {
                continue;
            }

            n = input[i];
//          System.out.println("i : " + i + " n : " + input[i]);

            numbers[cnt] = input[i];
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }
}
