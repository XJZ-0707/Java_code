package com.sxt.Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 智障过人的laoxie
 * @create 2019-06-21 9:35 星期五
 */
public class WebDownloader {
    /*
    * 下载图片
    * */
    public void download(String url ,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("不合法的URL");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");

        }
    }
}
