/**  
*    �ļ���:  Student.java
*    �ļ�����:  
*  @author zhanggtaoyi 
*  @date 2019��3��18��  
*/  
package zty.entity;
/**
*    ������: 
*  @author ����һ ,2547260515@qq.com
*  @since 2019��3��18�� ����10:24:27
*/


/*
 * MYSQL������JAVA���Ͷ�Ӧ��: https://www.cnblogs.com/UniqueColor/p/9055866.html
*/

public class Student {
	
	String SID;
	String Sname;
	int Sage;
	String Sex;
	public String getSID() {
		return SID;
	}
	public void setSID(String sID) {
		SID = sID;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public int getSage() {
		return Sage;
	}
	public void setSage(int sage) {
		Sage = sage;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getSclass() {
		return Sclass;
	}
	public void setSclass(String sclass) {
		Sclass = sclass;
	}
	String Sclass;
	@Override
	public String toString() {
		return "Student [SID=" + SID + ", Sname=" + Sname + ", Sage=" + Sage + ", Sex=" + Sex + ", Sclass=" + Sclass
				+ "]";
	}
	
	
	

}
