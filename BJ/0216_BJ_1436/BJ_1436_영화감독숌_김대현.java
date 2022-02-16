package BJ_1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1436_영화감독숌 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int temp;
		int count=0;
		for(int i=666;;i++) {
			temp=i;
			while(temp>665) {
				if(temp%1000==666) {
					count++;
					break;
				}
				temp=temp/10;
				
			}
			
			if(count==n) {
				n=i;
				break;
			}
			
		}
		System.out.print(n);
		

	}

}
