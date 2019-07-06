package com.sxt.Thread;

import java.util.concurrent.*;

/**
 * 了解创建线程的方式三：
 *
 * @author 智障过人的laoxie
 * @create 2019-06-21 9:51 星期五
 */
public class CDownloader implements Callable<Boolean>{

    //远程路径
    private String url;
    //存储名字
    private String name;

    public CDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception{
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
        System.out.println(name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownloader cd1 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561115521549&di=1dd3f54993144c422e6a7aa52159b93e&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201411%2F13%2F20141113225749_LvdY5.jpeg","路飞.jpg");
        CDownloader cd2 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561115521548&di=1b21d6aba4719aafe941ba40453306f3&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fpcdlc%2F1709%2F16%2Fc79%2F59427883_1505500626855.gif","小熊.gif");
        CDownloader cd3 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561115426784&di=5bcb709e47b4d19d6f3969dcbae77863&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201408%2F21%2F20140821212603_rUUmu.thumb.700_0.png","ic_emo_yellow.png");

        //创建执行服务
        ExecutorService ser  = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean>result1 = ser.submit(cd1);
        Future<Boolean>result2 = ser.submit(cd2);
        Future<Boolean>result3 = ser.submit(cd3);

        //获取结果
        Boolean r1 = result1.get();
        Boolean r2 = result2.get();
        Boolean r3 = result3.get();
        System.out.println(r3);
        //关闭服务
        ser.shutdownNow();

    }
}
