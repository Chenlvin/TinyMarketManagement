package stu.sll.main.common.constants;

/**
 * @Title: SqlConstant
 * @Author: Chenlvin
 * @Package: stu.sll.main.common.constants
 * @Description: Constant for sql
 */

public class SqlConstant {
    private static String SQL_URL = "jdbc:mysql://localhost:3306/market";
    private static String SQL_USER = "root";
    private static String SQL_PWD = "pwd";

    public static String getSqlUrl() {
        return SQL_URL;
    }

    public static String getSqlUser() {
        return SQL_USER;
    }

    public static String getSqlPwd() {
        return SQL_PWD;
    }

    public static void setSqlUrl(String sqlUrl) {
        SQL_URL = sqlUrl;
    }

    public static void setSqlUser(String sqlUser) {
        SQL_USER = sqlUser;
    }

    public static void setSqlPwd(String sqlPwd) {
        SQL_PWD = sqlPwd;
    }
}
