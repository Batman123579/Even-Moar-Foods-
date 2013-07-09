package batman123579.moarfoods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		if(tile_entity instanceof TileEntityDeepFryer){
			return new ContainerDeepFryer(player.inventory, (TileEntityDeepFryer) tile_entity);
			
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		if(tile_entity instanceof TileEntityDeepFryer){
			return new GuiDeepFryer(player.inventory, (TileEntityDeepFryer) tile_entity);
			
		}
		
		return null;
	}
	
}