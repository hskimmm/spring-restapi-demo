package com.spring.restapi.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
    @GetMapping(value = {"/", "/list"})
    public String list() {
        return "/board/list";
    }
}
