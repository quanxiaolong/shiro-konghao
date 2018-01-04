# dev4第四个视频
* 授权中默认的权限字符串的讲解
# 联系内容
* 授权
* 角色配置规则

```
规则：“用户名=密码，角色1，角色2”“角色=权限1，权限2”，即首先根据用户名找到角色，然后根据角色再找到权限；即角色是权限集合；Shiro同样不进行权限的维护，需要我们通过Realm返回相应的权限信息。只需要维护“用户——角色”之间的关系即可。
```
* 角色检测 hasrole和checkrole的区别

```
  checkrole若不包含角色会抛出异常，而hasrole则返回false

```
* 权限配置规则

```
规则：“资源标识符：操作：对象实例ID”  即对哪个资源的哪个实例可以进行什么操作。其默认支持通配符权限字符串，“:”表示资源/操作/实例的分割；“,”表示操作的分割；“*”表示任意资源/操作/实例。

[roles]
## classroom-->classroom:*
r1="user:create,delete","dep:delete,view",classroom
r2=topic:*
r3=admin:user:*,*:view,*:*:view
```
*权限检测 haspermission与checkpermission 区别
