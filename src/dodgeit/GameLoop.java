
package dodgeit;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
/**
 *
 * @author juho
 */
public class GameLoop extends LoopTemplate{
    boolean quitBoolean = false;
    private long small = 9223372036854775807L;
    private long big = -9223372036854775808L;
    
    public GameLoop(DodgeIt mainGame) {
        super(mainGame);
    }
    
    @Override
    public void run(){
        while (quitBoolean == false){
            draw();
            System.out.println("moved to game  " + (big - small));
            quitBoolean = true;
        }
    }
    
    private void draw() {
        Display.update();
    }
    
}
