
package dodgeit;


/**
 *
 * @author juho
 */
public abstract class LoopTemplate {
    DodgeIt game;
    public LoopTemplate(DodgeIt newgame){
        game = newgame;
    }
    public abstract void run();
}
