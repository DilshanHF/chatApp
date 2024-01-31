package lk.ijse.GroupchatApplication.utill;

import lk.ijse.GroupchatApplication.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlUtil {
    public static <T>T execute(String sql,Object... ob) throws SQLException {//return type 2k thiyna hinda thami generic use krnne
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        for(int i=0; i< ob.length;i++){//parameters ena prmaneta set krnwa
            pstm.setObject((i+1),ob[i]);
        }

        if(sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();
        }else{
            return (T)(Boolean)(pstm.executeUpdate()>0);
        }
    }
}
