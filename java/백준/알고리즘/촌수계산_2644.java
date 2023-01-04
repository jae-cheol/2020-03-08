package 알고리즘;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제
 *  우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 
 *  이러한 촌수는 다음과 같은 방식으로 계산된다. 
 *  기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 
 *  예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
 *  여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
 * 입력
 *  사람들은 1, 2, 3, …, n (1≤n≤100)의 연속된 번호로 각각 표시된다. 
 *  입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 
 *  그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 
 *  넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 
 *  이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
 *  각 사람의 부모는 최대 한 명만 주어진다.
 * 출력
 *  입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 
 *  어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 
 *  이때에는 -1을 출력해야 한다.
ex)
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
=>	3
 */
public class 촌수계산_2644 {
	static int n = 0;				// 전체 사람의 수
	static int m = 0;				// 부모 자식들 간의 관계의 개수
	static int[] depth;				// 두 사람의 촌수의 깊이
	static boolean[] checked;		// 체크여부
	static boolean[][] relationship;// 부모 자식간의 관계를 나타내는 두 번호
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int p1 = sc.nextInt();	// 1번째사람 : 촌수를 계산해야 하는 서로 다른 두 사람의 번호
		int p2 = sc.nextInt();	// 2번째사람 : 촌수를 계산해야 하는 서로 다른 두 사람의 번호
		m = sc.nextInt();
		
		// 초기화
		relationship = new boolean[n+1][n+1];
		checked = new boolean[n+1];
		depth = new int[n+1];
		
		// 입력 : 관계
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			relationship[x][y] = relationship[y][x] = true;
		}
		
		// 문제풀이
		bfs(p1);
		
		// 출력 : 정답
		if(depth[p2] != 0) {
			System.out.println(depth[p2]);
		} else {
			System.out.println("-1");
		}
	}
	
	public static void bfs(int x) {
		checked[x] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		int tmp;
		while(q.peek() != null) {
			tmp = q.poll();
			for(int i=1; i<=n; i++) {
				if(relationship[tmp][i] && !checked[i]) {
					checked[i] = true;
					
					// 각 번호까지의 최단거리 문제와 동일.
					depth[i] = depth[tmp] + 1;
					q.offer(i);
				}
			}
		}
	}
}
