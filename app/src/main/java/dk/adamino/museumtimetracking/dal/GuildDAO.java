package dk.adamino.museumtimetracking.dal;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dk.adamino.museumtimetracking.be.Guild;
import dk.adamino.museumtimetracking.be.VolunteerWork;

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

    /**
     * Document volunteer work in the DB
     */
    public boolean documentHours(VolunteerWork volunteerWork) {
        String sql = "INSERT INTO VolunteerWork (VolunteerID, GuildName, Date, Hours)" +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = mDBConnectionManager.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, volunteerWork.getVolunteerID());
            ps.setString(2, volunteerWork.getGuild());
            //Using TimeStamp to get Date AND time!
            ps.setTimestamp(3, new java.sql.Timestamp(volunteerWork.getDate().getTime()));
            ps.setInt(4, volunteerWork.getHours());

            ps.executeUpdate();

            return true;

        } catch (Exception ex) {
            Log.d("Error", ex.getMessage());
        }
        return false;
    }
}
