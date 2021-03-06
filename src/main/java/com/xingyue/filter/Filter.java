package com.xingyue.filter;

import com.xingyue.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hgl
 * 功能：拦截器
 * 时间：2020年4月8日23:19:11
 */
@WebFilter(filterName = "Filter", urlPatterns = "/*")
@Component
public class Filter implements javax.servlet.Filter {
    @Override
    public void destroy() {
    }

    /**
     * 拦截页面
     *
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        User user =(User) req.getSession().getAttribute("xingyue");
        String requestURI = req.getRequestURI();
        if (StringUtils.isEmpty(user)) {
            if("/html/login.html".equals(requestURI)
                    ||requestURI.contains(".js")
                    ||requestURI.contains(".css")
                    ||requestURI.contains(".jpg")
                    ||requestURI.contains(".png")
                    ||requestURI.contains(".mp4")
                    ||requestURI.contains(".gif")
                    ||requestURI.contains("/api")
                    ||"/about.html".equals(requestURI)
                    ||"/contact.html".equals(requestURI)
                    ||"/index.html".equals(requestURI)
                    ||"/jishu.html".equals(requestURI)
                    ||"/news.html".equals(requestURI)
                    ||"/news-con.html".equals(requestURI)
                    ||"/pro-con.html".equals(requestURI)
                    ||"/pro-shili.html".equals(requestURI)
                    ||"/en/about.html".equals(requestURI)
                    ||"/en/contact.html".equals(requestURI)
                    ||"/en/index.html".equals(requestURI)
                    ||"/en/jishu.html".equals(requestURI)
                    ||"/en/news.html".equals(requestURI)
                    ||"/en/news-con.html".equals(requestURI)
                    ||"/en/pro-con.html".equals(requestURI)
                    ||"/en/pro-shili.html".equals(requestURI)
                    ||"/".equals(requestURI)
//                    ||requestURI.contains("swagger")
                    ){
                chain.doFilter(request, response);
                return;
            }else{
                //登录页面
                resp.sendRedirect("/html/login.html");
                return;
            }

        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
