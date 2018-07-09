package com.baizhi.cmfz.controller;


import com.baizhi.cmfz.entity.Count;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/Count")
public class CountController {


    @RequestMapping("/count")
    @ResponseBody
    public List<Count> count(){

        List<Count> list = new ArrayList<Count>();
        list.add(new Count("北京", new Random().nextInt(1000)));
        list.add(new Count("天津", new Random().nextInt(1000)));
        list.add(new Count("上海", new Random().nextInt(1000)));
        list.add(new Count("重庆", new Random().nextInt(1000)));
        list.add(new Count("河北", new Random().nextInt(1000)));
        list.add(new Count("河南", new Random().nextInt(1000)));
        list.add(new Count("云南", new Random().nextInt(1000)));
        list.add(new Count("辽宁", new Random().nextInt(1000)));
        list.add(new Count("黑龙江", new Random().nextInt(1000)));
        list.add(new Count("湖南", new Random().nextInt(1000)));
        list.add(new Count("安徽", new Random().nextInt(1000)));
        list.add(new Count("山东", new Random().nextInt(1000)));
        list.add(new Count("山西", new Random().nextInt(1000)));
        list.add(new Count("新疆", new Random().nextInt(1000)));
        list.add(new Count("江苏", new Random().nextInt(1000)));
        list.add(new Count("浙江", new Random().nextInt(1000)));
        list.add(new Count("江西", new Random().nextInt(1000)));
        list.add(new Count("湖北", new Random().nextInt(1000)));
        list.add(new Count("广西", new Random().nextInt(1000)));
        list.add(new Count("广东", new Random().nextInt(1000)));
        list.add(new Count("甘肃", new Random().nextInt(1000)));
        list.add(new Count("内蒙古", new Random().nextInt(1000)));
        list.add(new Count("陕西", new Random().nextInt(1000)));
        list.add(new Count("吉林", new Random().nextInt(1000)));
        list.add(new Count("福建", new Random().nextInt(1000)));
        list.add(new Count("贵州", new Random().nextInt(1000)));
        list.add(new Count("青海", new Random().nextInt(1000)));
        list.add(new Count("西藏", new Random().nextInt(1000)));
        list.add(new Count("四川", new Random().nextInt(1000)));
        list.add(new Count("宁夏", new Random().nextInt(1000)));
        list.add(new Count("海南", new Random().nextInt(1000)));
        list.add(new Count("台湾", new Random().nextInt(1000)));
        list.add(new Count("香港", new Random().nextInt(1000)));
        list.add(new Count("澳门", new Random().nextInt(1000)));


        return list;
    }

}
