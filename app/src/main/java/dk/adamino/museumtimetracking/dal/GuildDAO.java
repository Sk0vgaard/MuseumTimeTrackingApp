package dk.adamino.museumtimetracking.dal;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dk.adamino.museumtimetracking.be.Guild;

/**
 * Created by gta1 on 12-05-2017.
 */

public class GuildDAO {

    private DBConnectionManager mDBConnectionManager;

    public GuildDAO() {
        mDBConnectionManager = new DBConnectionManager();
    }

    /**
     * Get all active guilds from the DB
     * @return
     */
    public List<Guild> getAllActiveGuilds() {
        List<Guild> activeGuilds = new ArrayList<>();

        String sql = "SELECT * FROM Guild";

        try (Connection con = mDBConnectionManager.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                activeGuilds.add(getOneGuild(rs));
            }

        } catch (Exception ex) {
            Log.d("Error", ex.getMessage());
        }
        return activeGuilds;
    }

    /**
     * Get one guild from the resultset
     * @param rs
     * @return
     * @throws SQLException
     */
    private Guild getOneGuild(ResultSet rs) throws SQLException {
        String name = rs.getString("Name");
        String description = rs.getString("Description");

        return new Guild(name, description);
    }
}
