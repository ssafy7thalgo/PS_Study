package study_Jan;

import java.util.*;

public class BJ_2606_바이러스 {
	public static List<List<Integer>> list;
	public static boolean[] isChecked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); //컴퓨터 개수
		int nw = sc.nextInt(); //컴퓨터 쌍

		list = new ArrayList<>(); 
		isChecked = new boolean[N+1]; //탐색했는지 체크하는 배열

		//컴퓨터 개수만큼 list 초기화
		//각 arraylist에는 자신과 근접한 컴퓨터의 번호가 저장됨
		for (int i = 0; i < N+1; i++) {
			List<Integer> li = new ArrayList<Integer>();
			list.add(li);
		}
		
		for (int i = 0; i < nw; i++) {
			int com1 = sc.nextInt(); //컴퓨터 1
			int com2 = sc.nextInt(); //컴퓨터 2
			list.get(com1).add(com2); //각 인덱스에 있는 arraylist에 다른 컴퓨터를 추가해줌
			list.get(com2).add(com1);
		}

		dfs(1); //탐색 시작
		
		int cnt = 0;
		//탐색이 끝난 후 체크된 컴퓨터 개수 세기
		for (int i = 0; i < N+1; i++) {
			System.out.print(isChecked[i]+" ");
			if (isChecked[i] == true)
				cnt++;
		}
		
		System.out.println(cnt-1); //1번 컴퓨터로부터 감염된 컴퓨터 개수이므로 1번 컴퓨터는 포함하지 않기위해 -1 을 해줌
	}

	private static void dfs(int num) {
		List<Integer> li = list.get(num); //탐색 중인 컴퓨터의 arraylist 가져오기
		//자신과 인접한 컴퓨터 탐색하기
		for (int i = 0; i < li.size(); i++) {
			if (isChecked[li.get(i)] == true) //이미 탐색한 컴퓨터면 continue
				continue;
			isChecked[li.get(i)] = true; //탐색했으므로 true 로 변경
			dfs(li.get(i)); //감염되었으므로 주변 컴퓨터를 감염하기 위해 재귀 호출
		}

	}
}
