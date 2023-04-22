package cdu.zch.demo02properties.controller;

import cdu.zch.demo02properties.property.ApplicationProperty;
import cdu.zch.demo02properties.property.DeveloperProperty;
import cn.hutool.core.lang.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 **/
@RestController
public class PropertyController {

    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
    public Dict index() {
        return Dict.create()
                .set("applicationProperty", applicationProperty)
                .set("developerProperty", developerProperty);
    }
}
