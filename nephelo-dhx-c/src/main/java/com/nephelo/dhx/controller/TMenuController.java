package com.nephelo.dhx.controller;

import com.alibaba.fastjson.JSONObject;
import com.nephelo.common.controller.BaseController;
import com.nephelo.common.util.JsonUtil;
import com.nephelo.common.util.TreeUtil;
import com.nephelo.dhx.bean.TMenu;
import com.nephelo.dhx.po.TMenuTree;
import com.nephelo.dhx.service.TMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/tMenu")
public class TMenuController extends BaseController<TMenuService, TMenu,Integer> {

    /**
     * 获取完整树形结构
     * @return
     * @throws RuntimeException
     */
    @ApiOperation(value = "获取完整树形结构" )
    @RequestMapping(value = "allTree", method = RequestMethod.GET)
    public JSONObject allTree()throws Exception{
        List<TMenuTree> tMenuTreeList = new ArrayList<>();
        List<TMenu> menuList = baseServiceImpl.selectListAll();
        for(TMenu tMenu:menuList){
            TMenuTree tMenuTree = new TMenuTree();
            BeanUtils.copyProperties(tMenu,tMenuTree);
            tMenuTreeList.add(tMenuTree);
        }
        List<TMenuTree> result = TreeUtil.buildByRecursive(tMenuTreeList,-1);
        return JsonUtil.getSuccessJsonObject(result);
    }

}
