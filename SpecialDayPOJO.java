package com.example.demo;

//exercise 10
//ex10


import java.io.Serializable;

public class SpecialDayPOJO implements Serializable
{

    protected int id;
    protected String name;
    protected int day;
    protected int month;

    public SpecialDayPOJO()
    {
    }

    public SpecialDayPOJO(int id, String name, int day, int month)
    {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
    }

    @Override
    public String toString()
    {
        return "SpecialDayPOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                '}';
    }

}
