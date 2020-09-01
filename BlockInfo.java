package Bot.minecraft;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

public class BlockInfo {
    public Block block;
    public BlockPos pos;

    public BlockInfo(){
        block = null;
        pos = null;
    }

    public void setBlockInfo(Block block, BlockPos pos){
        this.block = block;
        this.pos = pos;
    }
}
