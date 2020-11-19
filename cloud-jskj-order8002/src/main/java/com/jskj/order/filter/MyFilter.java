package com.jskj.order.filter;



import lombok.extern.slf4j.Slf4j;
import javax.servlet.annotation.WebFilter;

import javax.servlet.*;

/**
 * @author lintao
 */
@Slf4j
@WebFilter(filterName = "MyFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName() + " init");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        System.out.println("myFilter1 begin");
        try {
            System.out.println("业务方法执行");
            chain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("error!");
        }
        System.out.println("myFilter1 end");
    }

    @Override
    public void destroy() {
    }

}
