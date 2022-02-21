package study_Feb;

import java.io.*;
import java.util.*;

public class BJ_17128_소가정보섬에올라온이유 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 소의 수
		int Q = Integer.parseInt(st.nextToken()); // 장난칠 횟수

		int[] arr = new int[N]; //소의 품질 점수
		int[] S = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			//i번째소를 마지막으로하는 합을 계산 i가 4라면 1 2 3 4의 소의 점수를 계산한것
			S[i]=arr[i] * arr[(i - 1 <0)? N+i-1:i-1 ] * arr[(i - 2 <0)? N+i - 2:i - 2] * arr[(i - 3 <0)? N+i - 3:i - 3];
			//S의 모든 원소의 합
			sum +=arr[i] * arr[(i - 1 <0)? N+i-1:i-1 ] * arr[(i - 2 <0)? N+i - 2:i - 2] * arr[(i - 3 <0)? N+i - 3:i - 3];
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(st.nextToken()) - 1; //인덱스가 0에서 시작
			for (int j = 0; j < 4; j++) { //q가 포함된 4개의 S만 사용
				S[q] = -S[q]; //값 업데이트
				sum+= 2* S[q]; // 기존 값에서 새로 수정한 값을 반영하기 위한 수식
				q = (q+1)%N; //1 더해주기 
			}
			System.out.println(sum);
		}
	}
}
