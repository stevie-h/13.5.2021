package com.example.demo;

//exercise 10
//ex10

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecialDaysController
{
    private static SpecialDayDAO SDD = new SpecialDayDAO("jdbc:sqlite:D:\\SQLiteDB\\calendar140521.db");

    @GetMapping("/SpecialDay")
    public List<SpecialDayPOJO> getSpecialDays()
    {
        return SDD.getAllSpecialDays();
    }


    @GetMapping("/SpecialDay/{id}")
    public SpecialDayPOJO getSpecialDayById(@PathVariable("id") int id)
    {
        return SDD.getSpecialHolidayById(id);
    }

    @PostMapping("/SpecialDay")
    public String addSpecialDay(@RequestBody SpecialDayPOJO SDP)
    {
        SDD.updateSpecialDay(String.format(
                "INSERT INTO Special_Days (Name, Day, Month) VALUES ('%s', %d, %d)",
                SDP.name, SDP.day, SDP.month));
        return "Special Day added";
    }

    @PutMapping("/SpecialDay/{id}")
    public String updateSpecialDayByID(@PathVariable("id") int id, @RequestBody SpecialDayPOJO update)
    {
        SDD.updateSpecialDay(String.format(
                "UPDATE Special_Days set Name = '%s', Day = %d, Month = %d WHERE id = %d",
                update.name, update.day, update.month, id));
        return "Special Day updated";
    }

    @DeleteMapping("/SpecialDay/{id}")
    public String deleteSpecialDayById(@PathVariable("id") int id)
    {
        SDD.updateSpecialDay(String.format("DELETE FROM Special_Days WHERE ID = %d", id));
        return "Special Day deleted!";
    }

}
