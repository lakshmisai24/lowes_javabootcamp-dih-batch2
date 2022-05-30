package Jdbc;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        System.out.println("JDBC Demo...");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs=null;
        //Step 1 : Load Driver(my sql)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        }

        try {
            //Step 2 : Open connection to db
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctraining", "training", "training");
            System.out.println(con);
            System.out.println("Connected to Db Successfully");

            //Step 3 : Create Statement
            stmt = con.createStatement();
            String query="SELECT * FROM EMPLOYEE";


            //Step 4: Execute query
            rs= stmt.executeQuery(query);
            System.out.println("Query executed successfully :Query"+query);

            //step 5: Get The Result set
            System.out.println("Got Results-"+rs);
            System.out.println("Emp ID \t Name \t Age \t Designation \t Department \t Country" );
            while(rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                String Designation=rs.getString("designation");
                String Department=rs.getString("department");
                String Country=rs.getString("country");
                System.out.printf("%d  \t   %s   \t   %d  \t   %s  \t   %s  \t   %s   \n", id, name, age, Designation,Department,Country);
            }

        } catch (SQLException e) {
            System.out.println("Error unable to connect:" + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
                stmt.close();
                con.close();

            }
            catch (SQLException E){
                System.out.println("Error while closing the connections "+ E);
                E.printStackTrace();

            }
        }





    }
}
