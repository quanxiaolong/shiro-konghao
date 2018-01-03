# 第5个视频

# 练习内容
* 权限一个或多Realm
* 权限解析器 WildcardPermissionResolver 
* 权限对象 WildcardPermission／Permission 判断方法implies
* 自定义权限／权限解析器
* 配置自定义权限解析器
```

myPermissionResolver = cn.com.qxl.shiro.permission.MyPermissionResolver
securityManager.authorizer.permissionResolver =$myPermissionResolver
```
* 自定义角色解析器
* 配置自定义角色解析器
```

myRolePermisssionResolver=cn.com.qxl.shiro.permission.MyRolePermissionResolver
securityManager.authorizer.rolePermissionResolver = $myRolePermisssionResolver
```
# 总结
* 通过ModularRealmAuthorizer 管理realm为每个realm 
* ModularRealmAuthorizer为每个realm 分配权限解析器 applyPermissionResolverToRealms()分配PermissionResolver 
* ModularRealmAuthorizer为每个realm 分配角色权限解析器 applyRolePermissionResolverToRealms()分配RolePermissionResolver 
* 每个realm通过doGetAuthorizationInfo为用户分配权限
* 当subject调用ispermissoin时，遍历所有的realm.
* 通过权限解析器WildcardPermissionResolver 对传入的权限字符串生成权限对象Permission
* 遍历realm中的权限 通过权限对象WildcardPermission的implies方法 验证权限