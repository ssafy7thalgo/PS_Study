package BJ_2293_동전1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int count=0;
	static int[] arr;
	static int[] amount;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		arr=new int[n];
		amount=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] dp=new int[m+1];
		for(int i=0;i<n;i++) {
			int value=arr[i];
			
			if(value > m)
				continue;
			
			dp[value]++;
			
			for(int j= value; j<=m; j++) {
				dp[j]=dp[j]+dp[j-value];
				count++;
			}
			
		}
		
//		get(m,n-1);
		StringBuilder sb=new StringBuilder();
//		sb.append(count);
		sb.append(dp[m]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		System.out.println(count);

	}
	
	private static void get(int money, int num) {
	
		
		if(money==0) {
			count++;
		}else if(num==-1){
			return;
		}else {
			for(int i=money/arr[num];i>=0;i--) {
				amount[num]=i;
				get(money-i*arr[num],num-1); 
			}
		}
	}

}
