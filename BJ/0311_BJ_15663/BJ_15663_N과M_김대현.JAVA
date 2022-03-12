package BJ_15663_N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<String> set;
	static boolean[] check;
	static int n,m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		set=new LinkedHashSet<>();
		
		arr=new int[n];
		check=new boolean[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] p = new int[m];
		get(0,p);
		Iterator iter =set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public static void get(int cnt,int[] p) {
		if(cnt==m) {
			StringBuilder sb= new StringBuilder();
			for(int i=0; i<m;i++) {
					sb.append(p[i]).append(" ");
			}
			set.add(sb.toString());
		}else {
			for(int i=0;i<n;i++) {
				if(check[i])
					continue;
				if(!check[i]) {
					check[i]=true;
					p[cnt]=arr[i];
					get(cnt+1,p);
					check[i]=false;
				}
			}
		}
	}

}
