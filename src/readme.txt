

 ---- SQLTest ��Ŀ˵�� -----

 (1) SQLTest ��ĿĿ��������

       ����Ŀ��Ҫ��ϰ���� mysql ���ݿ�����ݳ־û������� 
    
       �ڱ���Ŀ�У����� student ʵ���࣬ ������3 �ַ�ʽ StudentDaoImpl_1.java�� StudentDaoImpl_2.java�� StudentDaoImpl_3.java��StudentDaoImpl_4.java ,
       
       ��ʵ�� dao ��Ľӿ� IStudentDao.java��
       
      ͨ������3�ַ�ʽ���ô�Ҹ��õ��˽�  jdbc, �˽� Apach ��������� c3p0�� dbutils ��ʹ�á��ŵ�, ���õ��˽������ع�����ȡ�����ࡢ�����������ࡢ��������
      
       
 (2) StudentDaoImpl_1.java ʵ�ַ�ʽ˵��
 
     1. ��������� jdbc ��ʽ��ʵ�� Student ʵ���� �����ݿ��������ɾ���ġ��飻
     
     2. ȱ�㣺 ��������ܴ�
 
 (3) StudentDaoImpl_2.java ʵ�ַ�ʽ˵��
 
     1. ʹ�� db.properties �ļ��洢���ݿ���������ţ���������޸ģ�
     2. ���������� JdbcUtil.java��
        JdbcUtil.java ���������jdbc �����������ݿ����Ӳ��� Connectino �� ��Դ�ͷ� Close �����˳�ȡ����װ�����㡢�� dao ��ʵ�������д��
     
 
 (4) StudentDaoImpl_3.java ʵ�ַ�ʽ˵��
 
     1. ʹ��c3p0 ���ݿ����ӳع����ܣ� �����ݿ�����Ӳ������й���c3p0 �����ļ��鿴  /SQLTest/src/c3p0-config.xml ��
     2. ʹ��DBUtil ��ܣ���һ���� ���ݿ������ɾ���ġ������������ȡ�� 
        void updateDatabase(String sql, Object... object)�� List<Object> queryDatabase(String sql, Object object1, Object... object2) ����ͨ�÷�����
     3. ���������� JdbcUtilc3p0.java��
        JdbcUtil.java ���������c3p0����ȡ���ݿ� Connection �� �� DBUtil ���� ������������ɾ���ġ��飩������� ���㡢�� �� dao ��ʵ�������д��
 