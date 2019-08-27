package com.nephelo.user.controller;

import com.nephelo.common.controller.BaseController;
import com.nephelo.user.bean.TGroupType;
import com.nephelo.user.service.TGroupTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/tGroupType")
public class TGroupTypeController extends BaseController<TGroupTypeService, TGroupType,Integer> {

}
