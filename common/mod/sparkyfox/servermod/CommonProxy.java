package mod.sparkyfox.servermod;

import mod.sparkyfox.servermod.init.ModBlocks;
import mod.sparkyfox.servermod.init.ModItems;
import mod.sparkyfox.servermod.init.ModWeapons;
import mod.sparkyfox.servermod.world.WorldGenOre;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class CommonProxy {

//===========================================================================================================================================================================================\\	
																									//Client Stuff\\
	
	public void registerModels() {
	}

	public void registerRenderer() {
	}

	public void registerEventHandler() {
	}

//===============================================================================================================================================================================================\\
																										//Inits\\
	
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
		//RegistryHandler.common();
		
		
	}

	public void init(FMLInitializationEvent event) {
		ModItems.initRecipes();
		//ModFunItems.initRecipes();
		ModBlocks.initRecipes();
		ModWeapons.initRecipes();
		//ModFunBlocks.initRecipes();
		GameRegistry.registerWorldGenerator(new WorldGenOre(), 0);  //Register the ore generator
	}
	  public void postInit(FMLPostInitializationEvent event) {}
	  
	
	  public void registerItem(Item item, String name, int meta)
	  {
	     ResourceLocation resource = new ResourceLocation("servermod", name);
	     if ((!Item.REGISTRY.containsKey(resource)) && (item.getRegistryName() == null))
	       GameRegistry.register(item, resource);
	  }
	  
	  public Item registerBlock(Block block, String name, int meta, Class<? extends ItemBlock> itemclass, boolean seperateMetadata) {
	     ResourceLocation resource = new ResourceLocation("servermod", name);
	     GameRegistry.register(block, resource);
	    try {
	       Item item = (Item)itemclass.getConstructor(new Class[] { Block.class }).newInstance(new Object[] { block });
	       GameRegistry.register(item, resource);
	       return item;
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	     return null;
	  }
	  
	  public void registerBlock(Block block, String name, int meta, Class<? extends ItemBlock> itemclass) {
	     registerBlock(block, name, meta, itemclass, false);
	  }
	
	
	  public void spawnParticle(EntityLivingBase player, String string, Object... ob) {}
	  
	
	  public void spawnParticle(EnumParticleTypes particle, double x, double y, double z, double motionX, double motionY, double motionZ, float scale) {}
	
//===============================================================================================================================================================================================\\

	public void registerRenders()
	{

	}

	public World getClientWorld()
	{
		return null;
	}

	public EntityPlayer getClientPlayer()
	{
		return null;
	}

	public boolean isSinglePlayer()
	{
		return false;
	}

	public boolean isDedicatedServer()
	{
		return true;
	}
}

