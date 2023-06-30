该示例整合springboot和mybatis逆向工程的generator插件以及pagehelper分页插件
一共需要以下步骤：
1. 导入 `pom.xml`中的依赖：
```xml
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>1.4.6</version>
</dependency>
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.3.1</version>
</dependency>
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>

<!--mybatis逆向工程插件，也就是generator插件-->
<plugin>
    <!--插件的GAV坐标-->
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.4.1</version>
    <!--允许覆盖-->
    <configuration>
        <overwrite>true</overwrite>
    </configuration>
    <!--插件的依赖-->
    <dependencies>
        <!--mysql驱动依赖-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>
    </dependencies>
</plugin>
```
导入依赖刷新后，可以看到项目的 plugins 下有一个mybatis-generator插件，这个就是用来生成逆向工程的。

2. 在resources目录下新建 `generatorConfig,xml`：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
               "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <!--
        targetRuntime有两个值：
            MyBatis3Simple：生成的是基础版，只有基本的增删改查。
            MyBatis3：生成的是增强版，除了基本的增删改查之外还有复杂的增删改查。
    -->
    <context id="DB2Tables" targetRuntime="MyBatis3">
        <!--防止生成重复代码-->
        <plugin type="org.mybatis.generator.plugins.UnmergeableXmlMappersPlugin"/>

        <commentGenerator>
            <!--是否去掉生成日期-->
            <property name="suppressDate" value="true"/>
            <!--是否去除注释-->
            <property name="suppressAllComments" value="true"/>
        </commentGenerator>

        <!--连接数据库信息-->
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/mybatis-new"
                        userId="root"
                        password="248613">
        </jdbcConnection>

        <!-- 生成pojo包名和位置 实体类-->
        <javaModelGenerator targetPackage="cdu.zch.demo21mybatisgeneratorpage.pojo" targetProject="src/main/java">
            <!--是否开启子包-->
            <property name="enableSubPackages" value="true"/>
            <!--是否去除字段名的前后空白-->
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <!-- 生成SQL映射文件的包名和位置 写SQL的xml-->
        <sqlMapGenerator targetPackage="cdu.zch.demo21mybatisgeneratorpage.mapper" targetProject="src/main/resources">
            <!--是否开启子包-->
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <!-- 生成Mapper接口的包名和位置 mapper接口-->
        <javaClientGenerator
                type="xmlMapper"
                targetPackage="mappers"
                targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>

        <!-- 表名和对应的实体类名 参与逆向工程的表-->
        <table tableName="t_act" domainObjectName="Account"/>

    </context>
</generatorConfiguration>
```
3. 双击 `mybatis-generator`插件，即可生成逆向工程代码。