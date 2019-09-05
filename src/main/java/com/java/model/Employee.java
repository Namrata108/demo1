package com.java.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Employee.class)
public class Employee {

		private String empName;
		private String empId;
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		public void setEmpId(String empId) {
			this.empId = empId;
		}
		public String getEmpName() {
			return empName;
		}
		public String getEmpId() {
			return empId;
		}
		@Override
		public String toString() {
			return "Employee [empName=" + empName + ", empId=" + empId + "]";
		}
		
}
