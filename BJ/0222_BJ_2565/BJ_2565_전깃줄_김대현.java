package BJ_2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int[][] narr=new int[n][2];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			narr[i][0]=Integer.parseInt(st.nextToken());
			narr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(narr,new Comparator<int[]>() { // 왼쪽 기둥 기준으로 오름차순 정렬

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]==o2[0]) return o1[0]-o2[1];
				else return o1[0]-o2[0];
			
			}
		});
		int max=0;
		int lis[]=new int[n];
		for(int i=0;i<n;i++) {
			lis[i]=1;//혼자 끝나면 1
			for(int j=0;j<i;j++) { // 그 앞쪽까지 비교하면서
				//앞쪽이 더 작은 숫자고 최장문자열 길이가 더 짧으면 , 	// 1 3 5 4 2 
													// 1 0 0 0 0
													// 1 2 0 0 0
													// 1 2 3 0 0
													// 1 2 3 3 0
													// 1 2 3 3 2
					// &&은 뒷부분을 비교하기 위함
				if(narr[j][1] < narr[i][1] && lis[i]<lis[j]+1) {
					lis[i]=lis[j]+1;
					
				}
			}
			max=Math.max(max, lis[i]);
			
		}
		System.out.print(n-max);

	}

}
