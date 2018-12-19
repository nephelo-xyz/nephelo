package com.nephelo.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.nephelo.common.controller.BaseController;
import com.nephelo.common.util.JsonUtil;
import com.nephelo.user.bean.TElement;
import com.nephelo.user.service.TElementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/tElement")
public class TElementController extends BaseController<TElementService, TElement,Integer> {

    /**
     * 通过menuId获取元素列表
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "通过menuId获取元素列表" )
    @RequestMapping(value = "getByMenuId/{menuId}", method = RequestMethod.GET)
    public JSONObject getByMenuId(@PathVariable Integer menuId)throws Exception{
        List<TElement> result = baseServiceImpl.getListByMenuId(menuId);
        return JsonUtil.getSuccessJsonObject(result);
    }
}
