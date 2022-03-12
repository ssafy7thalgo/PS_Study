package BJ_1938_통나무옮기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;




public class Main {
	public static class point {
		int r,c,rc,cnt; // rc==0 => 세로 rc==1 => 가로
		
		public point(int r,int c,int rc,int cnt) {
			this.r=r;
			this.c=c;
			this.rc=rc;
			this.cnt=cnt;
		}
		
	
		
		public point(point p,int rc,int cnt) {
			this.r=p.r;
			this.c=p.c;
			this.rc=rc;
			this.cnt=cnt;
			
		}
		
		public point(int r, int c, int rc) {
			this.r=r;
			this.c=c;
			this.rc=rc;
		}
	}
	
	static char[][] arr;
	static int n;
	static boolean[][][] visit;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new char[n][n];
		visit=new boolean[n][n][2];
		int countb=0;
		int counte=0;
		int[][] b=new int[3][2];
		int[][] e=new int[3][2];
		for(int i=0; i<n;i++) {
			String str=br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j]=str.charAt(j);
				if(arr[i][j]=='B') {
					b[countb][0]=i;
					b[countb][1]=j;
					countb++;
					
				}
				if(arr[i][j]=='E') {
					e[counte][0]=i;
					e[counte][1]=j;
					counte++;
				
				}
				
				
			}
		}
		int b_r=0;
		int b_c=0;
		int e_r=0;
		int e_c=0;
		
		for(int i=0;i<3;i++) {
				b_r=b_r+b[i][0];
				b_c=b_c+b[i][1];
				e_r=e_r+e[i][0];
				e_c=e_c+e[i][1];
		}
		b_r=b_r/3;
		b_c=b_c/3;
		e_r=e_r/3;
		e_c=e_c/3;
		int brc=0;
		int erc=0;
		if(b_r!=b[0][0]) {
			brc=0;
		}else {
			brc=1;
		}
		if(e_r!=e[0][0]) {
			erc=0;
		}else {
			erc=1;
		}
		
		point ep=new point(e_r,e_c,erc);
		go(b_r,b_c,brc,ep);
		
		
		
		

	}
	
	
	
	
	
	public static void go(int r,int c, int brc,point ep) {
		Queue<point> que=new LinkedList<>();
		
		que.add(new point(r,c,brc,0));
		visit[r][c][brc]=true;
		boolean check=false;
		while(!que.isEmpty()) {
			if(check(que.peek(),ep)) {
				System.out.print(que.peek().cnt);
				check=true;
				break;
			}
			
			if(up(que.peek()) && !visit[que.peek().r-1][que.peek().c][que.peek().rc]) {
				que.add(new point(que.peek().r-1,que.peek().c,que.peek().rc,que.peek().cnt+1));
				visit[que.peek().r-1][que.peek().c][que.peek().rc]=true;
			}
			
			if(down(que.peek())&& !visit[que.peek().r+1][que.peek().c][que.peek().rc]) {
				que.add(new point(que.peek().r+1,que.peek().c,que.peek().rc,que.peek().cnt+1));
				visit[que.peek().r+1][que.peek().c][que.peek().rc]=true;
			}
			
			if(left(que.peek()) && !visit[que.peek().r][que.peek().c-1][que.peek().rc]) {
				que.add(new point(que.peek().r,que.peek().c-1,que.peek().rc,que.peek().cnt+1));
				visit[que.peek().r][que.peek().c-1][que.peek().rc]=true;
			}
			
			if(right(que.peek()) && !visit[que.peek().r][que.peek().c+1][que.peek().rc]) {
				que.add(new point(que.peek().r,que.peek().c+1,que.peek().rc,que.peek().cnt+1));
				visit[que.peek().r][que.peek().c+1][que.peek().rc]=true;
			}
			
			if(turn(que.peek()) && !visit[que.peek().r][que.peek().c][(que.peek().rc+1)%2]) {
				que.add(new point(que.peek().r,que.peek().c,(que.peek().rc+1)%2,que.peek().cnt+1));
				visit[que.peek().r][que.peek().c][(que.peek().rc+1)%2]=true;
			}

			que.poll();
			
			
		}
		if(!check) {
			System.out.print(0);	
		}
		
	}
	
	
	private static boolean turn(point peek) {
		
		for(int i=-1;i<=1;i++) {
			for(int j=-1;j<=1;j++) {
				int tempr=peek.r+i;
				int tempc=peek.c+j;
				if(tempr<0 || tempr>=n || tempc<0 || tempc>=n) {
					return false;
				}
				
				if(arr[tempr][tempc]=='1') {
					return false;
				}
				
			}
		}
		
		return true;
	}





	private static boolean right(point peek) {

			if(peek.rc==0) { //세로
				if(peek.c+1<n) {
					if(arr[peek.r-1][peek.c+1]=='1') {
						return false;
					}
					if(arr[peek.r][peek.c+1]=='1') {
						return false;
					}
					if(arr[peek.r+1][peek.c+1]=='1') {
						return false;
					}
					return true;
					
				}
			}else if(peek.rc==1) { // 가로
				if(peek.c+2<n) {
					if(arr[peek.r][peek.c+2]!='1') {
						return true;
					}
					
				}
			}
		
		
		return false;
	}





	private static boolean left(point peek) {
		
			if(peek.rc==0) { //세로
				if(peek.c-1>=0) {
					if(arr[peek.r-1][peek.c-1]=='1') {
						return false;
					}
					if(arr[peek.r][peek.c-1]=='1') {
						return false;
					}
					if(arr[peek.r+1][peek.c-1]=='1') {
						return false;
					}
					return true;
					
				}
			}else if(peek.rc==1) { // 가로
				if(peek.c-2>=0) {
					if(arr[peek.r][peek.c-2]!='1') {
						return true;
					}
					
				}
			}
		
		
		return false;
	}





	private static boolean down(point p) {
		
		if(p.rc==0) { //세로
			if(p.r+2 < n && arr[p.r+2][p.c]!='1') {
				return true;
			}
		}else if (p.rc==1) { // 가로
			if(p.r+1<n) {
				if(arr[p.r+1][p.c]=='1') {
					return false;
				}
				if(arr[p.r+1][p.c-1]=='1') {
					return false;
				}
				if(arr[p.r+1][p.c+1]=='1') {
					return false;
				}
				return true;
			}
		}
		
		return false;
	}





	private static boolean up(point p) {
		
		if(p.rc==0) { //세로
			if(p.r-2>= 0 && arr[p.r-2][p.c]!='1') {
				return true;
			}
		}else if (p.rc==1) { // 가로
			if(p.r-1>=0) {
				if(arr[p.r-1][p.c]=='1') {
					return false;
				}
				if(arr[p.r-1][p.c-1]=='1') {
					return false;
				}
				if(arr[p.r-1][p.c+1]=='1') {
					return false;
				}
				return true;
			}
		}
		
		return false;
	}
	





	public static boolean check(point bp,point ep) {
		
		if(bp.r==ep.r && bp.c==ep.c && bp.rc== ep.rc) {
			return true;
		}

			
		return false;
	}

}
