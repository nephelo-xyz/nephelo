package com.nephelo.dhx.controller;

import com.alibaba.fastjson.JSONObject;
import com.nephelo.common.controller.BaseController;
import com.nephelo.common.util.JsonUtil;
import com.nephelo.dhx.bean.TDict;
import com.nephelo.dhx.service.TDictService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/tDict")
public class TDictController extends BaseController<TDictService, TDict, Integer> {

    @GetMapping(value = "/getByCode/{code}")
    public JSONObject getByCode(@PathVariable(value = "code") String code) {
        TDict tDict = new TDict();
        tDict.setCode(code);
        return JsonUtil.getSuccessJsonObject(baseServiceImpl.selectList(tDict));
    }
}
