package D3_3431;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_3431_준환이의운동관리 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		File file=new File("input_D3_3431_준환이의운동관리.txt");
		Scanner sc= new Scanner(file);

		int t= sc.nextInt();
		
		for(int i=1;i<=t;i++) {
			int l=sc.nextInt();
			int u=sc.nextInt();
			int x=sc.nextInt();
			int answer;
			if(x>u) {
				answer=-1;
			}else if(l<=x && x<=u) {
				answer=0;
			}else {
				answer=l-x;
			}
			System.out.println("#"+i+" "+answer);
		}
	}

}
