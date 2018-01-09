# 第7/8个视频
* 实现思路分析和环境搭建
* 实现service层的内容
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
# 练习内容
* 初始搭建项目环境
* 密码加盐匹配操作
* 配置数据库常用操作Dao/service
* 自定义realm
* 配置realm认证匹配器credentialsMatcher
* 实现登陆认证doGetAuthenticationInfo 绑定用户／密码／盐值信息SimpleAuthenticationInfo上
* 实现授权操作doGetAuthorizationInfo 绑定权限和角色信息在SimpleAuthorizationInfo上