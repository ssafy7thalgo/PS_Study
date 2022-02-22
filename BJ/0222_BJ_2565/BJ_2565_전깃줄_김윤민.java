package study_Feb;

import java.io.*;
import java.util.*;

public class BJ_2565_전깃줄 {
	static class Rope implements Comparable<Rope> {
		int from, to;
		public Rope(int from, int to) {
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Rope o) {
			return this.from - o.from;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Rope[] list = new Rope[N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			list[i] = new Rope(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		Arrays.sort(list);
		
		int[] maxRope = new int[N]; //각  루프까지의 설치할 수 있는 전기줄의 최대값을 저장
		int max = 0;
		for (int i = 0; i < N; i++) {
			maxRope[i] = 1;
			for (int j = 0; j < i; j++) {
				if(list[i].to>list[j].to) { //전기줄을 놓을 수 있는 경우
					maxRope[i] = Math.max(maxRope[i], maxRope[j]+1);
				}
			}
			max = Math.max(max, maxRope[i]);
		}
		System.out.println(N- max);
	}
}
