
import java.io.*;
import java.util.*;

public class BJ_19942_다이어트 {
	static int N, minPrice;
	static int[] minVal;
	static int[][] arr;
	static List<String> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 식재료 개수
		StringTokenizer st = new StringTokenizer(br.readLine());

		minVal = new int[4]; // 순서대로 단, 지, 탄, 비 의 최소조건
		arr = new int[N][5]; // 재료 + 가격 입력 받아서 저장할 배열
		for (int i = 0; i < 4; i++) {
			minVal[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minPrice = Integer.MAX_VALUE;
		list = new ArrayList<>();
		// 재료 선택하기
		for (int i = 1; i <= N; i++) { // 뽑는 재료의 개수
			combi(0, 0, i, new int[i]);
		}

		if (list.size()==0) {
			System.out.println(-1);
		} else {
			Collections.sort(list);
			String ans = list.get(0);
			System.out.println(minPrice);
			System.out.println(ans);
		}
	}

	private static void combi(int cnt, int start, int R, int[] result) { //
		if (cnt == R) { // 조합 완성
			// 영양소 최소 기준을 충족하는지 확인하기
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				sum = 0;
				for (int i = 0; i < R; i++) { //
					sum += arr[result[i]][j];
				}
				if (j == 4)	break; //마지막이면 반복문 빠져나오기
				if (sum < minVal[j]) return;
			}
			if (minPrice >= sum) { // 기존의 최소가격보다 더 작거나 같은 경우에
				// 같은 경우라면 오름차순으로 했을때 더 빠른지 확인
				if(minPrice != sum) list.clear();
				minPrice = sum;
				StringBuilder ssb = new StringBuilder();
				for (int i = 0; i < R; i++) {
					ssb.append((result[i]+1)+" ");
				}
				list.add(ssb.toString());
			}
			return;
		}
		for (int i = start; i < N; i++) {
			result[cnt] = i;
			combi(cnt + 1, i + 1, R, result);
		}
	}
}
