class Solution {
    public int[][] diagonalSort(int[][] mat) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = mat.length -1; i >= 0; i--){
            recurseDiag(mat, i, 0, pq);
            insertDiag(mat, i, 0, pq);
        }
        for(int j = 1; j < mat[0].length; j++){
            recurseDiag(mat, 0, j, pq);
            insertDiag(mat, 0, j, pq);
        }
        return mat;
    }


    public void recurseDiag(int[][] mat, int i, int j, PriorityQueue<Integer> pq){
        pq.offer(mat[i][j]);
        while(i+1 >= 0 && i+1 < mat.length && j+1 >= 0 && j+1 < mat[0].length){
            i=i+1;
            j=j+1;
            pq.offer(mat[i][j]);
        }
    }

    public void insertDiag(int[][] mat, int i, int j, PriorityQueue<Integer> pq){
        mat[i][j] = pq.poll();
        while(i+1 >= 0 && i+1 < mat.length && j+1 >= 0 && j+1 < mat[0].length){
            i=i+1;
            j=j+1;
            mat[i][j] = pq.poll();
        }
    }
}