package D3_13038;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_13038_교환학생 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file= new File("input_D3_13038_교환학생.txt");
		Scanner sc= new Scanner(file);
		int t= sc.nextInt();
		
		for(int tc=1; tc<=t;tc++) {
			int n=sc.nextInt();
			int[] arr=new int[7];
			int days=0;
			for(int i=0; i<7;i++) {
				arr[i]=sc.nextInt();
				if(arr[i]==1) {
					days++;
				}
			}
			int sum=0;
			int week=n/days;
			int day=n%days;
			if(week*days==n) {
				week--;
				day=days;
			}
			int min=7;
			int count;
			for(int i=0; i<7;i++) {
				int temp=0;
				count=0;
				for(int j=0;j<7;j++) {
					int ij=i+j;
					ij=ij%7;
					temp++;
					if(arr[ij]==1) {
						count++;
						if(count==day) {
							if(temp<min) {
								min=temp;
							}
						}
					}
				}
			}
			
			sum=week*7+min;
				
		System.out.printf("#%d %d\n",tc,sum);
			
		}

	}

}
