package com.zhbit.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhbit.entity.News;
import com.zhbit.entity.Notice;
import com.zhbit.entity.PageBean;
import com.zhbit.service.NoticeService;
import com.zhbit.util.PageUtil;
import com.zhbit.util.StringUtil;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wby on 2018/5/29.
 */
public class NoticeAction extends ActionSupport implements ServletRequestAware {
    @Resource
    private NoticeService noticeService;
    private int noticeId;
    private Notice notice;
    private String page;//当前页面
    private Notice s_notice;//分页用到的对象
    private Long total;//总记录数
    private List<Notice> noticeList;
    private HttpServletRequest request;
    private String pageCode;

    public List <Notice> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List <Notice> noticeList) {
        this.noticeList = noticeList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Notice getS_notice() {
        return s_notice;
    }

    public void setS_notice(Notice s_notice) {
        this.s_notice = s_notice;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    /**
     * 前台页面分页展示
     * @return
     * @throws Exception
     */
    public String execute() throws Exception {
        if(StringUtil.isEmpty(page)){
            page="1";
        }
        PageBean pageBean=new PageBean(Integer.parseInt(page),8);
        total=noticeService.getNoticeCount(s_notice);
        noticeList=noticeService.showNoticeList(s_notice,pageBean);
        StringBuffer param=new StringBuffer();
        pageCode= PageUtil.genPagination(request.getContextPath()+"/notice.action", total, Integer.parseInt(page), 8, param.toString());
        return super.execute();
    }
    /**
     * 展现公告详情
     * @return
     */
    public String showNotice(){
        notice=noticeService.getNoticeById(noticeId);
        return "success";
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;

    }
}
