package com.yhfund.filter;

import com.yhfund.wrapper.LoginWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/8/29
 *         Time: 10:45
 *         Description:
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        LoginWrapper loginWrapper = new LoginWrapper((HttpServletRequest) servletRequest);

        Map<String,String[]> parammeterMap = new HashMap<>(loginWrapper.getParameterMap());

        String[] strings = parammeterMap.get("lang");
        //如果lang为空，赋值“zh”,如果不是中文，返回异常
        if (strings == null || strings.length == 0){
            strings = new String[1];
            strings[0] = "Chinese";
        }else{
            strings[0] = "English";
        }
        parammeterMap.put("lang",strings);
        loginWrapper.setParameterMap(parammeterMap);
        filterChain.doFilter(loginWrapper,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
