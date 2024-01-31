package lk.ijse.GroupchatApplication.model;

import lk.ijse.GroupchatApplication.dto.UserDto;
import lk.ijse.GroupchatApplication.utill.SqlUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static boolean existUser(String employeeId,String username) throws SQLException {
        ResultSet rst = SqlUtil.execute("SELECT e_Id FROM user WHERE e_Id = ? or username = ?",employeeId,username);
        return rst.next();
    }

    public static boolean saveUser(UserDto dto) throws SQLException {
        return SqlUtil.execute("INSERT INTO user VALUES(?,?,?)",
                dto.getEmployeeId(),dto.getUsername(),dto.getImage());
    }
}
