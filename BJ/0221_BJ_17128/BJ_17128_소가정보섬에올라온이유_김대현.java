package BJ_17128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		StringBuilder sb=new StringBuilder();
		int[] narr=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<n ;i++) {
			narr[i]=Integer.parseInt(st.nextToken());
		}
		int[] sarr=new int[n];
		Arrays.fill(sarr, 1);
		for(int i=0;i<n;i++) {
			for(int j=i;j<i+4;j++) {
				sarr[i]*=narr[j%n];
			}
		}
		
		int[] qarr=new int[q];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<q ;i++) {
			qarr[i]=Integer.parseInt(st.nextToken());
		}
		
		int temp=0;
		for(int j=0;j<n;j++) {
			temp+=sarr[j];
		}
		for(int i=0;i<q;i++) {
			for(int j=qarr[i]-4;j<qarr[i];j++) {
				sarr[(j+n)%n]*=-1;
				temp=temp+2*sarr[(j+n)%n];
			}
			
			sb.append(temp);
			sb.append("\n");
		}
		System.out.print(sb);
		
		
		
	}

}
