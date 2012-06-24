/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dodgeit;

import dodgeit.statics.state;
import java.util.Stack;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author juho
 */
public class DodgeIt {


    
    private Stack<statics.state> stateStack = new Stack();
    private GameLoop gameState;
    private MenuLoop menuState;
    private LoopTemplate currentState;
    
    public DodgeIt() {
        gameState = new GameLoop(this);
        menuState = new MenuLoop(this);
    }

    public void startGame() {

        try {
            Display.setDisplayMode(new DisplayMode(statics.DISPLAY_WIDTH, statics.DISPLAY_HEIGHT));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace(System.out);
            System.exit(0);
        }
        
        Display.setTitle(statics.TITLE);
        
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, statics.DISPLAY_WIDTH, 0, statics.DISPLAY_HEIGHT, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        stateStack.push(statics.state.MENU_STATE);
        stackHandler();
    }

    private void stackHandler() {
        System.out.println(statics.state.MENU_STATE);
        while (stateStack.empty() == false) {
            switch (stateStack.pop()){
                case MENU_STATE:
                    currentState = menuState;
                    break;
                case GAME_STATE:
                    currentState = gameState;
                    break;
            }

            currentState.run();
        }

        Display.destroy();
    }
    public void addToStack(statics.state state){
        stateStack.add(state);
    }
    public void thisDoesNothing(){
        
    }
}
