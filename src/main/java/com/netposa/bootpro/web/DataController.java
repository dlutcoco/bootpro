package com.netposa.bootpro.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netposa.bootpro.entites.BaseResponse;
import com.netposa.bootpro.service.DataService;
import com.netposa.bootpro.utils.ConstUtil;

@RestController("/")
public class DataController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DataController.class);
    
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
    
    @GetMapping("/thread")
    public String threadTest() {
    	LOG.info("thread:" + Thread.currentThread().getName());
    	
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return dataService.queryRandom();
    }
}
