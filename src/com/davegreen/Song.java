package com.davegreen;

public class Song
{
    private String title;
    private double duration;
    
    public Song(String title, double duration)
    {
        this.title = title;
        this.duration = duration;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    @Override
    public String toString()
    {
        return this.title + ": " + this.duration;       // Normally in a toString method you would print out the various class fields, remember toString is an override method
                                                        // as it is inherited from the Object() class as are all classes in Java.
                                                        // It can be used as a quick way to print out an overview of any given classes fields and what they might be set to.
    }
}
