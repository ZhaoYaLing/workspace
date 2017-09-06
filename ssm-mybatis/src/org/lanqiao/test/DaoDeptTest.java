package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.dao.DeptDao;
import org.lanqiao.entity.Dept;

public class DaoDeptTest {
	private static SqlSessionFactory factory=null;
	static{
		String resource="mybatis-conf.xml";
		try {
			//a.读取核心配置文件
			InputStream in= Resources.getResourceAsStream(resource);
			//b.根据核心配置文件创建一个工厂对象
			factory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetDeptByDeptno(){
		DeptDao dao=new DeptDao(factory);
		Dept dept=new Dept();
		dept.setDeptno(10);
		dept=dao.getDeptByDeptNo(dept.getDeptno());
		//System.out.println(dept);
		
		List<Dept> list=dao.list();
		//System.out.println(list);
		
//		Dept dept1=new Dept(50,"设计部","LA");
//		dao.insert(dept1);
//		dept.setDeptno(50);
//		dept=dao.getDeptByDeptNo(dept.getDeptno());
		//System.out.println(dept);
		
//		Dept dept2=new Dept();
//		dept2.setDeptno(50);
//		dept2.setDname("财政部");
//		dept2.setLoc("洛杉矶");
//		dao.update(dept2);
//		dept.setDeptno(50);
//		dept=dao.getDeptByDeptNo(dept.getDeptno());
//		System.out.println(dept);
		
		Dept dept3=new Dept();
		dept3.setDeptno(50);
		dao.delete(dept3);
		dept.setDeptno(50);
		dept=dao.getDeptByDeptNo(dept.getDeptno());
		System.out.println(dept);
	}
	
}
