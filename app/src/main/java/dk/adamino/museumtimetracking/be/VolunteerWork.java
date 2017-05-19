package dk.adamino.museumtimetracking.be;


import java.util.Date;

/**
 * Created by gta1 on 12-05-2017.
 */

public class VolunteerWork {

    private int volunteerID;
    private String guild;
    private Date date;
    private int hours;

    public VolunteerWork(int volunteerID, String guild, Date date, int hours) {
        this.volunteerID = volunteerID;
        this.guild = guild;
        this.date = date;
        this.hours = hours;
    }

    public int getVolunteerID() {
        return volunteerID;
    }

    public String getGuild() {
        return guild;
    }

    public Date getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }
}
