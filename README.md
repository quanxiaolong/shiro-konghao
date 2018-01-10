# 第10视频
链接: https://pan.baidu.com/s/1pMffXUj 密码: x7dg
* 基于过滤器链的授权操作流程
# 说明
* 孔浩老师搭建此此练习项目采用的是Spring+hibernate实现
* 因为目前公司采用Mybatis 我搭建这个例子采用的Spring+SpringMvc+Mybatis实现
* 主要是帮助理解和应用shiro 已跟着孔浩老师教学视频测试所有流程
* 测试地址
```
1. http://localhost:8080/shiro/admin
2. http://localhost:8080/shiro/login.html
3. http://localhost:8080/shiro/logout.html
```
* 附加数据库表结构以及测试数据 与孔浩老师表结构不同 不影响测试SHIRO_TEST.sql 
# 练习内容
* 所有和路径相关的Filter都应该继承PathMatchingFilter
* 自定义Filter
* AccessControlFiler（自定义权限过滤器时，主要实现该类）
```
isAccessAllowed() : 判断是否允许访问
onAccessDenied():当不允许访问时（isAccessAllowed返回false）执行的操作 （跳转）
getSubject():获取当前请求的对象
getPathWithinApplication(request): 获取当前请求地址链接
```
* 字符串比较工具PatternMatcher
```
1. 正则风格：RegExPatternMatcher
2. 路径风格：AntPathMatcher

```

# 总结
* 过滤器工作流程

```
1. AccessControlFiler 中的isAccessAllowed方法判断 当前用户是否可以访问改资源。
2.isAccessAllowed 调用subject的isPermitted方法。
3. 接着就是第五个视频讲解的 权限认证流程
4. 权限认证流程
通过ModularRealmAuthorizer 管理realm为每个realm
ModularRealmAuthorizer为每个realm 分配权限解析器 applyPermissionResolverToRealms()分配PermissionResolver
ModularRealmAuthorizer为每个realm 分配角色权限解析器 applyRolePermissionResolverToRealms()分配RolePermissionResolver
每个realm通过doGetAuthorizationInfo为用户分配权限
当subject调用ispermissoin时，遍历所有的realm.
通过权限解析器WildcardPermissionResolver 对传入的权限字符串生成权限对象Permission
遍历realm中的权限 通过权限对象WildcardPermission的implies方法 验证权限
```
* 代码
```
public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        Subject subject = getSubject(request, response);
        String[] perms = (String[]) mappedValue;
        boolean isPermitted = true;
        if (perms != null && perms.length > 0) {
            if (perms.length == 1) {
                if (!subject.isPermitted(perms[0])) {
                    isPermitted = false;
                }
            } else {
                if (!subject.isPermittedAll(perms)) {
                    isPermitted = false;
                }
            }
        }
        return isPermitted;
    }

```