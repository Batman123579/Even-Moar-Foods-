package batman123579.moarfoods;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import batman123579.moarfoods.*;

public class IronStone extends Block{

	public IronStone(int par1) {
		super(par1, Material.ground);
		this.setCreativeTab(mod_MainClass.EvenMoarFoodsTab);
	}
	
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("evenmoarfood:IronStone");
    }

    @SideOnly(Side.CLIENT)
    public String func_94327_t_()
    {
        return null;
    }

}
