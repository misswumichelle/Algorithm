package BruteForceRecursion;

public class ConvertToLetterString {
    public static int process(char[] str, int i){
        if(i == str.length){
            return 1;
        }
        if(str[i] == '0'){
            return 0;
        }
        if(str[i] == '1'){
            int res = process(str, i + 1); // i自己作为单独的部分，后续有多少种方法
            if(i + 1 <str.length){
                res += process(str, i + 2); // (i和i+1)作为单独的部分，后续有多少种方法
            }
            return res;
        }
        if(str[i] == '2'){
            int res = process(str, i + 1); // i自己作为单独的部分，后续有多少种方法
            // (i和i+1)作为单独的部分并且没有超过26，后续有多少种方法
            if(i + 1 < str.length && (str[i+1] >= '0') && (str[i+1] <= '6') ){
                res += process(str, i + 2);
            }
            return res;
        }
        // str[i] == '3' ~ '9'
        return process(str, i + 1);
    }
}
