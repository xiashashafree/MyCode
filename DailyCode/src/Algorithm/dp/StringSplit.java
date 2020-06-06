package Algorithm.dp;

import java.util.Set;

public class StringSplit {
    public boolean wordBreak(String s, Set<String> dict) {

        boolean[] dp = new boolean[s.length()];

        for(int i=0;i<s.length();i++){
            if(dict.contains(s.substring(0,i+1))){
                dp[i] = true;
                continue;
            }
            for(int j=i-1;j>=0;j--){
                if(dp[j]&&dict.contains(s.substring(j+1,i+1))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}
