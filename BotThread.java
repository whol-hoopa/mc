package Bot.minecraft;

import net.minecraft.client.Minecraft;
import Bot.minecraft.Build;
import Bot.minecraft.Blueprint;

public class BotThread extends Thread{
    Build BuildFunctions;
    Blueprint BluePrintFunctions;

    private Minecraft mc;

    public BotThread(){
        BuildFunctions = new Build();
        BluePrintFunctions = new Blueprint();

        mc = mc.getMinecraft();
    }

    @Override
    public void run(){
        while(true){
            UpdateToggles();

        }
    }

    private void UpdateToggles(){
        BuildFunctions.Update();
        BluePrintFunctions.updateToggle();
    }
}
