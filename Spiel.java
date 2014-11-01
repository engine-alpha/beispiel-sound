import ea.*;

/**
 * Dieses Spiel steuert nur das Abspielen einer Sounddatei.
 * 
 * @author Michael Andonie
 */
public class Spiel
extends Game {
    //
    
    /**
     * Die Sounddatei, die dieses Spiel steuert.
     */
    private Sound music;
    
    /**
     * Ist dann <code>true</code>, wenn der Sound gerade 
     * abgespielt wird. Sonst <code>false</code>.
     */
    private boolean play;
    
    public Spiel() {
        super(500,500, "Sound-Demo");
        
        //Lade den Sound ein:
        //  Sound erstellt von Michael Andonie
        music = new Sound("music.mp3");
        
        //starte das abspielen des Sounds
        music.play();
        play = true;
    }
    
    /**
     * Hier werden die Tastenbefehle behandelt:
     * P-Taste: Pause-Button
     * S-Taste: Stoppt die Wiedergabe
     * N-Taste: Startet die Wiedergabe neu
     */
    public void tasteReagieren(int code) {
        switch(code) {
            case Taste.P:
                //Pause-Button
                
                if(play) {
                    //Sound läuft gerade -> pausieren
                    music.pause();
                    play = false;
                } else {
                    //Sound läuft gerade nicht -> un-pausieren
                    music.unpause();
                    play = true;
                }
                
                break;
                
            case Taste.S:
                //Stop-Button
                music.stop();
                break;
                
            case Taste.N:
                //Neustart-Button
                
                //Musik provisorisch anhalten.
                music.stop();
                
                //Musik neu starten
                music.play();
                break;
        }
    }
}
