package designpattern.adapterPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    public AudioPlayer(MediaAdapter mediaAdapter) {
        this.mediaAdapter = mediaAdapter;
    }

    public void play(String audioType, String fileName) {

        if (audioType.toLowerCase().equals("mp3"))
            System.out.println("MP3 Played");
        else
            mediaAdapter.play(audioType, fileName);
    }
}
