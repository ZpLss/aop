package com.yhfund.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/8/29
 *         Time: 10:48
 *         Description:
 */
public class LoginWrapper extends HttpServletRequestWrapper {
    private Map<String,String[]> parameterMap;//所有参数的Map集合

    public LoginWrapper(HttpServletRequest request) {
        super(request);
        parameterMap = request.getParameterMap();
    }

    //获取指定参数名的值，如果有重复的，返回第一个
    @Override
    public String getParameter(String name) {
        String[] result = parameterMap.get(name);
        return result[0];
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return super.getParameterMap();
    }

    public void setParameterMap(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    //获取所有参数的名
    @Override
    public Enumeration<String> getParameterNames() {
        //vector 是一个容器，类似与数组，
        Vector<String> vector = new Vector<>(parameterMap.keySet());
        return vector.elements();
    }

    @Override
    public String[] getParameterValues(String name) {
        return super.getParameterValues(name);
    }
}
