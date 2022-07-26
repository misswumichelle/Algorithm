package BruteForceRecursion;

import java.util.List;

public class printAllSubsequence {

    public static void printAllSubsequence(String str){
        char[] chs = str.toCharArray();
        process(chs , 0);
    }

    // 当前来到i位置，要和不要，走两条路
    // 之前的选择，所形成的结果，是chs
    // 省空间的算法
    public static void process(char[] chs, int i){
        if(i == chs.length){
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1); // 要当前字符的路
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1); // 不要当前字符的路
        chs[i] = tmp;
    }

    // 当前来到i位置，要和不要，走两条路
    // res之前的选择，所形成的列表
    public static void process(char[] str, int i, List<Character> res){
        if(i == str.length){
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(str[i]);
        process(str, i+1, resKeep); // 要当前字符的路
        List<Character> resNoInclude = copyList(res);
        process(str, i + 1, resNoInclude); // 不要当前字符的路
    }

    public static void printList(List<Character> res){
       // ...;
    }

    public static List<Character> copyList(List<Character> res){
        // ...;
        return null;
    }

}
