package Structural.adapter;

// Old system interface
interface OldMediaPlayer {
    void playFile(String fileName);
}

// New system interface
interface NewMediaPlayer {
    void play(String fileType, String fileName);
}

// Implementation of the new media player
class AdvancedMediaPlayer implements NewMediaPlayer {
    @Override
    public void play(String fileType, String fileName) {
        System.out.println("Playing " + fileType + " file: " + fileName);
    }
}

// Adapter to make OldMediaPlayer work with NewMediaPlayer
class MediaPlayerAdapter implements OldMediaPlayer {
    private NewMediaPlayer newMediaPlayer;

    public MediaPlayerAdapter(NewMediaPlayer newMediaPlayer) {
        this.newMediaPlayer = newMediaPlayer;
    }

    @Override
    public void playFile(String fileName) {
        // Delegate the request to NewMediaPlayer
        newMediaPlayer.play("mp4", fileName);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        OldMediaPlayer player = new MediaPlayerAdapter(new AdvancedMediaPlayer());
        player.playFile("movie.mp4");
    }
}

