package kr.co.springbootwasbase.config.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FaviconConfig {
    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }
}
