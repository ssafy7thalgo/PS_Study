package BJ_1309_동물원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] arr=new int[N+1];
		
		arr[0]=1;
		arr[1]=3;
		for(int i=2;i<N+1;i++) {
			arr[i]=(arr[i-2]+arr[i-1]*2)%9901;
		}
		System.out.println(arr[N]);
		

		

	}


}
