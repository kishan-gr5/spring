package com.customer.servlet;

import java.io.Serializable;

public class Customer implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
		private String name;
		private String address;
		private String mobile;
		private String emailid;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}

	}


