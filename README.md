# 第6个视频
* 满足加密要求的用户认证
# 练习内容
* 加密
* Base64是一种编码方式 不是加密
* 加密 md5/sha
* 密码加盐salt
* 认证除了根据用户名密码获取用户认证外（doGetAuthenticationInf） 还会单独进行密码凭证的认证（SimpleCredentialsMatcher.doCredentialsMatch）
* 配置密码认证器
```
passwordMather= org.apache.shiro.authc.credential.PasswordMatcher
passwordTestRealm=cn.com.qxl.shiro.realm.PasswordTestRealm
passwordTestRealm.credentialsMatcher=$passwordMather
```
# 密码认证器HashedCredentialsMatcher
```
* 可配置加密算法
hashMatcher=org.apache.shiro.authc.credential.HashedCredentialsMatcher
hashMatcher.hashAlgorithmName=MD5

* realm 用户认证时 要配置密码盐 (例子：自定义realm类PasswordTestRealm)
protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String u = "user";
		String p = "6ad14ba9986e3615423dfca256d04e3f";
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("abc@qq.com", p, getName());
		info.setCredentialsSalt(ByteSource.Util.bytes(u));
		return info;
	}
```
# 总结
* 用户认证过程

```
* subject.login
* 根据用户名和密码获取用户信息（doGetAuthenticationInf）
* 如果获取到用户信息则进行密码认证
* AuthenticatingRealm中的credentialsMatcher.doCredentialsMatch进行认证功能。
* 调用相应的加密算法进行密码比较认证 如PasswordService／SimpleHash等等
```
* org.apache.shiro.authc.credential中credentialsMatcher进行密码认证比较
* org.apache.shiro.crypto.hash包下面提供hash算法
* SimpleHash 允许配置任何加密算法