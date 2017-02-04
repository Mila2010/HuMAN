package com.example.human.model;

/**
 * Created by nesada on 1/28/17.
 */

public class Parks {

    private String location;

    private String name;

    private String type;

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [location = "+location+", name = "+name+", type = "+type+"]";
    }
}