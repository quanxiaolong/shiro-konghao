# dev3 第三个视频教程 不需要merge 到 master
# 视频3练习了解内容
* 可以自定义realm
* 可配多个realm
* 多个realm 可实现多数据源，多授权（通过多Principal）
* 多个realm之间的认证关系由认证策略控制（AuthenticationStrategy）
```
authcStrategy = org.apache.shiro.authc.pam.FirstSuccessfulStrategy
securityManager.authenticator.authenticationStrategy = $authcStrategy
```
* 认证和授权都是在Realm中实现doGetAuthorizationInfo／doGetAuthorizationInfo
* realm名称 如果没有配置setName 则会是配置文件重的变量名