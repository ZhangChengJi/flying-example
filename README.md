# flying-example
flying-client sample springboot

> Flying client 使用例子 springboot版

本项目是java 版本spring boot 框架如何使用flying-client 的简单例子。

## 测试步骤

1. 在flying-admin 创建一个项目名为：flying-example，并且选择dev环境

2. 通过flying-admin在flying-example项目里面创建一个名字为default 的namespace(命名空间)，并且是在dev环境下

3. 在dev环境下的default namespace(命名空间) 添加如下配置，然后进行配置发布：

   ```yml
   abc: a、b、c、d、e、f、g、h、i、j、k、l、m、n、o、p、q、r、s、t、u、v、w、x、y、z
   user:
     name: Bruce Lee
     age: 32
     sex: 男
     contact: 李小龙（英文名：Bruce Lee，1940年11月27日—1973年7月20日），本名李振藩，出生于美国加利福尼亚州旧金山，祖籍中国广东省佛山市顺德区均安镇，世界武道变革先驱者、武术技击家、武术哲学家、功夫片的开创者和截拳道创始人、华人武打电影演员，中国功夫首位全球推广者、好莱坞首位华人主角。
   ```

4. 修改flying-example项目的bootstrap.yml 里面的dev环境地址(修改成自己的) 比如你dev 环境是192.168.1.120:8881

5. 启动项目，访问http://localhost:999/user，http://localhost:9999/abc 测试

6. 测试配置热加载，修改配置文件然后发布，再次访问

主要使用方式看：

bootstrap.yml

````yml
spring:
  profiles:
    active: ${ACTIVE:dev}   # 配置启动环境，如果系统环境变量$ACTIVE配置了环境名称那么默认使用$ACTIVE的
  flying:
    bootstrap:
      app-id: flying-example  #当前自己项目名称
      enabled: true          # 是否开启flying配置中心 默认为false
      refresh-enabled: true  # 是否开启实时配置更新   默认为false
      namespace: default     # 在服务端配置的当前项目配置信息的命名空间名称，可以有多个，多个逗号分隔
      address:               # 配置多个环境，启动时会根据spring.profiles.active环境名称进行选择环境加载配置
        - name: dev          # 环境名称
          url: 192.168.0.101:8881 #环境地址(服务端地址)
        - name: fat          # 环境名称
          url: flying-config.flying.svc:8881 #环境地址(服务端地址) k8s 环境写法
server:
  port: 9999
````



### 注意：

spring boot 项目的resources配置文件命名一定是`bootstrap.yml`才是可以。

### 联系

如果遇到问题，请联系 

​	邮箱：380702562@qq.com

​	wechat: Zcjvsgola



