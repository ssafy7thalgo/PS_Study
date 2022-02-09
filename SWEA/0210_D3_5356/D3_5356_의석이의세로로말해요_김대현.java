package D3_5356;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class D3_5356_의석이의세로로말해요 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file=new File("input_D3_5356_의석이의세로로말해요.txt");
		Scanner sc= new Scanner(file);
		
		int t=sc.nextInt();
		for(int tc=1; tc<=t;tc++) {
			char[][] arr=new char[5][15];
			int[][] check=new int[5][15];
			for(int i=0; i<5; i++) {
				String str=sc.next();
				for(int j=0;j<str.length();j++) {
					arr[i][j]=str.charAt(j);
					check[i][j]=1;
				}
			}
			
			

			System.out.print("#"+tc+" ");
			for(int j=0; j<15;j++) {
				for(int i=0;i<5;i++) {
					if(check[i][j]==1) {
						System.out.print(arr[i][j]);
					}
				}
			}
			System.out.println();
			
		}

	}

}
