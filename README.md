# 第13视频
* shiro加入ehcache缓存
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

# 练习内容
* 启用Ehcache缓存。
* 实现认证和授权缓存。
* 分析认证和授权缓存流程
* 分析logout退出时清除缓存流程。

# 总结
## 认证和授权缓存流程
* shiro 提供cachemanager 但都只是接口 ，需要提供具体的实现。
* ehcache 首先要提供一个配置文件。
* 定义缓存管理器

```
<bean id="cacheManager" class="org.apache.shiro.cache.ehcache.EhCacheManager"></bean>
```

* securityManager 配置缓存管理器 
```
1. 所有实现CacheManagerAware的Realm会自动设置上CacheManager（官网A皮）
2.代码
	<bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
		<property name="realm" ref="userRealm"/>
		<property name="authorizer.permissionResolver" ref="urlPermissionResolver"/>
		<property name="cacheManager" ref="cacheManager"/>
	</bean>
```
* Realm中开启缓存并设置缓存器名称在AuthorizingRealm和AuthenticatingRealm分别有配置是否开启认证和授权缓存以及认证和授权缓存器的名称
```
1. realm的继承关系 AuthorizingRealm->AuthenticatingRealm->CachingRealm
2. 开启认证缓存和权限缓存
1. AuthorizingRealm属性authorizationCachingEnabled和authorizationCacheName
2. AuthenticatingRealm属性authenticationCachingEnabled和authenticationCacheName
3. CachingRealm 属性 cachingEnabled 开启缓存
4. 代码
	<bean id="userRealm" class="cn.com.qxl.shiro.realm.UserRealm">
		<property name="credentialsMatcher" ref="hashMatcher"/>
		<property name="cachingEnabled" value="true"></property>
		<property name="authenticationCachingEnabled" value="true"></property>
		<property name="authenticationCacheName" value="shiro-authenticationCache"></property>
		<property name="authorizationCachingEnabled" value="true"/>
		<property name="authorizationCacheName" value="shiro-authorizationCache"></property>
	</bean>
```
## 清除缓存流程
* logout Filter中调用subject.logout();
* 调用SecurityManager的securityManager.logout(this)
* 调用Authenticator——>ModularRealmAuthenticator的onLogou()
* 调用ModularRealmAuthenticator 管理的所有Realm中每个实现LogoutAware的Realm的((LogoutAware) realm).onLogout(principals);
* 权限AuthorizingRealm和认证AuthenticatingRealm都实现LogoutAware
* AuthorizingRealm中的clearCachedAuthorizationInfo实现授权信息清除
* AuthenticatingRealm的clearCachedAuthenticationInfo实现认证信息清除
* 特殊说明
```
1. AuthorizingRealm以PrincipalCollection为Key缓存的权限信息。
2. AuthenticatingRealm1以用户名为Key缓存的认证信息。
3. 清除时都是按PrincipalCollection为key进行清除的
```
