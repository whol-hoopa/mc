package Bot.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.BlockPos;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Blueprint {
    private static boolean BlueprintToggle;
    private static KeyBinding KeybindBlueprint;

    private static BlockInfo FirstSelectedBlock;
    private static BlockInfo SecondSelectedBlock;

    public Blueprint()
    {
        BlueprintToggle = false;
        KeybindBlueprint = new KeyBinding("key.blueprint", Keyboard.KEY_P, "key.Bot");

        FirstSelectedBlock = new BlockInfo();
        SecondSelectedBlock = new BlockInfo();
    }

    public static void RightClickHook(Minecraft mc)
    {
        switch(mc.objectMouseOver.typeOfHit)
        {
            case BLOCK:
                BlockPos blockpos = mc.objectMouseOver.getBlockPos();

                if (mc.theWorld.getBlockState(blockpos).getBlock().getMaterial() != Material.air)
                {
                    if (FirstSelectedBlock.block == null && FirstSelectedBlock.pos == null)
                    {
                        FirstSelectedBlock.setBlockInfo(mc.theWorld.getBlockState(blockpos).getBlock(), blockpos);
                    }
                    else if (mc.theWorld.getBlockState(blockpos).getBlock().getMaterial() == FirstSelectedBlock.block.getMaterial())
                    {
                        SecondSelectedBlock.setBlockInfo(mc.theWorld.getBlockState(blockpos).getBlock(), blockpos);
                    }
                }
        }
    }

    public void updateShowBlueprint(Minecraft mc){
    }

    public void updateToggle()
    {
        if (IsToggleKeyPressed())
        {
            if (BlueprintToggle)
            {
                TurnOff();
            } else {
                TurnOn();
            }
        }
    }

    private void TurnOn(){
        BlueprintToggle = true;
    }

    private void TurnOff(){
        BlueprintToggle = false;
    }

    private boolean IsToggleKeyPressed(){
        return KeybindBlueprint.isPressed();
    }

    public boolean isShowBlueprint(){
        return FirstSelectedBlock != null && SecondSelectedBlock != null;
    }

    public static boolean GetBluePrintToggle(){
        return BlueprintToggle;
    }
}
