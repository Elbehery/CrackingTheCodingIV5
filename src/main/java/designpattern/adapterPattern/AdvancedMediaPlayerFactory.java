package designpattern.adapterPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class AdvancedMediaPlayerFactory {

    public static AdvancedMediaPlayer createAdvancedMediaPlayer(String audioType) {

        AdvancedMediaPlayer advancedMediaPlayer = null;

        if (audioType.toLowerCase().equals("vlc"))
            advancedMediaPlayer = new VlcPlayer();
        else if (audioType.toLowerCase().equals("mp4"))
            advancedMediaPlayer = new MP4Player();

        return advancedMediaPlayer;
    }
}
