package D4_5432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_5432_쇠막대기자르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			String str=br.readLine();
			char[] arr=new char[str.length()];
			
			for(int i=0;i<str.length();i++) {
				arr[i]=str.charAt(i);
			}
			int sum=0;
			int count=0;
			for(int i=0;i<str.length();i++) {
				if(arr[i]=='(') {
					if(arr[i+1]=='(') {
						count++;
					}else {
						sum+=count;
						i++;
						continue;
					}
				}
				if(arr[i]==')') {
					count--;
					sum++;
				}
			}
			System.out.printf("#%d %d\n",tc,sum);
			
			
		}

	}

}
