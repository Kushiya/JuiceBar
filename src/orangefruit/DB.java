

package orangefruit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
private static Connection con;
public static Connection connect() throws Exception{

    Class.forName("com.mysql.jdbc.Driver").newInstance();

    String url="jdbc:mysql://localhost:3306/OrangeFruitDB";

    con=DriverManager.getConnection(url,"root","123");

return con;
}


public void putdata (String sql)throws Exception{

    Statement st=connect().createStatement();
    st.executeUpdate(sql);

}

public ResultSet getdata(String sql) throws Exception{

    Statement st=connect().createStatement();
    ResultSet r=st.executeQuery(sql);
    return r;
}



}
