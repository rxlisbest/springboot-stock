# 项目
### 框架
- springboot
- mybatis

### 接口风格
- restful

### 权限
- jwt

### 操作步骤
- 新建数据库stock
- src/main/resources 目录下新建文件application-prod.yml
- 将application-dev.yml中的内容复制到application-prod.yml
- 修改application.yml中spring:profiles:active为prod
- 修改spring:datasource中的username和password
- 根目录执行命令mvn clean package

# 前端项目
https://github.com/rxlisbest/vue-stock.git