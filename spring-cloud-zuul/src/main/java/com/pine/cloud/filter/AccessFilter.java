package com.pine.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * ZuulFilter 抽象类
 *
 * @Component和@Bean都是用来注册Bean并装配到Spring容器中，
 * 但是Bean比Component的自定义性更强。可以实现一些Component实现不了的自定义加载类。
 * @author anzy
 * @version 1.0
 * @date 2020/4/12 15:45
 **/
//@Component
public class AccessFilter extends ZuulFilter {

    private final static Logger log = LoggerFactory.getLogger(AccessFilter.class);
    /**
     * 请求过滤类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send{} request to {}", request.getMethod(), request.getRequestURL().toString());
        Object accToken = request.getParameter("accToken");
        if (accToken == null || accToken.equals("")){
            log.warn("accToken is null");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            // 设置编码，中文会乱码
            ctx.getResponse().setContentType("application/json;charset=utf-8");
            ctx.setResponseBody("无权限");
            return null;
        }

        log.info("accToken OK!!!!!!!!!!!!!! {} ", accToken);
        return null;
    }
}
