package se.capgemini.ldjam45.sound;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class BackgroundMusic implements Runnable {

    // Code for changing volume, from http://www.jpct.net/forum2/index.php?topic=1295.0
    /**
     * Resets playback volume to the correct level.
     */
    static int CHANGE_VOLUME = 7;
    static int WAIT_TIME = 1000; // milliseconds
    public static void resetGain(Sequencer sequencer, Synthesizer synthesizer)
    {
        float gain = 0.1f;

        // make sure the value for gain is valid (between 0 and 1)
        if( gain < 0.0f )
            gain = 0.0f;
        if( gain > 1.0f )
            gain = 1.0f;

        int midiVolume = (int) ( gain * 127.0f );
        if( synthesizer != null )
        {
            javax.sound.midi.MidiChannel[] channels = synthesizer.getChannels();
            for( int c = 0; channels != null && c < channels.length; c++ )
            {
                channels[c].controlChange( CHANGE_VOLUME, midiVolume );
            }
        }
        else if( sequencer != null && sequencer instanceof Synthesizer)
        {
            Synthesizer synthesizer2 = (Synthesizer) sequencer;
            javax.sound.midi.MidiChannel[] channels = synthesizer2.getChannels();
            for( int c = 0; channels != null && c < channels.length; c++ )
            {
                channels[c].controlChange( CHANGE_VOLUME, midiVolume );
            }
        }
        else
        {
            try
            {
                Receiver receiver = MidiSystem.getReceiver();
                ShortMessage volumeMessage= new ShortMessage();
                for( int c = 0; c < 16; c++ )
                {
                    volumeMessage.setMessage( ShortMessage.CONTROL_CHANGE, c,
                            CHANGE_VOLUME, midiVolume );
                    receiver.send( volumeMessage, -1 );
                }
            }
            catch( Exception e )
            {
                System.out.println("Error in resetGain");
            }
        }
    }

    @Override
    public void run() {
        // Midi files from https://www.fakemusicgenerator.com/

        // Code to play midi files inspired by https://gist.github.com/indy/360540
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            String[] songs = {"way", "closet", "road", "unity", "makeitup"};
            Random rand = new Random();
            int songIndex = -1;
            while(true) {
                int previous = songIndex;
                while (previous == songIndex) {
                    songIndex = rand.nextInt(songs.length);
                }
                String file = "./src/main/resources/midi/" + songs[songIndex] + ".mid";

                File midiFile = new File(file);
                if (!midiFile.exists() || midiFile.isDirectory() || !midiFile.canRead()) {
                    return;
                }

                sequencer.setSequence(MidiSystem.getSequence(midiFile));
                sequencer.start();
                Synthesizer synthesizer = MidiSystem.getSynthesizer();
                resetGain(sequencer, synthesizer);

                while (true) {
                    if (sequencer.isRunning()) {
                        try {
                            Thread.sleep(WAIT_TIME); // Check every second
                        } catch (InterruptedException ignore) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            // Commented out, since code never reached
            // Close the MidiDevice & free resources
            //sequencer.stop();
            //sequencer.close();
        } catch (MidiUnavailableException mue) {
            System.out.println("Midi device unavailable!");
        } catch (InvalidMidiDataException imde) {
            System.out.println("Invalid Midi data!");
        } catch (IOException ioe) {
            System.out.println("I/O Error!");
        }
    }
}
