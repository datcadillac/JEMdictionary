package src.main;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {

    private static final String VOICENAME_kevin = "kevin16";

    public static void speak(String text) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        try {
            voice.setRate(130);// Setting the rate of the voice
            voice.setPitch(120);// Setting the Pitch of the voice
            voice.setVolume(5);// Setting the volume of the voice
            voice.speak(text);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
