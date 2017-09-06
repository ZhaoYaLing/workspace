package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Emp;
import org.lanqiao.entity.PageVo;
import org.lanqiao.mapper.EmpMapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class EmpMapperTest {
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
	public void testGetEmpByEmpno(){
		SqlSession session=factory.openSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		Emp emp=mapper.getEmpByEmpno(7369);
		System.out.println(emp);
	}
	@Test
	public void testInsert(){
		SqlSession session=factory.openSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		Emp emp=new Emp();
		emp.setEmpno(1);
		emp.setEname("zyl");
		emp.setJob("教练");
		emp.setMgr(7902);
		Date date=new Date(2017, 8, 25);
		emp.setHiredate(date);
		emp.setSal(8000.0);
		emp.setComm(256.0);
		emp.setDeptno(10);
		mapper.insert(emp);
		Emp emp1=mapper.getEmpByEmpno(1);
		System.out.println(emp1);
	}
	@Test
	public void testUpdate(){
		SqlSession session=factory.openSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		Emp emp=new Emp();
		emp.setEmpno(1);
		emp.setEname("赵雅玲");
		emp.setJob("教练");
		emp.setMgr(7902);
		Date date=new Date(2017, 8, 25);
		emp.setHiredate(date);
		emp.setSal(8000.0);
		emp.setComm(256.0);
		emp.setDeptno(10);
		mapper.insert(emp);
		Emp emp1=mapper.getEmpByEmpno(1);
		System.out.println(emp1);
	}
	@Test
	public void testPageVo(){
		SqlSession session=factory.openSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		PageVo pagevo=new PageVo(2, 1);
		List<Emp> list=mapper.pageList(pagevo);
		System.out.println(list);
	}
	@Test
	public void test(){
		SqlSession session=factory.openSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		Page<Emp> pager=PageHelper.startPage(1, 2);
		List<Emp> list=mapper.list();
		PageInfo<Emp> pageinfo=new PageInfo<Emp>(list);
		System.out.println(pageinfo.getList().get(1));
	}
}
