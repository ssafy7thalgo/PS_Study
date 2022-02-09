package D3_8931;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_8931_제로 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file = new File("input_D3_8931_제로.txt");
		Scanner sc= new Scanner(file);
		
		int t= sc.nextInt();
		int sum;
		int[] arr;
		for(int tc=1; tc<=t;tc++) {
			sum=0;
			int num=sc.nextInt();
			arr=new int[num];
			for(int i=0; i<num;i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=0; i<num;i++) {
				if(arr[i]!=0) {
					sum+=arr[i];
				}else {
					for(int j=i-1;j>=0;j--) {
						if(arr[j]!=0) {
							sum-=arr[j];
							arr[j]=0;
							break;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,sum );
			
		}
		
		

	}

}
