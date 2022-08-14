package login;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
public class LoginAction extends ActionSupport {
    String act;
    private String uname = "";
    private String rename = "";
    private int rid;
    private String rname = "";
    private String rpassword = "";
    private String name = "";
    private String password = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRid() {
        return rid;
    }
    public void setRname(String rname) {
        this.rname = rname;
    }
    public String getRname() {
        return rname;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }
    public String getRpassword() {
        return rpassword;
    }
    public void setRid(int rid) {
        this.rid = rid;
    }


    //    public void validate(){
//        if(uname.isEmpty())
//        {
//            addFieldError("uname","uname cannot be blank");
//        }
//    }
    public String execute() {
        if ("".equals(uname) || "".equals(password))
            return "error";
        else {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Guru@1508");
                System.out.println("connected succesfully");
                String Q1 = "insert into login (name,password) values (?,?)";
                PreparedStatement ps = connection.prepareStatement(Q1);
                ps.setString(1, uname);
                ps.setString(2, password);
                ps.executeUpdate();
                System.out.println("data inserted ");
                return "success";
            } catch (Exception e) {
                System.out.println(e);
                return "error";

            }
        }

    }

    public String display() {
        if ("".equals(name))
            return "error";
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Guru@1508");
                System.out.println("connected successfully");
                String Q = "select * from login where name=?";
                PreparedStatement ps = connection.prepareStatement(Q);
                ps.setString(1,name);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                        rid = rs.getInt(1);
                        if(rid==0)
                            act="error";
                        else
                            act="display";
                        rname = rs.getString(2);
                        rpassword = rs.getString(3);
                        setRname(rname);
                        setRpassword(rpassword);
                        setRid(rid);
                }
                    return act;
            } catch (Exception e) {
                System.out.println(e);
                return "error";
            }
        }
    }
    public String remove() {

        if ("".equals(rename) )
            return "error";
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Guru@1508");
                System.out.println("connected successfully");
                String Q = "delete from login where name='"+rename+"'";
                Statement ps = connection.createStatement();
                ps.executeUpdate(Q);
                return "remove";
            } catch (Exception e) {
                System.out.println(e);
                return "error";
            }
        }

    }
}








