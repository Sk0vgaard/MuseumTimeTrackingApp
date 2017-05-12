package dk.adamino.museumtimetracking.bll;

import java.util.List;

import dk.adamino.museumtimetracking.be.Guild;
import dk.adamino.museumtimetracking.dal.GuildDAO;

/**
 * Created by gta1 on 12-05-2017.
 */

public class GuildManager {

    private GuildDAO mGuildDAO;

    public GuildManager() {
        mGuildDAO = new GuildDAO();
    }

    /**
     * Get all active guilds from the database
     * @return
     */
    public List<Guild> getAllActiveGuilds() {
        return mGuildDAO.getAllActiveGuilds();
    }
}
