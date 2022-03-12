package study_mar;

import java.io.*;
import java.util.*;

public class BJ_15663_N과M {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		// 중복 순열
		perm(0, M, arr, new int[M], new boolean[N]);

		System.out.println(sb);
	}

	private static void perm(int cnt, int M, int[] arr, int[] ans, boolean[] visited) {
		if (cnt == M) { //기저 조건
			for (int i = 0; i < M; i++) {
				sb.append(ans[i]+" ");
			}sb.append("\n");
			return;
		}
		boolean[] check = new boolean[10001];  //중복 배열을 방지하기 위한 배열
		for (int i = 0; i < arr.length; i++) {
			boolean[] nvisited = Arrays.copyOf(visited, visited.length); 
			//1 3 9 9 가 있고, 현재 선택된것이 3이고 두번째 숫자를 고를 경우 1 9 9 가 나올 수 있음.
			//이런 상황에서 9가 두번 나오면 안되기 때문에 체크해주는 것. 
			if(!check[arr[i]] && !visited[i]) { //같은 자리에 중복된 수가 나오면 안되기때문에 체크해주는 부분
			check[arr[i]]=true;
			
			//순열 만드는 부분
			ans[cnt] = arr[i];
			nvisited[i] = true;
			perm(cnt + 1, M, arr, ans, nvisited);
			nvisited[i] = false;
			}
		}
	}
}
