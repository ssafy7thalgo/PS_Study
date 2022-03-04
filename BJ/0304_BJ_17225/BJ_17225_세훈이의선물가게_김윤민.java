package study_mar;

import java.io.*;
import java.util.*;

public class BJ_17225_세훈이의선물가게 {
	static class Order implements Comparable<Order> {
		long time;
		int count;
		String color;

		public Order(long time, String color, int count) {
			this.time = time;
			this.color = color;
			this.count = count;
		}

		@Override
		public int compareTo(Order o) {
			return (int) (time == o.time ? color.compareTo(o.color) : time - o.time);

		}

		@Override
		public String toString() {
			return "Order [time=" + time + ", count=" + count + ", color=" + color + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); // 상민 시간
		int B = Integer.parseInt(st.nextToken()); // 지수 시간
		int N = Integer.parseInt(st.nextToken()); // 손님 수

		List<Integer> S = new ArrayList<>(); // 상민이 포장한 상품 번호
		List<Integer> J = new ArrayList<>(); // 지수가 포장한 상품 번호
		PriorityQueue<Order> pq = new PriorityQueue<Order>(); //주문 목록
		long sMaxTime = 0;
		long jMaxTime = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long time = Integer.parseInt(st.nextToken());
			String color = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			if (color.equals("B")) { //상민인 경우
				if (time < sMaxTime) //전에 있던 주문의 포장을 완료한 시간보다 time이 더 작으면 미뤄야하므로
					time = sMaxTime; //time을 전 주문 포장 완료 시간으로 교체
				pq.add(new Order(time, color, count)); //우선순위큐에 주문 넣어주기
				sMaxTime = time + A * count; //현재까지의 주문 완료 시간 갱신
			} else { //지수인 경우 위와 동일
				if (time < jMaxTime)
					time = jMaxTime;
				pq.add(new Order(time, color, count));
				jMaxTime = time + B * count;
			}
		}

		int num = 1; // 선물 번호. 1번 부터 시작
		while (!pq.isEmpty()) { //큐에 있는 주문이 다 나올때까지
			Order current = pq.poll();
			if (current.count == 0)	continue;
			long time = current.time; //시간
			if (current.color.equals("B")) { //상민
				S.add(num++); //상품 번호를 상민의 큐에 넣고 상품번호+1
				time += A; //상품을 포장한 시간을 추가해주기
				pq.add(new Order(time, current.color, current.count - 1)); //주문 수량개수를 하나 감소하고 다시 pq에 넣어주기
			} else { //지수
				J.add(num++);
				time += B;
				pq.add(new Order(time, current.color, current.count - 1));
			}

		}

		System.out.println(S.size());
		for (Integer i : S) {
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println(J.size());
		for (Integer i : J) {
			System.out.print(i + " ");
		}
	}
}
