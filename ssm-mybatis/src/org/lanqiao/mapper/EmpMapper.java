package org.lanqiao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lanqiao.entity.Emp;
import org.lanqiao.entity.PageVo;

public interface EmpMapper {
	@Select(value=("select * from emp where empno=#{empno}"))
	public Emp getEmpByEmpno(Integer empno);
	@Insert(value=("insert into emp values(#{empno},#{ename},#{job},#{mgr},#{hiredate},#{sal},#{comm},#{deptno})"))
	public void insert(Emp emp);
	@Update(value=("update emp set ename=#{ename},job=#{job},mgr=#{mgr},hiredate=#{hiredate},sal=#{sal},comm=#{comm},deptno=#{deptno} where empno=#{empno}"))
	public void update(Emp emp);
	public List<Emp> pageList(PageVo pagevo);
	public List<Emp> list();
}
