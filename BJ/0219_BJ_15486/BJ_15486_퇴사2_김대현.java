package BJ_15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15486_퇴사2 {
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[n+2][2];
		int[] maxs= new int[n+2];
		
		for(int i=1; i<n+1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		int max=0;
		int nextI;
		for(int i=1; i<=n+1;i++) {
			max=Math.max(max, maxs[i]);
			
			nextI=arr[i][0] + i;
			if(nextI <=n+1) {
				maxs[nextI] = Math.max(maxs[nextI], max+arr[i][1]);
			}
			
		}
		
		System.out.print(max);
		
	
	}


	


}
