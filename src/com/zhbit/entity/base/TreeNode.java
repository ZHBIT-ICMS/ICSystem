package com.zhbit.entity.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/7
 * @Time:23:09
 * 描述：
 * EasyUI菜单树节点
 */
public class TreeNode implements Serializable {
    private String id;
    private String text;// 树节点名称
    private String iconCls;// 前面的小图标样式
    private Boolean checked = false;// 是否勾选状态
    private Map<String, Object> attributes;// 其他参数
    private List<TreeNode> children;// 子节点
    private String state = "open";// 是否展开(open,closed)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
