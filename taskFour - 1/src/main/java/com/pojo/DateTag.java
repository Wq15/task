package com.pojo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *  * 用于页面 jstl时间格式化
 *  *
 *  * @Title: JSTLDateUtils.java
 *  * @Description: TODO(用一句话描述该文件做什么)
 *  * @author wangqing
 *  * @date 2019 -8- 2 下午07:28:51
 *  
 */
public class DateTag extends TagSupport {

    private static final long serialVersionUID = 6464168398214506236L;

    private Long value;

    @Override
    public int doStartTag() throws JspException {
        String vv = String.valueOf(value) ;
        long time = Long.valueOf(vv.trim());
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = dateformat.format(c.getTime());
        try {
            pageContext.getOut().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    public void setValue(Long value) {
        this.value = value;
    }

}
