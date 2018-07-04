package org.rocye.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyPreFilter extends ZuulFilter {
	private static Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

	public String filterType() {
		return "pre";
	}

	public int filterOrder() {
		return 0;
	}

	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.warn(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if(!"MyToken".equals(accessToken)){
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty or error !");
			} catch (Exception e) {
				ReflectionUtils.rethrowRuntimeException(e);
			}
			logger.warn("token error !");
		}else{
			logger.warn("token success !");
		}
		return null;
	}
}