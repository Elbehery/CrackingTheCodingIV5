package designpattern.adapterPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class MP4Player implements AdvancedMediaPlayer {

    public void playVLC(String fileName) {
        //System.out.println("UNSUPPORTED");
    }

    public void playMP4(String fileName) {

        System.out.println("MP4");
    }
}
