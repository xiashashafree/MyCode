package Algorithm.DFS;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class nQueen {

        private void dfs(List<List<Pair<Integer,Integer>>> solutions,List<Pair<Integer,Integer>> solution,int curRow,int n){
            if(curRow == n){//四行都有皇后了
                List<Pair<Integer,Integer>> news = new ArrayList<>();
                for(Pair<Integer,Integer> p:solution){
                    news.add(p);
                }
                solutions.add(news);
                return;
            }
            for(int i=0;i<n;i++){
                if(isVaild(solution,curRow,i)){
                    solution.add(new Pair<>(curRow,i));
                    dfs(solutions,solution,curRow+1,n);
                    solution.remove(solution.size()-1);
                }

            }

        }
        //判断在此位置放皇后 （是否会有同列或同对角线的皇后在）
        private boolean isVaild(List<Pair<Integer,Integer>> solution,int curRow,int i){
            for(Pair<Integer,Integer> pair:solution){
                int row = pair.getKey();
                int col = pair.getValue();
                if(col == i || col+row == curRow+i || row - col == curRow - i){
                    return false;
                }
            }
            return true;
        }
        private List<List<String>> translate(List<List<Pair<Integer,Integer>>> solutions,int n){
            List<List<String>> ret = new ArrayList<>();
            for(List<Pair<Integer,Integer>> solution:solutions){
                List<StringBuilder> list = new ArrayList<>();

                for(int i=0;i<n;i++){
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0;j<n;j++){
                        sb.append(".");//先将每行初始化为.
                    }
                    list.add(sb);

                }


                for(Pair<Integer,Integer> pair:solution){
                    list.get(pair.getKey()).setCharAt(pair.getValue(),'Q');
                }
                List<String> l = new ArrayList<>();
                for(StringBuilder s:list){
                    l.add(s.toString());
                }
                ret.add(l);
            }
            return ret;
        }
        public List<List<String>> solveNQueens(int n) {
            List<List<Pair<Integer,Integer>>> solutions = new ArrayList<>();
            List<Pair<Integer,Integer>> solution = new ArrayList<>();
            dfs(solutions,solution,0,n);
            return translate(solutions,n);

        }

}
