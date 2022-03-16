package study_mar;

import java.util.*;
import java.io.*;

public class BJ_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		List<String> e = new ArrayList<>();
		int idx =0;
		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
				e.add(exp.substring(idx, i));
				e.add(Character.toString(exp.charAt(i)));
				idx = i+1;
			}
		}e.add(exp.substring(idx, exp.length()));
		
		for (int i = 0; i < e.size(); i++) {
			if(e.get(i).equals("+")) {
				int g = i-1;
				int b = Integer.parseInt(e.remove(i+1));
				e.remove(i);
				int a = Integer.parseInt(e.remove(i-1));
				e.add(g, Integer.toString(a+b));
				i= g;
			}
		}
		for (int i = 0; i < e.size(); i++) {
			if(e.get(i).equals("-")) {
				int g = i-1;
				int b = Integer.parseInt(e.remove(i+1));
				e.remove(i);
				int a = Integer.parseInt(e.remove(i-1));
				e.add(g, Integer.toString(a-b));
				i= g;
			}
		}
		
		
		System.out.println(e.get(0));
	
	}
}
