package BJ_1541_잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String st=br.readLine();

		Queue<Integer> que=new LinkedList<>();
		int sum=0;
		boolean check=false;
		for(int i=0; i<st.length();i++) {
			if(st.charAt(i)=='-') {
				if(check) {
					sum-=getnum(que);
				}else {
					check=true;
					sum+=getnum(que);
					
				}
				
			}else if(st.charAt(i)=='+') {
				if(check) {
					sum-=getnum(que);
					
				}else {
					sum+=getnum(que);
					
				}
			}else {
				que.offer(st.charAt(i)-'0');
			}
		}
		
		if(check) {
			sum-=getnum(que);
		}else {
			sum+=getnum(que);
		}
		System.out.print(sum);
		

	}
	
	private static int getnum(Queue q) {
		int temp=0;
		while(!q.isEmpty()) {
			temp+=(int)Math.pow(10, q.size()-1) * (int)q.poll();
		}
		
		return temp;
	}

}
