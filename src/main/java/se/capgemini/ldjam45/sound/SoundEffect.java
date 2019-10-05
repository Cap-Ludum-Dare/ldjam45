package se.capgemini.ldjam45.sound;

// This class originates from https://www.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html
// The only major change we have done is to add the sounds we want to use, as enums.

import java.io.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.*;

/**
 * This enum encapsulates all the sound effects of a game, so as to separate the sound playing
 * codes from the game codes.
 * 1. Define all your sound effect names and the associated wave file.
 * 2. To play a specific sound, simply invoke SoundEffect.SOUND_NAME.play().
 * 3. You might optionally invoke the static method SoundEffect.init() to pre-load all the
 *    sound files, so that the play is not paused while loading the file for the first time.
 * 4. You can use the static variable SoundEffect.volume to mute the sound.
 */
public enum SoundEffect {
    DYING("dying.wav"),
    EXPLOSION("explosion.wav"),
    HIT("hit.wav"),
    JUMP("jump.wav"),
    LASER("laser.wav"),
    PICK("pick.wav"),
    PICKUP("pickup.wav"),
    SELECT("select.wav"),
    WALKING("walking.wav");

    // Nested class for specifying volume
    public static enum Volume {
        MUTE, LOW, MEDIUM, HIGH
    }

    public static Volume volume = Volume.LOW;

    // Each sound effect has its own clip, loaded with its own sound file.
    private Clip clip;

    // Constructor to construct each element of the enum with its own sound file.
    SoundEffect(String soundFileName) {
        try {
            // Use URL (instead of File) to read from disk and JAR.
            URL url = this.getClass().getClassLoader().getResource(soundFileName);
            // Set up an audio input stream piped from the sound file.
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            // Get a clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Play or Re-play the sound effect from the beginning, by rewinding.
    public void play() {
        if (volume != Volume.MUTE) {
            if (clip.isRunning()) {
                clip.stop();   // Stop the player if it is still running
            }
            clip.setFramePosition(0); // rewind to the beginning
            clip.start();     // Start playing
        }
    }

    // Optional static method to pre-load all the sound files.
    static void init() {
        values(); // calls the constructor for all the elements
    }
    
    public static void test() {
		SoundEffect.DYING.play();
		sleep (2);
		SoundEffect.EXPLOSION.play();
		sleep (2);
		SoundEffect.HIT.play();
		sleep (2);
		SoundEffect.JUMP.play();
		sleep (2);
		SoundEffect.LASER.play();
		sleep (2);
		SoundEffect.PICK.play();
		sleep (2);
		SoundEffect.PICKUP.play();
		sleep (2);
		SoundEffect.SELECT.play();
		sleep (2);
		SoundEffect.WALKING.play();
    }
    
	private static void sleep(int seconds) {
		try
		{
			TimeUnit.SECONDS.sleep(seconds);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
}