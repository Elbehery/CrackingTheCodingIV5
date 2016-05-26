package designpattern.adapterPattern;

/**
 * Created by mustafa on 03.04.16.
 */
public class Tester {

    public static void main(String[] args) {


        AudioPlayer audioPlayer = new AudioPlayer(new MediaAdapter());

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
