/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DaoHelper {
    
    private static final String SELECT = "SELECT";
    private static final String UPDATE = "UPDATE";
    private static final String DELETE = "DELETE";
    private static final String INSERT = "INSERT";
    private static final String OTHERS = "OTHERS";

    public static Object execute(String SQL, Object obj, Object... para) {
        String queryType = checkQuery(SQL);

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            Class<?> myClass = obj.getClass();

//            for (Field field : obj.getClass().getDeclaredFields()) {
//                String name = field.getName();
//                System.out.print(name);
//                System.out.print(myClass.getField(name));
//                if(name.equalsIgnoreCase("string")){
//                }
//            }
            // get Query parameter
            if (SQL.contains("?")) {
                int paramCount = ps.getParameterMetaData().getParameterCount();
                int i = 0;
                while (++i <= paramCount) {
                    ps.setObject(i, para[i - 1]);
                }
            }
            if (queryType.equals(SELECT)) {
                ResultSet rs = ps.executeQuery();
                int i = 0;
                List<Object> list = new ArrayList<>();
                while (rs.next()) {
//                System.out.println(rs.getClass());
                    for (Method method : myClass.getDeclaredMethods()) {
                        String methodType = method.getName().substring(0, 3);
                        String methodName = method.getName().substring(3);
                        if (methodType.equals("set")) {
                            String paraName = method.getParameterTypes()[0].getSimpleName();
//                        Class<?> paramType = method.getParameterTypes()[0];
                            System.out.println(method);
//                        System.out.println(paramType);
//                        System.out.println(paraName);
                            try {
                                // get the right parameter name for the function
                                if (paraName.equalsIgnoreCase("integer")) {
                                    method.invoke(obj, rs.getInt(methodName));
                                } else if (paraName.equalsIgnoreCase("long")) {
                                    method.invoke(obj, rs.getLong(methodName));
                                } else if (paraName.equalsIgnoreCase("boolean")) {
                                    method.invoke(obj, rs.getBoolean(methodName));
                                } else if (paraName.equalsIgnoreCase("double")) {
                                    method.invoke(obj, rs.getDouble(methodName));
                                } else if (paraName.equalsIgnoreCase("float")) {
                                    method.invoke(obj, rs.getFloat(methodName));
                                } else if (paraName.equalsIgnoreCase("date")) {
                                    method.invoke(obj, rs.getDate(methodName));
                                } else if (paraName.equalsIgnoreCase("datetime")) {
                                    method.invoke(obj, rs.getTimestamp(methodName));
                                } else {
                                    method.invoke(obj, rs.getObject(methodName));
                                }
                            } catch (Exception e) {
//                            e.printStackTrace();
                            }
                        }
                    }
                    list.add(obj);
                }
                return list;
            } else {
                if (queryType.equals(DELETE) || queryType.equals(UPDATE)) {
                    if (!SQL.contains("?")) {
                        throw new Exception(queryType + " Query don't have any parameter! You Might " + queryType + " All the database");
                    }
                }
                if (queryType.equals(INSERT)) {
                    if (!SQL.contains("?")) {
                        throw new Exception(queryType + " Query don't have any parameter! Nothing to add");
                    }
                }
                ps.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            System.out.println(SQL);
            System.out.println(queryType + " Error: " + e.toString());
        }
        return obj;
    }

    public static Object execute(String SQL, Object obj) {
        return null;
    }

    

    private static int countQuestion(String SQL) {
        int count = 0;
        for (int i = 0; i < SQL.length(); i++) {
            if (SQL.charAt(i) == '?') {
                count++;
            }
        }
        return count;
    }

    private static String checkQuery(String SQL) {
        String SQLL = SQL.toUpperCase();
        if (SQLL.startsWith(SELECT)) {
            return SELECT;
        }
        if (SQLL.startsWith(UPDATE)) {
            return UPDATE;
        }
        if (SQLL.startsWith(DELETE)) {
            return DELETE;
        }
        if (SQLL.startsWith(INSERT)) {
            return INSERT;
        }
        return OTHERS;
    }
}
