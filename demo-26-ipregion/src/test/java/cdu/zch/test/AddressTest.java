package cdu.zch.test;

import cdu.zch.ip.entity.IpInfo;
import cdu.zch.ip.searcher.Ip2regionSearcher;
import org.junit.Test;
import org.lionsoul.ip2region.xdb.Searcher;

/**
 * @author Zch
 * @date 2023/7/27
 **/
public class AddressTest {
    Ip2regionSearcher ip2regionSearcher;

    public void setIp2regionSearcher(Ip2regionSearcher ip2regionSearcher) {
        this.ip2regionSearcher = ip2regionSearcher;
    }

    @Test
    public void testAddress(){
        IpInfo info = ip2regionSearcher.search("182.146.138.225");
        System.out.println(info);
    }

}
