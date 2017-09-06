package org.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.lanqiao.entity.Dept;

public class DeptDao {
	private SqlSessionFactory factory=null;
	public DeptDao(SqlSessionFactory factory){//通过构造方法注入factory对象
		this.factory=factory;
	}
	public Dept getDeptByDeptNo(Integer deptno){
		SqlSession session=factory.openSession();
		Dept dept=session.selectOne("ns.getDeptByDeptno", deptno);
		session.close();
		return dept;
	}
	public List<Dept> list(){
		SqlSession session=factory.openSession();
		List<Dept> list=session.selectList("ns.getDepts");
		session.close();
		return list;
	}
	public void insert(Dept dept){
		SqlSession session=factory.openSession();
		int insert=session.insert("ns.insertDept", dept);
		session.commit();
		session.close();
	}
	public void delete(Dept dept){
		SqlSession session=factory.openSession();
		int delete=session.delete("ns.deleteDept", dept);
		session.commit();
		session.close();
	}
	public void update(Dept dept){
		SqlSession session=factory.openSession();
		int update=session.update("ns.updateDept", dept);
		session.commit();
		session.close();
	}
}
