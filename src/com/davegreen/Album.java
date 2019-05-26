package com.davegreen;


import java.util.ArrayList;
import java.util.LinkedList;                                                    // This has now become redundant due to the fact that we changed all the LinkedLists to just Lists.
import java.util.List;

public class Album
{
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    
    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }
    
    public boolean addSong(String title, double duration)
    {
        if(findSong(title) == null)
        {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }
    
    private Song findSong(String title)
    {
        for(Song checkedSong: this.songs)
        {
            if(checkedSong.getTitle().equals(title))
            {
                return checkedSong;
            }
        }
        return null;
    }
    
    public boolean addToPlaylist(int trackNumber, List<Song> playlist)              // A small change has been made here, in the parameters we have changed the LinkedList to List, it has
    {                                                                               // automatically imported the required package.
        int index = trackNumber - 1;
        
        if((index > 0) && (index <= this.songs.size()))
        {
            playlist.add(this.songs.get(index));
            return true;
        }
    
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }
    
    public boolean addToPlaylist(String title, List<Song> playlist)                 // Here we have once again change LinkedList to just simply List
    {
        Song checkedSong = findSong(title);
        
        if(checkedSong != null)
        {
            playlist.add(checkedSong);
            return true;
        }
    
        System.out.println("The song " + title + " is not in this album.");
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
