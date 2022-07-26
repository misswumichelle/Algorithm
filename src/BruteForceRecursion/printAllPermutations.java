package BruteForceRecursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class printAllPermutations {

    public static ArrayList<String> Permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0 ,res);
        res.sort(null);
        return res;
    }


    // chs[i..]范围上，所有的字符，都可以在i位置上，后续都去尝试
    // chs[0..i-1]范围上，是之前做的选择
    // 请把所有的字符串形成的全排列，加入到res里去
    public static void process(char[] chs, int i, ArrayList<String> res){
        if(i == chs.length){
            res.add(String.valueOf(chs));
        }
        boolean[] visit = new boolean[26];
        for(int j=i; j < chs.length; j++){
            if(!visit[chs[j] - 'a']){
                visit[chs[j] - 'a'] = true;
                swap(chs, i ,j);
                process(chs, i+1, res);
                swap(chs, i, j);
            }

        }
    }

    public static void swap(char[] chs, int i, int j){
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
