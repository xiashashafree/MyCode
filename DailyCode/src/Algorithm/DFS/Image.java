package Algorithm.DFS;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Image {

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int old = image[sr][sc];
            image[sr][sc] = newColor;
            int row = image.length;
            int col = image[0].length;
            int[][] flag = new int[row][col];
            flag[sr][sc] = 1;
            int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
            Queue<Pair<Integer,Integer>> q = new LinkedList<>();
            q.offer(new Pair(sr,sc));
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    Pair<Integer,Integer> cur = q.poll();
                    int x = cur.getKey();
                    int y = cur.getValue();
                    for(int j=0;j<dir.length;j++){
                        int xx = x+dir[j][0];
                        int yy = y+dir[j][1];
                        if(xx >=0 && xx<row && yy>=0 && yy<col && image[xx][yy] == old && flag[xx][yy] == 0){
                            image[xx][yy] = newColor;
                            flag[xx][yy] = 1;
                            q.offer(new Pair(xx,yy));
                        }
                    }
                }
            }
            return image;

        }

}
