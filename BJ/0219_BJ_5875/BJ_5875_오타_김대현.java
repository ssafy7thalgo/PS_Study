package BJ_5875_오타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5875_오타 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();

		int count1 = 0; // (의 갯수
		int count2 = 0; // )의 갯수
		char temp;
		char[] arr = new char[st.length()];
		int answer = 0;
		boolean check = true;
		for (int i = 0; i < st.length(); i++) {
			temp = st.charAt(i);
			arr[i] = temp;
			if (temp == '(') {
				count1++;
				if (i == st.length() - 1) {
					check = false;
				}
			}
			if (temp == ')') {
				count2++;
				if (i == 0) {
					check = false;
				}
			}
		}

		if (check) {
			if (count1 > count2) {
				int op = 0;
				for (int i = st.length()-1; i >=0 ; i--) {
					if(arr[i]==')') {
						op++;
					}else {
						if(i!=0) {
							answer++;
							if(op==0) {
								break;
							}
						}
						op--;
					}

				}
			} else if (count1 < count2) {
				int op = 0;
				for (int i = 0; i < st.length(); i++) {
					if (arr[i] == '(') {
						op++;
					} else {
						if(i!=st.length()-1) {
							answer++;
							if(op==0) {
								break;
							}
						}
						
						op--;
					}

				}

			} else if (count1 == count2) {
				answer = 0;
			}

		} else {
			answer = 1;
		}
		System.out.print(answer);

	}

}
