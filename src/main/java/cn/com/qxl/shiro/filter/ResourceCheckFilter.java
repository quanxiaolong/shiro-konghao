package cn.com.qxl.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

public class ResourceCheckFilter extends AccessControlFilter {

	private String errorUrl;
	
	
	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = getSubject(request, response);
		String url = getPathWithinApplication(request);
		return subject.isPermitted(url);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletResponse hsp =(HttpServletResponse) response;
		HttpServletRequest hrq=(HttpServletRequest) request;
		hsp.sendRedirect(hrq.getContextPath()+errorUrl);
		return false;
	}

}
