package A0309;

import java.io.*;
import java.util.*;

public class Main_카드합체놀이_당현찬 {
	
	// 배열을 찾아 최소값 두개를 찾는 찾아 M번 반복
	// -> 다시 생각하니 애초에 정렬을 하여 첫번째 수 두번째를 찾는 것이 더 효율적일거라 생각했다.
	// -> 돌려보니 출력은 잘 나오는데 제출할 경우 실패가 떴다. 문제를 찾아보니 (카드 수 1000 * 카드의 최대 수 1000000 * M)을 하고 나면 int를 사용할 수 없다.
	// -> int를 long으로 바꾸어 출력하여 성공
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		long[] deck = new long[N];
		
		for (int i = 0; i < N; i++) {
			deck[i] = sc.nextInt();
		}
		
		// M번 합체
		for (int i = 0; i < M; i++) {
			// 카드 덱을 다시 정렬
			Arrays.sort(deck);
			// 제일 작은 두 수를 더한다.
			long sum = deck[0] + deck[1];
			// 더한 수를 제일 작은 두 수에 덮어씌운다.
			deck[0] = sum;
			deck[1] = sum;
		}
		
		long ans = 0;
		for (int i = 0; i < N; i++) {
			ans += deck[i];
		}
		
		System.out.println(ans);
	}
}
