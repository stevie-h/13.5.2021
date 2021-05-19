package com.example.demo;

//swagger: http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

//exercise 10
//ex10

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HolidaysController
{
    private static HolidayDAO HDAO = new HolidayDAO("jdbc:sqlite:D:\\SQLiteDB\\calendar140521.db");

    @GetMapping("/Holiday")
    public List<HolidayPOJO> getHolidays()
    {
        return HDAO.getAllHolidays();
    }

    @GetMapping("/Holiday/{id}")
    public HolidayPOJO getHolidayById(@PathVariable("id") int id)
    {
        return HDAO.getHolidayById(id);
    }

    @PostMapping("/Holiday")
    public String addHoliday(@RequestBody HolidayPOJO HP)
    {
        HDAO.updateHoliday(String.format(
                "INSERT INTO Holidays (Name, Day, Month, Length) VALUES ('%s', %d, %d, %d)",
                HP.name, HP.day, HP.month, HP.length));
        return "Holiday added";
    }

    @PutMapping("/Holiday/{id}")
    public String updateHolidayById(@PathVariable("id") int id, @RequestBody HolidayPOJO update)
    {
        HDAO.updateHoliday(String.format(
                "UPDATE Holidays set Name = '%s', Day = %d, Month = %d, Length = %d WHERE id = %d",
                update.name, update.day, update.month, update.length, id));
        return "Holiday updated!";
    }

    @DeleteMapping("/Holiday/{id}")
    public String deleteHolidayById(@PathVariable("id") int id)
    {
        HDAO.updateHoliday(String.format("DELETE FROM Holidays WHERE ID = %d", id));
        return "Holiday deleted!";
    }


}
