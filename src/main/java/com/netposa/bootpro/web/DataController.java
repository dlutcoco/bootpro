package com.netposa.bootpro.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netposa.bootpro.service.DataService;
import com.netposa.bootpro.utils.ConstUtil;
import com.netposa.datapro.entites.BaseResponse;

@RestController("/")
public class DataController {
    
    @Autowired
    private DataService dataService;

    @GetMapping(value = "/memory/str/random")
    public BaseResponse getRandomStrDefault() {
        return new BaseResponse().put("data", ConstUtil.randomKbStr());
    }
    
    @GetMapping("/memory/str/fix")
    public String getFixStr() {
        return ConstUtil.fixKbStr();
    }
    
    @GetMapping("/database/str")
    public String getDataBaseRandomStr() {
        return dataService.queryRandom();
    }
}
