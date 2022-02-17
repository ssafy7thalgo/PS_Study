package BJ_13305_주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305_주유소 {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] distance=new int[n-1];
		int[] price=new int[n];
		
		for(int i=0;i<n-1;i++) {
			distance[i]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			price[i]=Integer.parseInt(st.nextToken());
		}
		
		long sum=0;
		long min=price[0];
		for(int i=0; i<n-1;i++) {
			if(price[i]<min) {
				min=price[i];
			}
			sum+=(min*distance[i]);
		}
		
		System.out.print(sum);

	}

}
