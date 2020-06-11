/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamysql;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ChoiSiChang
 */
public class ConnectDB {
    private static ConnectDB instance = new ConnectDB();
    
    public static ConnectDB getInstance() {
		return instance;
	}
    public ConnectDB() {

	}
    
String jdbcUrl = "jdbc:mysql://34.64.100.137:3306/mytestlogin?serverTimezone=Asia/Seoul"; 
String dbId = "root"; // MySQL ê³ì 
<<<<<<< HEAD
String dbPw = "choi123"; // ë¹ë?ë²í¸
=======
String dbPw = "choi123"; // ë¹ë°ë²í¸
>>>>>>> master
Connection conn = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt2 = null;
ResultSet rs = null;
ResultSetMetaData rsmd = null;
String sql = "";
String sql2 = "";
String sql3 = "";
String returns ;
String returns2 ; 
String returns3;
ArrayList<String> titleList;
ArrayList<String> dateList;
ArrayList<String> contextList;

public String joindb(String id, String pwd, String name, String tel, String birth) {
    try{
<<<<<<< HEAD
        System.out.println("??¤?¸1");
        Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ??¼?´ë²? ? ?¬
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw); //  jdbcUrl, dbId,  dbPwê°? ?¤?´ê°?ë©´ë¨ db?°ê²?
        sql = "select id from login where id = ?";// ì¡°í 
        pstmt = conn.prepareStatement(sql);  //preparedstatement? sqlë¬? ë§¤ê°ë³??ë¡? ?£?
        pstmt.setString(1, id); // ? ??¼ë¯¸í° ?¤? 
        rs = pstmt.executeQuery(); //ì¿¼ë¦¬ë¬? ?¤? 
        if(rs.next()){
            if (rs.getString("id").equals(id)) { // ?´ë¯? ??´?ê°? ?? ê²½ì°
=======
        System.out.println("íì¤í¸1");
        Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ëë¼ì´ë² ì ì¬
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw); //  jdbcUrl, dbId,  dbPwê° ë¤ì´ê°ë©´ë¨ dbì°ê²°
        sql = "select id from login where id = ?";// ì¡°í 
        pstmt = conn.prepareStatement(sql);  //preparedstatementì sqlë¬¸ ë§¤ê°ë³ìë¡ ë£ì
        pstmt.setString(1, id); // ? íë¼ë¯¸í° ì¤ì 
        rs = pstmt.executeQuery(); //ì¿¼ë¦¬ë¬¸ ì¤í 
        if(rs.next()){
            if (rs.getString("id").equals(id)) { // ì´ë¯¸ ìì´ëê° ìë ê²½ì°
>>>>>>> master
		returns = "id";
	    } 
        }
        else{
<<<<<<< HEAD
            //ê°ì´ ??´? ê°??¥? ê²½ì°
            sql2 = "insert into login values(?,?,?,?,?)"; // ?½?
=======
            //ê°ì´ ìì´ì ê°ë¥í ê²½ì°
            sql2 = "insert into login values(?,?,?,?,?)"; // ì½ì
>>>>>>> master
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, id);
            pstmt2.setString(2, pwd);
            pstmt2.setString(3, name);
            pstmt2.setString(4, tel);
            pstmt2.setString(5, birth);
            pstmt2.executeUpdate();
            returns = "ok";
        }
        
    }catch(Exception e){
       e.printStackTrace();
    }
    finally{
        if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
        if (conn != null)try {conn.close();} catch (SQLException ex) {}
	if (pstmt2 != null)try {pstmt2.close();} catch (SQLException ex) {}
	if (rs != null)try {rs.close();} catch (SQLException ex) {}
<<<<<<< HEAD
        System.out.println("??¤?¸2");
=======
        System.out.println("íì¤í¸2");
>>>>>>> master
    }
    return returns;
}

public String logindb(String id, String pwd){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        sql = "select id,pwd from login where id = ? and pwd=?";// ì¡°í
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
	pstmt.setString(2, pwd);
        rs = pstmt.executeQuery();
        if (rs.next()){
            if (rs.getString("id").equals(id) && rs.getString("pwd").equals(pwd)){
<<<<<<< HEAD
                returns2 = "true";// ë¡ê·¸?¸ ê°??¥
            }
            else{
                returns2 = "false"; //ë¡ê·¸?¸ ?¤?¨
            }
        } else {
            returns2 = "noId"; // ??´? ?? ë¹ë?ë²í¸ ì¡´ì¬ X
=======
                returns2 = "true";// ë¡ê·¸ì¸ ê°ë¥
            }
            else{
                returns2 = "false"; //ë¡ê·¸ì¸ ì¤í¨
            }
        } else {
            returns2 = "noId"; // ìì´ë ëë ë¹ë°ë²í¸ ì¡´ì¬ X
>>>>>>> master
        }
        
    }catch(Exception e){
      e.getMessage();
      System.out.println("ë¬¸ì¬ë°ì!");
    } finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
	if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
	if (conn != null)try {conn.close();} catch (SQLException ex) {}
    }
    return returns2;
}

public String writepost(String id, String date, String title, String context) {
    try{
<<<<<<< HEAD
        System.out.println("??¤?¸1");
        Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ??¼?´ë²? ? ?¬
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw); //  jdbcUrl, dbId,  dbPwê°? ?¤?´ê°?ë©´ë¨ db?°ê²?
      
            sql3 = "insert into writepost values(?,?,?,?)"; // ?½?
=======
        System.out.println("íì¤í¸1");
        Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ëë¼ì´ë² ì ì¬
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw); //  jdbcUrl, dbId,  dbPwê° ë¤ì´ê°ë©´ë¨ dbì°ê²°
      
            sql3 = "insert into writepost values(?,?,?,?)"; // ì½ì
>>>>>>> master
            pstmt = conn.prepareStatement(sql3);
            pstmt.setString(1, id);
            pstmt.setString(2, date);
            pstmt.setString(3, title);
            pstmt.setString(4, context);
            pstmt.executeUpdate();
            returns3 = "Save success!";
       
    }catch(Exception e){
       e.printStackTrace();
    }
    finally{
        if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
        if (conn != null)try {conn.close();} catch (SQLException ex) {}
	if (rs != null)try {rs.close();} catch (SQLException ex) {}
<<<<<<< HEAD
        System.out.println("??¤?¸2");
=======
        System.out.println("íì¤í¸2");
>>>>>>> master
    }
    return returns3;
}

public String getwritecount() {
    try{
<<<<<<< HEAD
        System.out.println("??¤?¸1");
        Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ??¼?´ë²? ? ?¬
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw); //  jdbcUrl, dbId,  dbPwê°? ?¤?´ê°?ë©´ë¨ db?°ê²?
      
            sql3 = "select * from writepost"; // ??´ë¸ì ?? ì»¬ë¼ ê°??
=======
        System.out.println("íì¤í¸1");
        Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC ëë¼ì´ë² ì ì¬
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw); //  jdbcUrl, dbId,  dbPwê° ë¤ì´ê°ë©´ë¨ dbì°ê²°
      
            sql3 = "select * from writepost"; // íì´ë¸ì ìë ì»¬ë¼ ê°¯ì
>>>>>>> master
            pstmt = conn.prepareStatement(sql3);
            rs = pstmt.executeQuery();
            rsmd = rs.getMetaData();
            returns3 = String.valueOf(rsmd.getColumnCount());
       
    }catch(Exception e){
       e.printStackTrace();
    }
    finally{
        if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
        if (conn != null)try {conn.close();} catch (SQLException ex) {}
	if (rs != null)try {rs.close();} catch (SQLException ex) {}
<<<<<<< HEAD
        System.out.println("??¤?¸2");
=======
        System.out.println("íì¤í¸2");
>>>>>>> master
    }
    return returns3;
}

public String findid(String tel, String birth){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        sql = "select id from login where tel = ? and birth=?";// ì¡°í
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, tel);
	pstmt.setString(2, birth);
        rs = pstmt.executeQuery();
        if (rs.next()){
<<<<<<< HEAD
                returns2 = "your ID : "+rs.getString("id");// ?±ê³?
            }
            else{
                returns2 = "false"; //?¤?¨
=======
                returns2 = "your ID : "+rs.getString("id");// ì±ê³µ
            }
            else{
                returns2 = "false"; //ì¤í¨
>>>>>>> master
            }
        
        
    }catch(Exception e){
      e.getMessage();
      System.out.println("ë¬¸ì¬ë°ì!");
    } finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
	if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
	if (conn != null)try {conn.close();} catch (SQLException ex) {}
    }
    return returns2;
}

public String findpwd(String id,String tel, String birth){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        sql = "select id,tel,birth from login where id=? and tel = ? and birth=?";// ì¡°í
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.setString(2, tel);
	pstmt.setString(3, birth);
        rs = pstmt.executeQuery();
        if (rs.next()){
<<<<<<< HEAD
                returns2 = "ok";// ?±ê³?      
           
        } else{
                returns2 = "false"; //?¤?¨
=======
                returns2 = "ok";// ì±ê³µ      
           
        } else{
                returns2 = "false"; //ì¤í¨
>>>>>>> master
            }
        
    }catch(Exception e){
      e.getMessage();
      System.out.println("ë¬¸ì¬ë°ì!");
    } finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
	if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
	if (conn != null)try {conn.close();} catch (SQLException ex) {}
    }
    return returns2;
}

public String changepwd(String id,String pwd){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, dbId, dbPw);
        sql = "UPDATE login SET pwd=? WHERE id=?";// ì¡°í
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, pwd);
        pstmt.setString(2, id);
        pstmt.executeUpdate();
       
        out.print("Successful change!");
<<<<<<< HEAD
        String returns3 = "Successful change!";// ?±ê³?
=======
        String returns3 = "Successful change!";// ì±ê³µ
>>>>>>> master

    }catch(Exception e){
      e.getMessage();
      System.out.println("ë¬¸ì¬ë°ì!");
    } finally {if (rs != null)try {rs.close();} catch (SQLException ex) {}
	if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
	if (conn != null)try {conn.close();} catch (SQLException ex) {}
    }
    return returns3;
}




        
}
