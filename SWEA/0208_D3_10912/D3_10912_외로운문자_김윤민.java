package study_Jan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class D3_10912 {
	public static void print(ArrayList<Character> list) {
		if(list.size()>0) {
			
		for (Character ch : list) {
			System.out.print(ch);
		}
		}
		else {
			System.out.print("Good");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("docs/input_D3_10912.txt"));
//		System.setIn(new FileInputStream("docs/input_D3_10912.txt"));
//		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine());
//		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			ArrayList<Character> list  =new ArrayList<Character>();
			
//			String str = sc.next();
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(list.contains(ch)) {
					list.remove(list.indexOf(ch));
				}else {
					list.add(ch);
				}
			}
			
			list.sort(Comparator.naturalOrder());
			
			System.out.printf("#%d ", test_case);
			print(list);
			
		}

	}

}
