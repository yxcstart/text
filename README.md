# 工程简介
本项目基于springboot开发，是一个简易的学生成绩管理系统，本项目通过aop动态切面编程的方式，拦截并且记录HTTP流量数据以及查询数据库的sql语句

![image](https://github.com/yxcstart/text/blob/master/img/%E9%A6%96%E9%A1%B5.png)
首页

![image](https://github.com/yxcstart/text/blob/master/img/%E6%B7%BB%E5%8A%A0%E6%95%B0%E6%8D%AE.png)
添加数据

![image](https://github.com/yxcstart/text/blob/master/img/%E4%BF%AE%E6%94%B9%E5%92%8C%E5%88%A0%E9%99%A4%E6%88%90%E7%BB%A9.png)
修改和删除数据

# 基于aop的流量数据拦截和sql语句记录
通过面向切面编程实现的流量拦截，sql语句是通过自定义注解然后基于aop实现
我把流量数据和sql语句都存放到了数据库当中，于此同时也通过日志文件记录了两者的信息
http的建表语句如下
ps：可以记录很多流量数据，我这里只选择了部分字段信息
```MySQL
 create table http
(
    id             int auto_increment
        primary key,
    time           varchar(50)  not null,
    ip             varchar(50)  not null,
    port           int          not null,
    url            varchar(50)  not null,
    protocol       varchar(50)  not null,
    connection     varchar(50)  not null,
    acceptEncoding varchar(50)  not null,
    accept         text         not null,
    target         varchar(100) not null
);
```
sqlstatement的建表语句如下
```MySQL
create table sqlstatement
(
    id        int auto_increment
        primary key,
    time      varchar(50) not null,
    ip        varchar(50) not null,
    port      int         not null,
    statement text        null
);
```
流量检测拦截的数据库效果图如下：
![image](https://github.com/yxcstart/text/blob/master/img/http%E6%B5%81%E9%87%8F%E6%95%B0%E6%8D%AE%E5%BA%93.png)

sql语句拦截记录的数据库效果图如下：
![image](https://github.com/yxcstart/text/blob/master/img/sql%E8%AF%AD%E5%8F%A5%E6%95%B0%E6%8D%AE%E5%BA%93.png)


