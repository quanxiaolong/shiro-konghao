# 第12视频
* 和Spring项目整合
# 说明
* 孔浩老师搭建此此练习项目采用的是Spring+hibernate实现
* 因为目前公司采用Mybatis 我搭建这个例子采用的Spring+SpringMvc+Mybatis实现
* 主要是帮助理解和应用shiro 已跟着孔浩老师教学视频测试所有流程
* 测试地址
```
1. http://localhost:8080/shiro/admin
2. http://localhost:8080/shiro/login.html
3. http://localhost:8080/shiro/logout.html
4. http://localhost:8080/shiro/t1.html
```
* 附加数据库表结构以及测试数据 与孔浩老师表结构不同 不影响测试SHIRO_TEST.sql 
# 说明
```
1. 视频中孔浩老师测试的shiro注解 @@RequiresRoles("ADMIN") 应该是有问题的。
访问地址设置为 http://localhost:8080/shiro/admin/t1.html 其中起校验作用的并不是注解RequiresRoles 。而是在shiro-beans.xml中配置的
		<property name="filterChainDefinitions">
			<value>
				/admin/**=authc,resourceCheckFilter
				/login.html=anon
				/logout.html=logout
			</value>
		</property>
因为 删除RequiresRoles注解 。同样还是会有认证和权限校验。
2. 视频中起初hello/t1.html没有成功是因为注解校验 配置的位置不对 应该配置到 lifecycleBeanPostProcessor之后
<bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator" depends-on="lifecycleBeanPostProcessor"/>
    <bean class="org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor">
    <property name="securityManager" ref="securityManager"/>
</bean>

```
# 练习内容
* 认证和授权最外层 都是通过Filter拦截的
* 讲解认证流程
```
1. [urls]中配置需要认证访问的页面地址以及验证过滤器。／admin/**=authc
2. authc Filter 通过isAccessAllowed（）判断当前用户未登录。
3. 调用subject.isAuthenticated()true返回
4. false则通过Filter.onAccessDenied重定向到登陆页。
4. 用户调用login服务，subject.login.
5. 调用Realm的doGetAuthenticationInfo获取用户信息。
6. 若获取到用户信息 还会调用credentialsMatcher（如HashedCredentialsMatcher）进行密码认证匹配
7. AuthenticatingRealm中的credentialsMatcher.doCredentialsMatch进行认证功能。
8. 调用相应的加密算法进行密码比较认证 如PasswordService／SimpleHash等等
```
* 讲解授权流程
```
1. [urls]中配置需要权限的访问的页面以及验证过滤器。／admin/**=roles[admin]
2. roles Filter 通过isAccessAllowed判断当前用户是否有权访问当前页面
3. 调用subject.isPermitted.
4. 调用Realm 中doGetAuthorizationInfo获取用户权限信息。
5. ModularRealmAuthorizer为每个Realm中分配一个权限解析器PermissionResolver和角色权限解析器RolePermissionResolver，用来生成相应的Permission权限对象。
6. 通过Permission的implies方法 判断是否具有该页面的访问权限。
7. 若最终Filter的isAccessAllowed()返回false则调用Filter的onAccessDenied（）重定向到未授权页面
```
* 与Spring的整合实质上就是将shiro.ini中的东西 配置到XML中交给Spring来管理
* shiro注解 例如@RequiresRoles, @RequiresPermissions 需要配置在lifecycleBeanPostProcessor之后 且在Controller扫描的XML之后
```
<bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator" depends-on="lifecycleBeanPostProcessor"/>
    <bean class="org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor">
    <property name="securityManager" ref="securityManager"/>
</bean>
```
# 总结
