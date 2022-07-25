package GreedyAlgorithm;

public class NQueens {

    public static int num1(int n){
        if(n<1){
            return 0;
        }
        int[] record = new int[n];  // record[i] -> i行的皇后，放在了第几列
        return process1(0, record, n);
    }

    // record[0..i-1]的皇后，任何两个皇后一定都不共行、不共列、不共斜线
    // 目前来到了第i行
    // record[0..i-1]表示之前的行，放了的皇后位置
    // n代表整体一共多少行
    // 返回值是，摆完所有的皇后，合理的摆法有多少种
    public static int process1(int i, int[] record, int n){
        if(i==n){
            return 1;
        }
        int res = 0;
        for(int j = 0; j< n; j++){ // 当前行在i行，尝试i行所有的列 -> j
            // 当前i行的皇后，放在j列，会不会和之前（0..i-1）的皇后，不共行共列或者共斜线
            // 如果是，认为有效
            // 如果不是，认为无效
            if(isValid(record, i, j)){
                record[i] = j;
                res += process1(i+1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j){
        for(int k = 0; k < i;k++){  // 之前的某个k行皇后
            if(j == record[k] || Math.abs(record[k] - j)== Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }

    public static int num2(int n){
        if(n < 1 || n > 32){
            return 0;
        }
        int limit = n ==32 ? -1 : (1 << n) - 1;
        return process2(limit , 0, 0, 0);
    }

    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim){
        if (colLim == limit){
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while(pos != 0){
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) <<1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}
