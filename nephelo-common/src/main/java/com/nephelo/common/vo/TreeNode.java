package com.nephelo.common.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nephelo on 2018/12/21.
 */
@Data
public class TreeNode {
    protected int id;
    protected int parentId;
    List<TreeNode> children = new ArrayList<TreeNode>();
    public void add(TreeNode node){
        children.add(node);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
