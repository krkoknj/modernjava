package adapter;

public class MP3 implements MediaPlayer, MediaPackage{
    @Override
    public void play(String filename) {
        System.out.println("Playing MP3 File " + filename);
    }

    @Override
    public void playFile(String filename) {
        System.out.println("Playing MP3 File " + filename);
    }
}
