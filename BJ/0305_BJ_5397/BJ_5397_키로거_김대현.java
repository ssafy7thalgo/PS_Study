package BJ_5397_키로거;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t=Integer.parseInt(br.readLine());
		int point;
		char c;
		LinkedList<Character> ll;
		
		for(int tc=0;tc<t;tc++) {
			String str=br.readLine();
			ll=new LinkedList<Character>();
			point=0;
			for(int i=0;i<str.length();i++) {
				c= str.charAt(i);
				
				switch(c) {
				case '<':
					if(point>0) {
						point--;
					}
					break;
				case '>':
					if(point<ll.size()) {
						point++;
					}
					break;
				case '-':
					if(!ll.isEmpty() && point!=0) {
						ll.remove(point-1);
						point--;
					}
					break;
				default:
					ll.add(point++, c);
					break;
						
				}
			}
			

			
			
			while(!ll.isEmpty()) {
				bw.write(ll.pop());
			}
			bw.newLine();
			
		}
		

		bw.flush();
		bw.close();
	}

}
