package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.util.NewValidateCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@SessionAttributes(value = "code")
@RequestMapping("/getImage")
public class getImageController {

    @RequestMapping("/getCode")
    public void getCode(HttpServletResponse response,ModelMap modelMap) throws IOException {
        NewValidateCodeUtils validateCodeUtils = new NewValidateCodeUtils();
        validateCodeUtils.write(response.getOutputStream());
        String  code= validateCodeUtils.getCode();
        modelMap.addAttribute("code", code);
    }




}
