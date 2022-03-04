package BJ_17225_세훈이의선물가게;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static class gift implements Comparable<gift>{
		public gift(int time, char c) {
			this.time=time;
			this.c=c;
		}
		int time;
		char c;
		@Override
		public int compareTo(gift o) {
			if(this.time==o.time) {
				return this.c-o.c;
			}
			return this.time-o.time;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());

		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());

		Queue<Integer> answer_a=new LinkedList<>();
		Queue<Integer> answer_b=new LinkedList<>();
		int atime=0;
		int btime=0;
		
		for(int i=0; i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int time=Integer.parseInt(st.nextToken());
			char c=st.nextToken().charAt(0);
			int mount=Integer.parseInt(st.nextToken());
			if(c=='B') {
				while(mount!=0) {
					atime=Math.max(atime, time);
					answer_a.offer(atime);
					atime=atime+a;
					mount--;
				}
			}else if(c=='R') {
				while(mount!=0) {
					btime=Math.max(btime, time);
					answer_b.offer(btime);
					btime=btime+b;
					mount--;
				}
			}
		}

		PriorityQueue<gift> que=new PriorityQueue<>();
		
		while(!answer_a.isEmpty()) {
			que.offer(new gift(answer_a.poll(),'B'));
		}
		while(!answer_b.isEmpty()) {
			que.offer(new gift(answer_b.poll(),'R'));
		}
		int num=1;
		while(!que.isEmpty()) {
			if(que.poll().c=='B') {
				answer_a.offer(num++);
			}else {
				answer_b.offer(num++);
				
			}
		}
		StringBuilder sb=new StringBuilder();
		sb.append(answer_a.size()).append("\n");
		while(!answer_a.isEmpty()) {
			sb.append(answer_a.poll()).append(" ");
		}
		sb.append("\n").append(answer_b.size()).append("\n");
		while(!answer_b.isEmpty()) {
			sb.append(answer_b.poll()).append(" ");
		}
		System.out.print(sb);

	}

}
