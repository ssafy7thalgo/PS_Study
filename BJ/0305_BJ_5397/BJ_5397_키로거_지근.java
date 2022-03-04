package BOJ_Silver;

/*
BOJ S3 5397 키로거
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BOJ_5397_키로거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();

            // 비밀번호를 저장할 리스트
            List<Character> list = new LinkedList<>();
            // 현재 커서(리스트 인덱스 번호)
            int idx = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                // 문자가 왼쪽 화살표면
                if (c == '<') {
                    // 커서가 맨 앞이라면 PASS
                    if (idx == 0) {
                        continue;
                    }
                    // 커서 왼쪽으로 이동
                    idx--;
                // 문자가 오른쪽 화살표면
                } else if (c == '>') {
                    // 커서가 맨 오른쪽이라면 PASS
                    if (idx == list.size()) {
                        continue;
                    }
                    // 커서 오른쪽으로 이동
                    idx++;
                // 문자가 백스페이스(-)라면
                } else if (c == '-') {
                    // 커서가 맨 앞이라면 PASS
                    if (idx == 0) {
                        continue;
                    }
                    // 앞의 문자 제거
                    list.remove(--idx);
                // 문자가 영문자 또는 숫자라면
                } else {
                    // 해당 커서에 비밀번호 삽입
                    list.add(idx, c);
                    // 비밀번호 넣었으니 커서 오른쪽으로 이동
                    idx++;
                }
            }

            // 비밀번호 출력
            for (char c : list) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();

            // 커서 기준으로 왼쪽 문자열 스택
            Stack<Character> left = new Stack<>();
            // 커서 기준으로 오른쪽 문자열 스택
            Stack<Character> right = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                // 왼쪽 화살표라면 커서 왼쪽의 문자열을 커서 오른쪽으로
                if (c == '<') {
                    // 커서 왼쪽에 문자 없으면 PASS
                    if (left.isEmpty()) {
                        continue;
                    }
                    right.push(left.pop());
                // 오른쪽 화살표라면 커서 오른쪽의 문자열을 커서 왼쪽으로
                } else if (c == '>') {
                    // 커서 오른쪽에 문자 없으면 PASS
                    if (right.isEmpty()) {
                        continue;
                    }
                    left.push(right.pop());
                // 백스페이스(-)라면 직전 문자 지우기
                } else if (c == '-') {
                    // 커서 왼쪽에 문자 없으면 PASS
                    if (left.isEmpty()) {
                        continue;
                    }
                    left.pop();
                // 문자라면
                } else {
                    // 커서 왼쪽부터 삽입하기
                    left.push(c);
                }
            }

            // 왼쪽에 저장된 문자들 순서대로 오른쪽 스택에 삽입하기
           while(!left.isEmpty()) {
                right.push(left.pop());
            }

           // 오른쪽에 저장된 문자들 꺼낸 순서대로 출력
            while(!right.isEmpty()) {
                sb.append(right.pop());
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
