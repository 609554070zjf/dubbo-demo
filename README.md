# 项目简述
Dubbo是一个分布式服务框架，是阿里巴巴SOA服务化治理方案的核心框架。
该demo是基于maven搭建的，项目架构基于SpringMVC。
## 一、软件环境 
前提：需要下载dubbo，使用maven打包dubbo-admin.war,将其部署到Tomcat的webapps/ROOT目录下。  
1、zookeeper-3.3.6   
2、springMVC （maven方式引入）   
3、dubbo （maven方式引入）  
## 二、项目搭建
### 项目结构  
maven父工程：dubbo-demo  
maven子工程：  

- dubbo-api:主要是接口定义，供controller调用，以及service层去实现该接口，分离这一层的好处就是前段项目调用接口时候，直接调用dubbo-api的接口即可，不需要关注后端如何实现；而service层来具体实现该接口，进行业务逻辑处理，不需要关注 controller层如何调用。   
- dubbo-controller:主要controller层控制跳转等。  
- dubbo-service:主要是service实现，结合数据层实现后端业务逻辑处理。  

### 项目流程说明  
1. 首先在dubbo-api子工程中定义接口，然后打成jar包以供dubbo-controller和dubbo-service引用。
2. 在dubbo-service子工程中实现dubbo-api中定义的接口。将该子工程注册为服务提供者，注册到zookeeper注册中心中，并将service实现类通过dubbo暴露出来。
3. 在dubbo-controller子工程中使用SpringMVC编写Controller控制跳转，将该子工程作为服务消费者，向zookeeper注册中心暴露服务地址，以及告诉dubbo需要调用的接口。
4. 将dubbo-service和dubbo-controller通过maven打成war包，部署到tomcat中，启动Zookeeper后，在启动tomcat服务器。
5. 在浏览器中输入：http://127.0.0.1:8080/dubbo-controller/test?name=root  返回在TestRegistryServiceImpl.java中编写的结果。
6. Maven+SpringMVC+Dubbo+Zookeeper的入门demo搭建完毕。
7. 启动Tomcat服务器，使用浏览器访问http://127.0.0.1:8080(前提将dubbo-admin.war部署到webapps/ROOT目录中)，登录dubbo。可以看到首页统计信息显示：服务数：1 应用数：2 提供者数：1 消费者数：1
8. 还可以在dubbo管理界面给服务提供者设置权重，dubbo可以通过设置权重来实现负载均衡。	