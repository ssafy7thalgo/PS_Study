package D3_10912;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_10912_외로운문자 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("input_D3_10912_외로운문자.txt");
		Scanner sc= new Scanner(file);
		
		int t= sc.nextInt();
		int count;
		for(int tc=1; tc<=t;tc++) {
			count=0;
			int[] arr=new int[26];
			String str=sc.next();
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<str.length();i++) {
				int n= str.charAt(i)-'a';
				arr[n]++;
			}
			for(int i=0; i<26;i++) {
				if(arr[i]%2==1) {
					sb.append((char)(i+'a'));
					count++;
				}
			}
			if(count==0) {
				System.out.printf("#%d Good\n",tc);
			}else {
				System.out.printf("#%d %s\n",tc,sb);
				
			}
			
			
		}

	}

}
