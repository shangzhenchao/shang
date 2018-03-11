package cn.ssh.DeptServiceImpl;

import java.util.List;

import cn.ssh.DeptDao.DeptDao;
import cn.ssh.DeptDomain.Department;
import cn.ssh.DeptService.DeptService;

public class DeptServiceImpl implements DeptService {

		//ҵ���ע��DAO����
		private DeptDao deptDao;

		public void setDeptDao(DeptDao deptDao) {
			this.deptDao = deptDao;
		}
		//ҵ��㱣����Ʒ�ķ���
		public void save(Department department) {
			System.out.println("Service�е�save����ִ����...");
			deptDao.save(department);
			
		}
		public void delete(Department department) {
			System.out.println("Service�е�delete����ִ����...");
			deptDao.delete(department);
			
		}
		public void update(Department department) {
			System.out.println("Service�е�update����ִ����...");
			deptDao.update(department);
			
		}
		public List<Department> quert(Department department) {
			System.out.println("Service�е�id����ִ����...");
			return  deptDao.quert(department);

		}
		
		public List<Department> queryByAll() {
			System.out.println("Service�е�all����ִ����...");
			return  deptDao.queryByAll();
		}
}
