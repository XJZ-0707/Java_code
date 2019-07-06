package 尚学堂java.冒泡排序;

import java.util.Arrays;

/**
 * @author 智障过人的laoxie
 * @create 2019-03-03 11:05 星期日
 * 冒泡排序及优化
 */
public class TestBubbleSort {
    public static void main(String[] args) {

        int[] values = {3,2,7,5,8,9,1,4,6,0};
        int temp = 0;
        for(int i=0;i<values.length-1;i++){
            boolean flag = true;
            for(int j=0;j<values.length-1-i;j++){
                if(values[j]>values[j+1]){
                    temp = values[j];
                    values[j]=values[j+1];
                    values[j+1]=temp;
                    flag = false;
                }
                System.out.println(Arrays.toString(values));
            }
            if(flag){
                System.out.println("结束！");
                break;
            }
            System.out.println("************");
        }
    }
}
