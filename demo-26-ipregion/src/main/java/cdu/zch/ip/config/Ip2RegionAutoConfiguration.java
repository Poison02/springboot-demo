package cdu.zch.ip.config;

import cdu.zch.ip.searcher.Ip2regionSearcher;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ClassLoaderUtil;
import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Zch
 * @date 2023/7/27
 **/
@AutoConfiguration
@ConditionalOnClass(Ip2regionSearcher.class)
@EnableConfigurationProperties(Ip2RegionProperties.class)
@ConditionalOnProperty(prefix = Ip2RegionProperties.PREFIX, name = "enabled", havingValue = "true")
public class Ip2RegionAutoConfiguration {

    @Bean
    public Ip2regionSearcher ip2regionSearcher(@Autowired Ip2RegionProperties ip2RegionProperties) {
        ClassLoader classLoader = ClassLoaderUtil.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(ip2RegionProperties.getDbFile())) {
            Searcher searcher = Searcher.newWithBuffer(IoUtil.readBytes(inputStream));
            return new Ip2regionSearcher(searcher);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}