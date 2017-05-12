package dk.adamino.museumtimetracking.be;

/**
 * Created by gta1 on 12-05-2017.
 */

public abstract class Person {

    private String mFirstName;

    private String mLastName;

    private String mFullName;

    public Person(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
        mFullName = firstName + " " + lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getFullName() {
        return mFullName;
    }
}
