package lk.ijse.GroupchatApplication.model;

import lk.ijse.GroupchatApplication.dto.UserDto;
import lk.ijse.GroupchatApplication.utill.SqlUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static boolean existUser(String id, String name) throws SQLException {
        ResultSet rst = SqlUtil.execute("SELECT employeeId FROM user WHERE employeeId = ? OR username = ?",id,name);
        return rst.next();
    }

    public static boolean saveUser(UserDto dto) throws SQLException {
        ResultSet rst = SqlUtil.execute("INSERT INTO user VALUES (?,?,?)",dto.getEmployeeId(),dto.getUsername(),dto.getImage());
        return rst.next();
    }
}
