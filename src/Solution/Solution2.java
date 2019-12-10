package Solution;

public class Solution2 {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] new_array = new int[m*n];
        int[][] trans = {{-1,1},{1,-1}};
        int raw = 0;
        int col = 0;
        int k = 0;
        for(int i=0;i<new_array.length;i++){
            new_array[i] = matrix[raw][col];
            raw += trans[k][0];
            col += trans[k][1];

            if(col > n-1){
                col = n-1;
                raw += 2;
                k = 1 - k;
            }
            if(raw > m-1){
                raw = m-1;
                col += 2;
                k = 1 - k;
            }
            if(col < 0){
                col = 0;
                k = 1 - k;
            }
            if(raw < 0){
                raw = 0;
                k = 1 - k;
            }
        }
        return new_array;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[] b = findDiagonalOrder(a);

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+",");
        }
    }
}
