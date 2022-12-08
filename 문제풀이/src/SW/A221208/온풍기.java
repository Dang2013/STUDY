package SW.A221208;

public class 온풍기 {

	static int max;

    public int solution(int[][] office, int k) {
        max = Integer.MIN_VALUE;

        for(int i = 0; i < office.length; i++){
            for(int j = 0; j < office.length; j++){
                    check(office, i, j, k);
            }
        }

        return max;
    }

    private static void check(int[][] office, int x, int y, int k) {
        if(x + k > office.length || y + k > office.length){
            return;
        }

        int count = 0;

        for(int i = x; i < x + k; i++){
            for(int j = y; j < y + k; j++){
                if(office[i][j] == 1){
                    count++;
                }
            }
        }

        max = Math.max(max, count);

        return;
    }
}
