package dk.adamino.museumtimetracking.gui.model;

import java.util.ArrayList;
import java.util.List;

import dk.adamino.museumtimetracking.be.Guild;
import dk.adamino.museumtimetracking.be.VolunteerWork;
import dk.adamino.museumtimetracking.bll.GuildManager;

/**
 * Created by gta1 on 12-05-2017.
 */

public class GuildModel {

    private GuildManager mGuildManager;

    private List<Guild> mActiveGuildsFromDB;

    public GuildModel() {
        mGuildManager = new GuildManager();
        mActiveGuildsFromDB = new ArrayList<>(mGuildManager.getAllActiveGuilds());
    }

    /**
     * Get all active guilds from the database
     * @return
     */
    public List<Guild> getActiveGuildsFromDB() {
        return mActiveGuildsFromDB;
    }

    /**
     * Document hours for volunteer
     * @param volunteerWork
     * @return
     */
    public boolean documentVolunteerHours(VolunteerWork volunteerWork) {
        return mGuildManager.documentHours(volunteerWork);
    }
}
