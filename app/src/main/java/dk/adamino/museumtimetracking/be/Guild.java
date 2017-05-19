package dk.adamino.museumtimetracking.be;

/**
 * Created by gta1 on 12-05-2017.
 */

public class Guild {

    private String mName;

    private String mDescription;

    public Guild(String name, String description) {
        mName = name;
        mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    @Override
    public String toString() {
        return mName;
    }
}
