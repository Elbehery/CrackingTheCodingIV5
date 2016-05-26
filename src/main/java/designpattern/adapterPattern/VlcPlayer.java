package designpattern.adapterPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    public void playVLC(String fileName
    ) {
        System.out.println("VLC");
    }

    public void playMP4(String fileName) {

        //System.out.println("UNSUPPORTED");
    }
}
