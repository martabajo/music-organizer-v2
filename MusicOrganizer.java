import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * realiza una impresion del listado de las canciones guardadas
     */
    public void listAllFiles()
    {
        int count = 1;
        for(String fileName : files)
        {
            System.out.println(count + ".-" +fileName);
            count++;
        }
    }

    /**
     * Metodo listMaching
     */
    public void listMaching(String searchString)
    {
        boolean existeCancion = false;
        for (String filename : files) {
            if (filename.contains(searchString)){
                System.out.println(filename);
                existeCancion = true;
            }
        }

        if (existeCancion == false)
        {
            System.out.println("El archivo no existe");
        }
    }

    public void playMusic(String artista)
    {
        for (String buscar : files) {
            if (buscar.contains(artista))
            {
                player.playSample(buscar); 
            }
        }
    }

    public int findFirst(String searchString)
    {
        int index = 0;
        boolean found = false;
        int sizeArray = files.size(); //segunda parte del ejercicio, crear una variable local.
        while(!found && index < sizeArray)
        {
            String fileName = files.get(index); //variable local
            if(fileName.contains(searchString)) 
            {
                found = true;
            }
            else
            {
                index = index + 1;
            }
        }
        if(!found)
        {
            index = index - 1;
        }
        return index;
    }
}
