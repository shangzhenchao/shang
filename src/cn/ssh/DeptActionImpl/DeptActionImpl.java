package cn.ssh.DeptActionImpl;

import java.util.List;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.ssh.DeptAction.DeptAction;
import cn.ssh.DeptDomain.Department;
import cn.ssh.DeptService.DeptService;


public class DeptActionImpl extends ActionSupport implements DeptAction,ModelDriven<Department> {
		//ģ������ʹ�õ���
		private Department department=new Department(); 
		private List<Department> depall;
		private List<Department> dep;
		private String result;
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		@Override
		public Department getModel() {
			
			return department;
		}
		//Struts��Spring���Ϲ����еİ������Զ�ע��ҵ�����
		private DeptService deptService;

		public void setDeptService(DeptService deptService) {
			this.deptService = deptService;
		}
		//������Ʒ��ִ�з���:save
		public String save(){
			System.out.println("Action�е�save����ִ����...");
			deptService.save(department);
			return NONE;
		}
		public String delete(){
			System.out.println("Action�е�delete����ִ����...");
			deptService.delete(department);
			return NONE;
		}
		public String update(){
			System.out.println("Action�е�update����ִ����...");
			deptService.update(department);
			return NONE;
		}
		public String quert(){
			System.out.println("Action�е�query����ִ����...");
			System.out.println(department.getDname() == null || department.getDname().length() <= 0);
			dep=deptService.quert(department);
			result=listToJson.listToJson(dep);
			System.out.println(result);
			return SUCCESS;	
		}

		public String quertByAll(){
			System.out.println("Action�е�byall����ִ����...");
			depall=deptService.queryByAll();
			result=listToJson.listToJson(depall);
			System.out.println(result);
			return SUCCESS;
		}
	}
