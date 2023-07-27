package cdu.zch.ip.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Zch
 * @date 2023/7/27
 **/
@ConfigurationProperties(prefix = Ip2RegionProperties.PREFIX)
public class Ip2RegionProperties {

    public static final String PREFIX = "ip2region";

    /**
     * 是否开启自动配置
     */
    private boolean enabled = true;

    /**
     * db数据文件位置
     * <p>
     * ClassPath目录下
     * </p>
     */
    private String dbFile = "ip2region/ip2region.xdb";

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDbFile() {
        return dbFile;
    }

    public void setDbFile(String dbFile) {
        this.dbFile = dbFile;
    }

}
