package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Dept;

public interface DeptMapper {
	public Dept getDeptByDeptno(Integer deptno);
	public List<Dept> getDepts();
	public void insert(Dept dept);
	public void delete(Dept dept);
	public void update(Dept dept);
}
