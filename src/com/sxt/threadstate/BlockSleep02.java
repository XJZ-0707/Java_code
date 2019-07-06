package com.sxt.threadstate;

/**
 * sleep模拟休息
 *
 * @author 智障过人的laoxie
 * @create 2019-06-22 15:47 星期六
 */
public class BlockSleep02 {
    public static void main(String[] args) {
        com.sxt.Thread.Racer racer = new com.sxt.Thread.Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();

    }
}

class Racer implements Runnable {
    //胜利者
    private static String winner;

    @Override
    public void run() {
        for (int steps=1;steps<=100;steps++){
            //模拟休息
            if (Thread.currentThread().getName().equals("rabbit")&&steps%10==0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "-->" +steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if (flag){
                break;
            }
        }
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


}
