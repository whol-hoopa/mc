package Bot.minecraft;

import org.lwjgl.input.Keyboard;

public class Build {
    private static boolean BuildToggle;
    private static int BuildToggleKey;

   public Build(){
        BuildToggle = false;
        BuildToggleKey = Keyboard.KEY_L;
    }

    public void Update(){
        if(IsToggleKeyPressed()){
            if(BuildToggle){
                TurnOff();
            } else {
                TurnOn();
            }
        }
    }

    private boolean IsToggleKeyPressed(){
       return Keyboard.isKeyDown(BuildToggleKey);
    }

    private void TurnOn(){
       BuildToggle = true;
    }

    private void TurnOff(){
       BuildToggle = false;
    }
}
