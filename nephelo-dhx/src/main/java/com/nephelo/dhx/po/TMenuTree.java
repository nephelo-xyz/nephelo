package com.nephelo.dhx.po;

import com.nephelo.common.vo.TreeNode;
import lombok.Data;

import java.util.Date;

/**
 * Created by nephelo on 2018/12/21.
 */
@Data
public class TMenuTree extends TreeNode {
    private String code;

    private String title;

    private String href;

    private String icon;

    private Integer orderNum;

    private String path;

    private String enabled;

    private Date createTime;

    private Date updateTime;
}
