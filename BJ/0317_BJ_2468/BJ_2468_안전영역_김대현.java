package BJ_2468_안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int maxarea;
	static int[][] arr;
	static int n;
	static int max=0;
	static int[][] dir= {{1,0},{0,1},{-1,0},{0,-1}};

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		
		arr=new int[n][n];
		int max=0;
		for(int i=0; i< n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0; j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]>max) {
					max=arr[i][j];
				}
			}
		}
		maxarea=0;
		for(int i=1;i<max;i++) {
			area(i);
		}
		
		System.out.print(maxarea);
		
		

	}

	private static void area(int num) {
		int[][] temp=new int[n][n];
		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]>num) {
					temp[i][j]=arr[i][j];
					
				}
			}
		}
		boolean[][] check=new boolean[n][n];
		int count=0;
		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				if(temp[i][j] >0) {
					delete(temp,i,j);
					count++;
				}
			}
		}
		if(count>maxarea) {
			maxarea=count;
		}
		
	}

	private static void delete(int[][] temp, int r, int c) {
		temp[r][c]=-1;
		for(int i=0; i<4; i++) {
			int tempr=r+dir[i][0];
			int tempc=c+dir[i][1];
			if(tempr>=0 && tempr<n && tempc<n &&tempc>=0) {
				if(temp[tempr][tempc]>0) {
					delete(temp,tempr,tempc);
				}
			}
		}
		
	}

}
