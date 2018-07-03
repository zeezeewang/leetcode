package algorithm.sort;

public class DynamicPlanning {

    private int findDynamic(String A, String B) {
        int n = A.length();
        int m = B.length();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] sub = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (a[i] == b[0]) {
                sub[i][0] = 1;
                for (int j = i + 1; j < n; j++) {
                    sub[j][0] = 1;
                }
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (a[0] == b[i]) {
                sub[0][i] = 1;
                for (int j = i + 1; j < m; j++) {
                    sub[0][j] = 1;
                }
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i] == b[j]) {
                    sub[i][j] = sub[i - 1][j - 1] + 1;
                }else {
                    sub[i][j] = Math.max(sub[i - 1][j], sub[i][j - 1]);
                }
            }
        }
        return sub[n - 1][m - 1];
    }

    public  static void main(String[] args){
        DynamicPlanning dynamicPlanning = new DynamicPlanning();
        int result = dynamicPlanning.findDynamic("android" , "random");
        System.out.println(result);
    }
}
