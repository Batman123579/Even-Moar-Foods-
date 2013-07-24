package batman123579.moarfoods;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import batman123579.moarfoods.CommonProxy;

@NetworkMod(clientSideRequired=true,serverSideRequired=false, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialMod"}, packetHandler = PacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialMod"}, packetHandler = ServerPacketHandler.class)) //For serverside packet handling


@Mod(modid = "evenmoarfood", name = "Even Moar Foods?", version = "Beta 0.3.1")


public class mod_MainClass {
	
	@SidedProxy(clientSide = "batman123579.moarfoods.ClientProxy", serverSide = "batman123579.moarfoods.CommonProxy") //Tells Forge the location of your proxies
	public static CommonProxy proxy;


@Instance("evenmoarfood") //The instance, this is very important later on
public static mod_MainClass instance = new mod_MainClass();

	
	//GUI Stuff
	private GuiHandler guihandler = new GuiHandler();
	
	//Creative Tab
	public static CreativeTabs EvenMoarFoodsTab;

	
	//Add Blocks/Items
	
	
	public static Block IronStone;
	
	public static Block DeepFryerIdle;
	public static Block DeepFryerBurning;
	
	//Food
	public static ItemFood Sausage;
	public static ItemFood PotatoDog;
	public static ItemFood Cheese;
	public static ItemFood Tomato;
	public static ItemFood Dough;
	public static ItemFood Pizza;
	public static ItemFood SausageSandwich;
	public static ItemFood Chips;
	
	public static Item FireBurner;
	
	EventManager eventmanager = new EventManager();
	
	@EventHandler
	public void InitTutorialMod(FMLInitializationEvent event){ //Your main initialization method

		//MULTIPLAYER ABILITY
		NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

		
		//Registers CreativeTab
		EvenMoarFoodsTab = new EvenMoarFoodsTab(CreativeTabs.getNextID(), "Even Moar Foods");

		
		//Renders Blocks/Items
		
		IronStone = new IronStone(3980).setHardness(3.0F).setResistance(10.0F).setUnlocalizedName("IronStone");
		DeepFryerIdle = new DeepFryer(3981, false).setHardness(3.5F).setUnlocalizedName("Deep Fryer Idle").setCreativeTab(EvenMoarFoodsTab);
		DeepFryerBurning = new DeepFryer(3982, true).setHardness(3.5F).setLightValue(0.875F).setUnlocalizedName("Deep Fryer Burning");
		

		FireBurner = new FireBurner(22611).setUnlocalizedName("FireBurner");
		
		Sausage = (ItemFood) new Sausage(22610, 0, false).setUnlocalizedName("Sausage");
		PotatoDog = (ItemFood) new PotatoDog(22612, 0, false).setUnlocalizedName("PotatoDog");
		Cheese = (ItemFood) new Cheese(22613, 0, false).setUnlocalizedName("Cheese");
		Tomato = (ItemFood) new Tomato(22614, 0, false).setUnlocalizedName("Tomato");
		Dough = (ItemFood) new Dough(22615, 0, false).setUnlocalizedName("Dough");
		Pizza = (ItemFood) new Pizza(22616, 0, false).setUnlocalizedName("Pizza");
		SausageSandwich = (ItemFood) new SausageSandwich(22617, 0, false).setUnlocalizedName("SausageSandwich");
		Chips = (ItemFood) new Chips(22618, 0, false).setUnlocalizedName("Chips");
		

		
		//Register Block
		
		GameRegistry.registerBlock(IronStone,"MoarFoods.IronStone");
		GameRegistry.registerBlock(DeepFryerIdle, "MoarFoods.DeepFryerIdle");
		GameRegistry.registerBlock(DeepFryerBurning, "MoarFoods.DeepFryerBurning");
		
		//GUI Register
		GameRegistry.registerTileEntity(TileEntityDeepFryer.class, "tileentitydeepfryer");
		NetworkRegistry.instance().registerGuiHandler(this, guihandler);
		
		//Add the Name
		LanguageRegistry.addName(IronStone, "IronStone");
		LanguageRegistry.addName(DeepFryerIdle, "Deep Fat Fryer");
		LanguageRegistry.addName(DeepFryerBurning, "Deep Fat Fryer");
		
		LanguageRegistry.addName(Sausage, "Sausage");
		LanguageRegistry.addName(PotatoDog, "Potato Dog");
		LanguageRegistry.addName(FireBurner, "FireBurner");
		LanguageRegistry.addName(Cheese, "Cheese");
		LanguageRegistry.addName(Tomato, "Tomato");
		LanguageRegistry.addName(Dough, "Dough");
		LanguageRegistry.addName(Pizza, "Pizza");
		LanguageRegistry.addName(SausageSandwich, "Sausage Sandwich");
		LanguageRegistry.addName(Chips, "Chips");
		
		//Recipes
		
		 GameRegistry.addRecipe(new ItemStack(PotatoDog), new Object[]{
             "C C",
             "CSC",
             "C C",
             'C', Item.bakedPotato, 'P', Item.potato, 'S', Sausage
      });

		 GameRegistry.addRecipe(new ItemStack(DeepFryerIdle), new Object[]{
             "III",
             "I I",
             "III",
             'I', IronStone
      });
		 
		 GameRegistry.addRecipe(new ItemStack(Pizza), new Object[]{
             "CCC",
             "TTT",
             "DDD",
             'C', Cheese, 'T', Tomato, 'D', Dough
      });
		 
		 GameRegistry.addRecipe(new ItemStack(Tomato), new Object[]{
             "   ",
             "MSM",
             "RRR",
             'M', Block.mushroomRed, 'S', Item.sugar, 'R', Block.plantRed
      });
		 
		GameRegistry.addShapelessRecipe(new ItemStack (IronStone, 2), new Object []{
			Block.blockIron, Block.stone
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (FireBurner, 1), new Object []{
			Item.coal, Item.flintAndSteel
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack (Dough, 2), new Object []{
			Item.bucketWater, Item.wheat, Item.wheat
		});
		
		 GameRegistry.addRecipe(new ItemStack(SausageSandwich), new Object[]{
             "BBB",
             " S ",
             "BBB",
             'B', Item.bread, 'S', Sausage
			});
	}

		
	}