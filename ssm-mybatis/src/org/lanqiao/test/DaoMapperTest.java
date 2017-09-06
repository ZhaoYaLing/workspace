package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.dao.DeptDao;
import org.lanqiao.entity.Dept;
import org.lanqiao.mapper.DeptMapper;

public class DaoMapperTest {
	private static SqlSessionFactory factory = null;
	static {
		String resource = "mybatis-conf.xml";
		try {
			// a.读取核心配置文件
			InputStream in = Resources.getResourceAsStream(resource);
			// b.根据核心配置文件创建一个工厂对象
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetDeptByDeptno() {
		SqlSession session=factory.openSession();
		DeptMapper deptmapper=session.getMapper(DeptMapper.class);
		Dept dept=deptmapper.getDeptByDeptno(10);
		System.out.println(dept);
	}
	@Test
	public void testGetDepts(){
		SqlSession session=factory.openSession();
		DeptMapper deptmapper=session.getMapper(DeptMapper.class);
		List<Dept> list=deptmapper.getDepts();
		System.out.println(list);
	}
	@Test
	public void testInsert(){
		SqlSession session=factory.openSession();
		DeptMapper deptmapper=session.getMapper(DeptMapper.class);
		Dept dept =new Dept(70,"销售部","南京");
		deptmapper.insert(dept);
		List<Dept> list=deptmapper.getDepts();
		System.out.println(list);	
	}
	@Test
	public void testDelete(){
		SqlSession session=factory.openSession();
		DeptMapper deptmapper=session.getMapper(DeptMapper.class);
		Dept dept=new Dept();
		dept.setDeptno(70);
		deptmapper.delete(dept);
		List<Dept> list=deptmapper.getDepts();
		System.out.println(list);	
	}
	@Test
	public void testUpdate(){
		SqlSession session=factory.openSession();
		DeptMapper deptmapper=session.getMapper(DeptMapper.class);
		Dept dept=new Dept(50,"销售部","南京");
		deptmapper.update(dept);
		List<Dept> list=deptmapper.getDepts();
		System.out.println(list);	
	}
}
