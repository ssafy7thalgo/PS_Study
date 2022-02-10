package D3_12004;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_12004_구구단1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file=new File("input_D3_12004_구구단1.txt");
		Scanner sc= new Scanner(file);
		int t=sc.nextInt();
		for(int tc=1; tc<=t;tc++) {
			
			int n=sc.nextInt();
			String str="No";
			for(int i=9;i>0;i--) {
				if(n%i==0) {
					if(n/i<10&&n/i>0) {
							str="Yes";
							break;
					}
				}
			}
			
			System.out.printf("#%d %s\n",tc,str );
		}

	}
	
}
