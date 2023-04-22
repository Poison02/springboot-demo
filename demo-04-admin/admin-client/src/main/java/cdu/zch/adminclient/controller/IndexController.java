package cdu.zch.adminclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zch
 **/
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "This is a admin-client";
    }

}
