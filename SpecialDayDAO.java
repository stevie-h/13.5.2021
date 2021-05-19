package com.example.demo;

//exercise 10
//ex10

import java.sql.*;
import java.util.ArrayList;


public class SpecialDayDAO
{

    private String m_conn;

    public SpecialDayDAO(String m_conn)
    {
        this.m_conn = m_conn;
    }


    public ArrayList<SpecialDayPOJO> getAllSpecialDays()
    {
        ArrayList<SpecialDayPOJO> SDPOJO = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if (conn != null) {
                String sql = "SELECT * FROM Special_Days";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    SpecialDayPOJO SP = new SpecialDayPOJO(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getInt("Day"),
                            rs.getInt("Month"));
                    SDPOJO.add(SP);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return SDPOJO;
    }

    public ArrayList<SpecialDayPOJO> getSpecialDay(String query)
    {
        ArrayList<SpecialDayPOJO> SDPOJO = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn))
        {
            if (conn != null) {
                String sql = query;

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    SpecialDayPOJO SP = new SpecialDayPOJO(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getInt("Day"),
                            rs.getInt("Month"));
                    SDPOJO.add(SP);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return SDPOJO;
    }

    public SpecialDayPOJO getSpecialHolidayById(int id)
    {
        ArrayList<SpecialDayPOJO> result = getSpecialDay("SELECT * FROM Special_Days WHERE ID = " + id);
        if (result.size() > 0)
        {
            return result.get(0);
        }
        else
        {
            return null;
        }
    }

    public void updateSpecialDay(String query)
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
