# Blog
Maven 项目
jdk1.8
自己下git插件，maven插件
项目刚导入，估计会报错，一般都是maven导包的问题，把仓库中出问题的包删了，重现导一下试试。
还有别忘了将tomcat中lib目录下的包导入到项目中。
以下是项目中具体文件的介绍：
首先是配置文件：（src/main/resources包）
  1.sqlMapperXml包：用于存放dao层的sql语句的xml文件(XXXMapper.xml)
  2.applicationContext.xml：配置数据库连接配置，包扫描配置，事物管理配置，aop切面配置
  3.springmvc-servlet.xml:aop注解扫描配置，视图解析器配置，静态资源配置
  4.logback.xml:logback日志配置，共两套，控制台打印一套日志，文件打印一套日志
  5.jdbc.properties：存放数据库连接相关参数，被applicationContext.xml调用
  6.configuration.properties:存放其他配置参数，如每页显示数量pagesize等，方便后期代码修改，该配置
    的参数通过com.Blog.utils包中的PropertiesFactoryHelper.java类的getPro(String key)方法调用。
  7.其他配置文件，如redis,shiro的配置文件暂时无用，以备后患用的，可以忽略。
其次是项目中的代码（com.Blog包）
  1.aspect包：自定义的注解与实现，用于日志管理的@SystemControllerLog注解用于注解Controller层的方法，
    使用该注解的方法会打印日志，@SystemServiceLog注解用于Service层，注解具体实现在SystemLogAspect.java
    文件中。使用方法如controller包中的LoginController.java的home方法。
   （我觉得没啥卵用，可以自己在方法里打日志的，但还是先留着吧，毕竟比较方便，你们爱用不用。）
  2.controller包：
    BaseController.java最初想法是所有controller的父类，用于存放公共方法，用不用再商量吧。（我觉得有点用）
    CommonController.java（我擦，这个忘了删了，当初是用来页面跳转的临时类，自动忽略吧）
    FileController.java这个是我用来处理文件功能的。
    LoginControler.java登录功能用。
  3.exception包：
    自定义异常的，应该是用于处理事务这方面的，我没细看，先留着。
  4.utils包（工具类包）：
    dataSources包：双数据源相关的类，不乱动就行（其实暂时没啥用，也用不到双数据源，我就是懒得改成单数据源了）。
    redisUtil包：用不到，没啥用，先留着，万一以后用上呢。
    PropertiesFactoryHelper.java用于取configuration.properties文件中的参数的工具类。
    其他类就见名知意了。
   
