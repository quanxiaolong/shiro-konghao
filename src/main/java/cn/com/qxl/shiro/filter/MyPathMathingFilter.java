package cn.com.qxl.shiro.filter;

import java.util.Arrays;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;

public class MyPathMathingFilter extends PathMatchingFilter {

	@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		System.out.println("path mathing");
		System.out.println(Arrays.toString((String[])mappedValue));
		return super.onPreHandle(request, response, mappedValue);
	}
}
