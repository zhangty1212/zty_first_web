

 ---- SQLTest 项目说明 -----

 (1) SQLTest 项目目的与作用

       该项目主要练习基于 mysql 数据库的数据持久化操作； 
    
       在本项目中，基于 student 实体类， 我用了3 种方式 StudentDaoImpl_1.java、 StudentDaoImpl_2.java、 StudentDaoImpl_3.java、StudentDaoImpl_4.java ,
       
       来实现 dao 层的接口 IStudentDao.java；
       
      通过上述3种方式，让大家更好的了解  jdbc, 了解 Apach 第三方框架 c3p0、 dbutils 的使用、优点, 更好的了解代码的重构（抽取工具类、消除代码冗余、技术沉淀）
      
       
 (2) StudentDaoImpl_1.java 实现方式说明
 
     1. 用最基本的 jdbc 方式，实现 Student 实体类 在数据库里的增、删、改、查；
     
     2. 缺点： 代码冗余很大；
 
 (3) StudentDaoImpl_2.java 实现方式说明
 
     1. 使用 db.properties 文件存储数据库相关链接信，方便后续修改；
     2. 创建工具类 JdbcUtil.java；
        JdbcUtil.java 工具类基于jdbc 技术，对数据库连接操作 Connectino 和 资源释放 Close 进行了抽取、封装，方便、简化 dao 层实现类的书写；
     
 
 (4) StudentDaoImpl_3.java 实现方式说明
 
     1. 使用c3p0 数据库连接池管理框架， 对数据库的连接操作进行管理；c3p0 配置文件查看  /SQLTest/src/c3p0-config.xml ；
     2. 使用DBUtil 框架，进一步简化 数据库的增、删、改、查操作，并抽取出 
        void updateDatabase(String sql, Object... object)、 List<Object> queryDatabase(String sql, Object object1, Object... object2) 两个通用方法；
     3. 创建工具类 JdbcUtilc3p0.java；
        JdbcUtil.java 工具类基于c3p0（获取数据库 Connection ） 和 DBUtil 技术 （对数据增、删、改、查），极大的 方便、简化 了 dao 层实现类的书写；
 