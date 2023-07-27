package cdu.zch.test;

import org.apache.commons.io.FileUtils;
import org.lionsoul.ip2region.xdb.Searcher;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Zch
 * @date 2023/7/27
 **/
public class AddressUtil {

    public static void main(String[] args) throws IOException {
        String dbPath = "D:\\笔记\\spring-boot-demo\\spring-boot-demo\\demo-26-ipregion\\src\\test\\resources\\ip2region\\ip2region.xdb";

        // 1、从 dbPath 加载整个 xdb 到内存。
        byte[] cBuff;
        try {
            cBuff = Searcher.loadContentFromFile(dbPath);
        } catch (Exception e) {
            System.out.printf("failed to load content from `%s`: %s\n", dbPath, e);
            return;
        }

        // 2、使用上述的 cBuff 创建一个完全基于内存的查询对象。
        Searcher searcher;
        try {
            searcher = Searcher.newWithBuffer(cBuff);
        } catch (Exception e) {
            System.out.printf("failed to create content cached searcher: %s\n", e);
            return;
        }

        // 3、查询
        String ip = "1.2.3.4";
        try {
            long sTime = System.nanoTime();
            String region = searcher.search(ip);
            long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
            System.out.printf("{region: %s, ioCount: %d, took: %d μs}\n", region, searcher.getIOCount(), cost);
        } catch (Exception e) {
            System.out.printf("failed to search(%s): %s\n", ip, e);
        } finally {
            // 4、关闭资源 - 该 searcher 对象可以安全用于并发，等整个服务关闭的时候再关闭 searcher
            searcher.close();
        }


    }

}
