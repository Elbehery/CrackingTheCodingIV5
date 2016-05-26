package designpattern.adapterPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;


    public void play(String audioType, String fileName) {
        advancedMediaPlayer = AdvancedMediaPlayerFactory.createAdvancedMediaPlayer(audioType);

        if (audioType.toLowerCase().equals("mp4"))
            advancedMediaPlayer.playMP4(fileName);
        else if (audioType.toLowerCase().equals("vlc"))
            advancedMediaPlayer.playVLC(fileName);

        else
            System.out.println("NOT SUPPORTED");
    }
}
