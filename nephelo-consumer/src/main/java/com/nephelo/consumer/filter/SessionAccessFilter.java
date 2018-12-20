package com.nephelo.consumer.filter;

import com.nephelo.api.vo.authority.PermissionInfo;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class SessionAccessFilter extends ZuulFilter {
	private final Logger log = LoggerFactory.getLogger(SessionAccessFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		final String requestUri = request.getRequestURI();
		final String method = request.getMethod();

		List<PermissionInfo> permissionInfos = null;
		if (request.getSession().getAttribute("permission") == null) {
			request.getSession().setAttribute("permission", permissionInfos);
		}
		return null;
	}

}
