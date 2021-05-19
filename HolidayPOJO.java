package com.example.demo;

//exercise 10
//ex10


import java.io.Serializable;

public class HolidayPOJO implements Serializable
{
    protected int id;
    protected String name;
    protected int day;
    protected int month;
    protected int length;

    public HolidayPOJO()
    {
    }

    public HolidayPOJO(int id, String name, int day, int month, int length)
    {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.length = length;
    }


    @Override
    public String toString()
    {
        return "Holiday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", length=" + length +
                '}';
    }


}
