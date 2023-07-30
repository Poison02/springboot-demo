package cdu.zch.provider;

import cdu.zch.common.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author Zch
 * @date 2023/7/30
 **/
@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
