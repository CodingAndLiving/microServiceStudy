1.该项目基于springCloud的eureka搭建了一个高可用的服务注册中心。
原理是三个服务注册中心之间互相两两注册。

2.启动该项目的方式：

java -jar microservice-discovery-eureka-ha-1.0-SNAPSHOT.jar --spring.profiles.active=peer1
java -jar microservice-discovery-eureka-ha-1.0-SNAPSHOT.jar --spring.profiles.active=peer2
java -jar microservice-discovery-eureka-ha-1.0-SNAPSHOT.jar --spring.profiles.active=peer3

或者通过idea开发工具配置springboot运行亦可。

3.备注说明，由于spring cloud是基于spring boot2.0版本，所以，默认集成了spring security的特性，配置
文件需要多做两个配置：
1.增加登录用户名和密码，
 security:
    user:
      name: admin
      password: 123456

 2.注册时候，需要加上权限认证：
       defaultZone: http://admin:123456@peer1:8761/eureka/,http://admin:123567@peer3:8763/eureka/
