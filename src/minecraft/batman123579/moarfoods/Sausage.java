package batman123579.moarfoods;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class Sausage extends ItemFood{

	public Sausage(int ID, int par2, boolean par3) {
		super(ID, 6, false);
		this.setCreativeTab(mod_MainClass.EvenMoarFoodsTab);
		maxStackSize = 64;
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("evenmoarfood:Sausage");
    }
}
