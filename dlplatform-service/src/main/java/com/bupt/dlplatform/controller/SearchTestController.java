//package com.bupt.dlplatform.controller;
//
//import com.bupt.dlplatform.service.impl.SearchTestInfoServiceImpl;
//import com.bupt.dlplatform.vo.ResponseVO;
//import com.bupt.dlplatform.vo.SearchTestInputVO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class SearchTestController {
//    @Autowired
//    SearchTestInfoService searchTestInfoService;
//
//    @PostMapping("/dlplatform/serchTest")
//    public ResponseVO testRecord(@RequestBody @Validated SearchTestInputVO request){
//        return  searchTestInfoService.testRecord(request);
//
//    }
//}