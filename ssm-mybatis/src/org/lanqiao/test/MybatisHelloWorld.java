package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Dept;

public class MybatisHelloWorld {
	@Test
	public void deleteDept() throws IOException{
		String resource="mybatis-conf.xml";
		//a.读取核心配置文件	
		InputStream in=Resources.getResourceAsStream(resource);
		//b.根据核心配置文件创建一个工厂对象
		SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(in);
		//c.根据工厂对象创建session对象
		SqlSession session=factory.openSession(); 
		int delete=session.delete("ns.deleteDept", 50);
		session.commit();
		session.close();
		System.out.println(delete);
	}
	@Test
	public void insertDept() throws IOException{
		String resource="mybatis-conf.xml";
		//a.读取核心配置文件
		InputStream in=Resources.getResourceAsStream(resource);
		//b.根据核心配置文件创建一个工厂对象
		SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(in);
		//c.根据工厂对象创建session对象
		SqlSession session=factory.openSession(); 
		Dept dept=new Dept();
		dept.setDeptno(60);
		dept.setDname("创意部");
		dept.setLoc("东京");
		int insert=session.insert("ns.insertDept",dept);
		session.commit();
		session.close();
		System.out.println(insert);
	}
	@Test
	public void updateDept() throws IOException{
		String resource="mybatis-conf.xml";
		//a.读取核心配置文件
		InputStream in=Resources.getResourceAsStream(resource);
		//b.根据核心配置文件创建一个工厂对象
		SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(in);
		//c.根据工厂对象创建session对象
		SqlSession session=factory.openSession(); 
		Dept dept=new Dept();
		dept.setDeptno(50);
		dept.setDname("创意部");
		dept.setLoc("东京");
		int update=session.update("ns.updateDept",dept);
		session.commit();
		session.close();
		System.out.println(update);
	}
	@Test
	public void getDeptByDname() throws IOException{
		String resource="mybatis-conf.xml";
		//a.读取核心配置文件
		InputStream in=Resources.getResourceAsStream(resource);
		//b.根据核心配置文件创建一个工厂对象
		SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(in);
		//c.根据工厂对象创建session对象
		SqlSession session=factory.openSession();
		List<Dept> list=session.selectList("ns.getDeptByDname","S");
		session.close();
		System.out.println(list);
	}
	
	@Test
	public void getCount() throws IOException{
		String resource="mybatis-conf.xml";
		//a.读取核心配置文件
		InputStream in=Resources.getResourceAsStream(resource);
		//b.根据核心配置文件创建一个工厂对象
		SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(in);
		//c.根据工厂对象创建session对象
		SqlSession session=factory.openSession();
		int count=session.selectOne("ns.getCount");
		session.close();
		System.out.println(count);
	}
	@Test
	public void getDepts() throws IOException{
		String resource="mybatis-conf.xml";
		//a.读取核心配置文件
		InputStream in=Resources.getResourceAsStream(resource);
		//b.根据核心配置文件创建一个工厂对象
		SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(in);
		//c.根据工厂对象创建session对象
		SqlSession session=factory.openSession();
		List<Dept> list=session.selectList("ns.getDepts");
		session.close();
		System.out.println(list);
	}
	@Test
	public void testGetDeptByDeptno() throws IOException{
		String resource="mybatis-conf.xml";
		//a.读取核心配置文件
		InputStream in=Resources.getResourceAsStream(resource);
		//b.根据核心配置文件创建一个工厂对象
		SqlSessionFactory  factory=new SqlSessionFactoryBuilder().build(in);
		//c.根据工厂对象创建session对象
		SqlSession session=factory.openSession();
		//d.根据session执行数据库操作，返回操作结果
		Dept dept=session.selectOne("ns.getDeptByDeptno", 10);
		//e.关闭对象，释放资源
		session.close();
		System.out.println(dept);
	}
}
