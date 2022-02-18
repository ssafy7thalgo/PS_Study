package ps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_주유소_지근 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] size = new int[N - 1];
		int[] oils = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < size.length; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < oils.length; i++) {
			oils[i] = Integer.parseInt(st.nextToken());
		}
		
		long min = Long.MAX_VALUE;
		long sum = 0;
		
		for (int i = 1; i < oils.length; i++) {
			min = Math.min(min, oils[i - 1]);
			sum += size[i - 1] * min;
		}
		
		sb.append(sum);
		System.out.print(sb);
	}

}
