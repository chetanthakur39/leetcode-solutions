class Solution {
    public void rotate(int[][] matrix) {
        int row=0;
        int col =0;
        int n = matrix.length;
        int[][] mat = new int[n][n];

        for(int j = 0 ; j<n;j++){
            for(int i=n-1;i>=0;i--){
                mat[row][col] = matrix[i][j];
                 col++;
            }
            row++;
            col =0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = mat[i][j];
            }
        }

    }
}