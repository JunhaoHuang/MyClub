package com.MyClub.test;

import com.MyClub.Dao.AccountDao;
import com.MyClub.vo.Account;

public class daotest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountDao a = new AccountDao();
		Account s = a.queryAccountById("1");
		System.out.println(s.getUserType());
//		s.setAccountNum("111");
//		s.setUserType("Admin");
//		a.updateAccount(s);
	}

}
