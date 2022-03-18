
import java.io.*;
import java.util.*;

public class BJ_14888_연산자끼워넣기 {
	static int[] op; 
	static int[] val; 
	static long min, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		val = new int[N];
		for (int i = 0; i < N; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int cnt =N-1; //연산자의 총 개수
		op = new int[cnt]; //0부터 순서대로 + - * /  ===> 연산자 총 개수에 맞춰서 저장 +:2, -:1, * :3 /:1이면   0012223이 저장
		int idx =0;
		for (int i = 0; i < 4; i++) {
			int nOp =  Integer.parseInt(st.nextToken());
			for (int j = 0; j < nOp; j++) {
				op[idx++] = i;
			}
		}
		min = Long.MAX_VALUE;
		max= Long.MIN_VALUE;
		//순열 시작
		perm(0, cnt, new int[cnt], new boolean[cnt]);
		System.out.println(max);
		System.out.println(min);
	}

	private static void perm(int cnt, int R, int[] result,  boolean[] visit) {
		if(cnt == R) { //연산기호 순서 정해지면 계산하기
//			System.out.println(Arrays.toString(result));
			long temp = val[0];
			for (int i = 0; i < R; i++) {
				 int op = result[i];
				 if(op== 0) temp = temp+val[i+1];
				 else if(op==1) temp = temp-val[i+1];
				 else if(op==2) temp = temp*val[i+1];
				 else if(op==3) temp = temp/val[i+1];
			}
			min = Math.min(min, temp);
			max = Math.max(max, temp);
			return;
		}
		
		for (int i = 0; i < R; i++) {
			if(visit[i]) continue;
			result[cnt] = op[i];
			visit[i] = true;
			perm(cnt+1, R, result, visit);
			visit[i] = false;
		}
	}
}
