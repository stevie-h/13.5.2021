package com.example.demo;

//exercise 10
//ex10

import java.sql.*;
import java.util.ArrayList;


public class HolidayDAO
{
    private String m_conn;

    public HolidayDAO(String m_conn)
    {
        this.m_conn = m_conn;
    }


    public ArrayList<HolidayPOJO> getAllHolidays()
    {
        ArrayList<HolidayPOJO> HPOJO = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if (conn != null) {
                String sql = "SELECT * FROM Holidays";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    HolidayPOJO HP = new HolidayPOJO(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getInt("Day"),
                            rs.getInt("Month"),
                            rs.getInt("Length"));
                    HPOJO.add(HP);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return HPOJO;
    }

    public ArrayList<HolidayPOJO> getHoliday(String query)
    {
        ArrayList<HolidayPOJO> HPOJO = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if (conn != null) {
                String sql = query;

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    HolidayPOJO HP = new HolidayPOJO(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getInt("Day"),
                            rs.getInt("Month"),
                            rs.getInt("Length"));
                    HPOJO.add(HP);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return HPOJO;
    }

    public HolidayPOJO getHolidayById(int id)
    {
        ArrayList<HolidayPOJO> result = getHoliday("SELECT * FROM Holidays WHERE ID = " + id);
        if (result.size() > 0)
        {
            return result.get(0);
        }
        else
        {
            return null;
        }
    }

    public void updateHoliday(String query)
    {
        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if (conn != null) {
                String sql = query;

                Statement stmt = conn.createStatement();

                int result = stmt.executeUpdate(sql);
                System.out.println(result + " record updated.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
