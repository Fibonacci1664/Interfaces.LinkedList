package com.davegreen;

import java.util.*;

public class Main
{
    
    private static List<Album> albums = new ArrayList<>();                          // Here we have once again change LinkedList to just simply List

    public static void main(String[] args)
    {
	   Album album = new Album("Stormbringer", "Deep Purple");
	   album.addSong("Stormbringer", 4.06);
	   album.addSong("Love don't mean a thing", 4.22);
	   album.addSong("Holy man", 4.30);
	   album.addSong("Hold on", 5.06);
	   album.addSong("Lady double dealer", 3.21);
	   album.addSong("You can't do it right", 6.23);
	   album.addSong("High ball shooter", 4.27);
	   album.addSong("The gypsy", 4.02);
	   album.addSong("Soldier of fortune", 3.13);
	   
	   albums.add(album);
	   
	   album = new Album("For those about to rock", "AC/DC");
	   album.addSong("For those about to rock", 5.44);
	   album.addSong("I put the finger on you", 3.25);
	   album.addSong("Lets go", 3.45);
	   album.addSong("Inject the venom", 3.33);
	   album.addSong("Snowballed", 4.51);
	   album.addSong("Evil walks", 3.45);
	   album.addSong("C.O.D.", 5.25);
	   album.addSong("Breaking the rules", 5.32);
	   album.addSong("Night of the long knives", 5.12);
	   
	   albums.add(album);
    
        List<Song> playlist = new Vector<>();                                                   // Here we have once again change LinkedList to just simply List but in addition have also
                                                                                                // changed the new object to a Vector just to prove all the varying interfaces that are.
        albums.get(0).addToPlaylist("You can't do it right", playlist);                    // interconnected and can be used interchangeably.
        albums.get(0).addToPlaylist("Holy man", playlist);
        albums.get(0).addToPlaylist("Speed king", playlist);    // Does not exist.
        
        albums.get(0).addToPlaylist(9, playlist);
        albums.get(1).addToPlaylist(8, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(24, playlist);  // No track 24.
        
        play(playlist);
    }
    
    private static void play(List<Song> playlist)                                               // Here we have once again change LinkedList to just simply List
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        
        if(playlist.size() == 0)
        {
            System.out.println("No songs in playlist");
            return;
        }
        else
        {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        
        while(!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();
            
            switch(action)
            {
                case 0:
                    System.out.println("Playlist compelte.");
                    quit = true;
                    break;
                case 1:
                    if(!forward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now playing " + listIterator.next().toString());
                    }
                    else
                    {
                        System.out.println("We have reached the end of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }
                    else
                    {
                        System.out.println("We are at the start of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        }
                        else
                        {
                            System.out.println("We are the start of the list");
                        }
                    }
                    else
                    {
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        }
                        else
                        {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() > 0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing " + listIterator.next());
                        }
                        else if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }
    
    private static void printMenu()
    {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist");
    }
    
    private static void printList(List<Song> playList)                                                // Here we have once again change LinkedList to just simply List
    {
        Iterator<Song> iterator = playList.iterator();
    
        System.out.println("=======================================");
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("=======================================");
    }
}
