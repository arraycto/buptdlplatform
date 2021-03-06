package com.bupt.dlplatform.consumer;


import com.bupt.dlplatform.vo.ResponseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-producer-dlplatform")
public interface TestConsumer {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    ResponseVO test() ;

}
