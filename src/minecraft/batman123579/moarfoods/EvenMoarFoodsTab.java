package batman123579.moarfoods;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public final class EvenMoarFoodsTab extends CreativeTabs
{
    public EvenMoarFoodsTab(int par1, String par2Str) 
        {
                super(par1, par2Str);
        }
        

		//sets the image for the creative tab
        @SideOnly(Side.CLIENT)
        public int getTabIconItemIndex()
        {
                return Block.furnaceBurning.blockID;
        }
   
        //sets the title/name for the creative tab
        public String getTranslatedTabLabel()
        {
         return "Even Moar Foods";
        }
}