
package dodgeit;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
/**
 *
 * @author juho
 */
public class MenuLoop extends LoopTemplate {
    boolean quitBoolean = false;
    int mouseX, mouseY, eventKey;
    long time, timeNew, dTime;
    
    int coordinate = 500;
    
    public MenuLoop(DodgeIt mainGame){
        super(mainGame);
    }
    
    @Override
    public void run(){
        time = System.nanoTime();
        timeNew = time;
        while (quitBoolean == false){
            handleInput();
            draw();
            time();
            if (Display.isCloseRequested() == true){
                quitBoolean = true;
            }
            Display.sync(statics.FRAMERATE);
        }
    }
    
    private void handleInput(){
        mouseX = Mouse.getX();
        mouseY = Mouse.getY();
//        System.out.println("X: " + mouseX + ", Y: " + mouseY);
        while (Keyboard.next()) {
            eventKey = Keyboard.getEventKey();
            switch (eventKey) {
                case Keyboard.KEY_ESCAPE:
                    quitBoolean = true;
                    break;
                case Keyboard.KEY_RETURN:
                    game.addToStack(statics.state.GAME_STATE);
                    quitBoolean = true;
                    break;
                case Keyboard.KEY_SPACE:
                    handleSpace();
                    break;
            }
        }
    }
    
    private void draw() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        
        GL11.glColor3f(0.5f,0.5f,1.0f);
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(100, 100);
            GL11.glVertex2f(100, 250);
            GL11.glVertex2f(300, 300);
            GL11.glVertex2f(250, 100);
        GL11.glEnd();
        
        
        Display.update();
    }
    
    private void time() {
        timeNew = System.nanoTime();
        dTime = timeNew - time;
        time = timeNew;
    }
    private void handleSpace(){
        coordinate = 700;
    }
    private void printShit(String shit){
        System.out.println(shit);
    }
}
