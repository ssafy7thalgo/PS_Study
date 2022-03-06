package BJ_2156_포도주시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	

	public static void main(String[] args) throws  IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		if(n==1) {
			System.out.println(arr[0]);
		}else {
			int[][] answer=new int[n][3];
			answer[0][0]=0;
			answer[0][1]=arr[0];
			answer[0][2]=arr[0];
			answer[1][0]=arr[0];
			answer[1][1]=arr[1];
			answer[1][2]=arr[0]+arr[1];
			
			for(int i=2;i<n;i++) {
				answer[i][0]=Math.max(answer[i-1][2], Math.max(answer[i-1][0], answer[i-1][1]));
				answer[i][1]=answer[i-1][0]+arr[i];
				answer[i][2]=answer[i-1][1]+arr[i];
			}
			
			System.out.println(Math.max(answer[n-1][0], Math.max(answer[n-1][1], answer[n-1][2])));
			
		}
		

	}

}
