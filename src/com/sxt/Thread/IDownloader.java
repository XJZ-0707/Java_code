package com.sxt.Thread;

/**
 * @author 智障过人的laoxie
 * @create 2019-06-21 9:51 星期五
 */
public class IDownloader implements Runnable {

    private String url;//远程路径
    private String name;//存储名字

    public IDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        IDownloader td1 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561115521549&di=1dd3f54993144c422e6a7aa52159b93e&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201411%2F13%2F20141113225749_LvdY5.jpeg","路飞.jpg");
        IDownloader td2 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561115521548&di=1b21d6aba4719aafe941ba40453306f3&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fpcdlc%2F1709%2F16%2Fc79%2F59427883_1505500626855.gif","小熊.gif");
        IDownloader td3 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561115426784&di=5bcb709e47b4d19d6f3969dcbae77863&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201408%2F21%2F20140821212603_rUUmu.thumb.700_0.png","ic_emo_yellow.png");

        //启动三个线程
        new Thread(td1).start();
        new Thread(td2).start();
        new Thread(td3).start();
    }
}
