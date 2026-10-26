class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r=mat.length;
        int c=mat[0].length;
        int[][] directions=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(mat[i][j]==0) q.add(new int[]{i,j});
                else mat[i][j]=Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()){
            int[] cell=q.poll();
            int row=cell[0];
            int col=cell[1];
            for(int[] dir:directions){
                int newR=row+dir[0];
                int newC=col+dir[1];
                if(newR>=0 && newR<r && newC>=0 && newC<c && mat[newR][newC] > mat[row][col]+1){
                    mat[newR][newC]=mat[row][col]+1;
                    q.add(new int[]{newR,newC});
                }
            }
        }
        return mat;
    }
}