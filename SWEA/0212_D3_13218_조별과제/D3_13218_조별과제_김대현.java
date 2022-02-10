package D3_13218;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class D3_13218_조별과제 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file=new File("input_D3_13218_조별과제.txt");
		Scanner sc= new Scanner(file);
		int t=sc.nextInt();
		for(int tc=1; tc<=t;tc++) {
			System.out.printf("#%d %d\n", tc,sc.nextInt()/3);
		}

	}

}
