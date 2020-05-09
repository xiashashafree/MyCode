package Review;

import java.util.LinkedList;
import java.util.Queue;

/***
 * 广度优先
 */
public class BFS {

        //岛屿数量
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int count = 0;//记录岛屿数量
            int ROW = grid.length;//行数
            int COL = grid[0].length;//列数

            for(int r = 0;r<ROW;r++){
                for(int c = 0;c<COL;c++){
                    if(grid[r][c] == '1'){//为1，岛屿数+1
                        count++;
                        //广度优先搜索他的周围陆地，为1将其标记为0
                        grid[r][c] = '0';
                        Queue<Integer> q = new LinkedList<>();
                        q.offer(COL*r+c);
                        while(!q.isEmpty()){
                            int num = q.poll();
                            int row = num/COL;//第几行
                            int col = num%COL;//第几列
                            if(row-1>=0 && grid[row-1][col]=='1'){
                                q.add((row-1)*COL+col);
                                grid[row-1][col] = '0';
                            }
                            if(row+1<ROW && grid[row+1][col] == '1'){
                                q.add((row+1)*COL+col);
                                grid[row+1][col] = '0';
                            }
                            if(col-1>=0 && grid[row][col-1] == '1'){
                                q.add((row)*COL+col-1);
                                grid[row][col-1] = '0';
                            }
                            if(col+1<COL && grid[row][col+1] == '1'){
                                q.add((row)*COL+col+1);
                                grid[row][col+1] = '0';
                            }

                        }
                    }


                }
            }
            return count;

        }

}
