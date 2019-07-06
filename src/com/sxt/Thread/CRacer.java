package com.sxt.Thread;

import java.util.concurrent.*;

/**
 * @author 智障过人的laoxie
 * @create 2019-06-21 22:08 星期五
 *
 * 模拟龟兔赛跑
 */
public class CRacer implements Callable<Integer> {
    //胜利者
    private static String winner;

    @Override
    public Integer call() throws Exception {
        for (int steps=1;steps<=100;steps++){
            //模拟休息
            if (Thread.currentThread().getName().equals("rabbit")&&steps%10==0) {
                Thread.sleep(100);
            }

            System.out.println(Thread.currentThread().getName() + "-->" +steps);
                //比赛是否结束
                boolean flag = gameOver(steps);
            if (flag){
                return steps;
            }
        }
        return null;
    }
    private boolean gameOver(int steps){
        //存在胜利者
        if (winner !=null){
            return true;
        }
        else{
            if (steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("winner==>"+winner);
                return true;
            }
        }
          return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer racer = new CRacer();
        //创建执行服务
        ExecutorService ser  = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Integer> result1 = ser.submit(racer);
        Future<Integer> result2 = ser.submit(racer);

        //获取结果
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r1 +"-->"+r2);
        //关闭服务
        ser.shutdownNow();
    }


}
