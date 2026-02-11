package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Entity.UserEntity;
import com.Util.UserUtil;

public class UserDao {

	Connection con = UserUtil.GetConnection();

	public void saveUser(UserEntity user) {
		try {
			PreparedStatement pst = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
			pst.setInt(1, user.getId());
			pst.setString(2, user.getName());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setString(5, user.getGender());
			pst.setString(6, user.getAddress());

			pst.execute();

			System.out.println("\n\nUser Saved Successfully....");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

}
