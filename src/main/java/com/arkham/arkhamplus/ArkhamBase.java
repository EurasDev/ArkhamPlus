package com.arkham.arkhamplus;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "arkhamplus", version = "1.1.0")
public class ArkhamBase
{
	
	public static ArkhamBase instance;
	
	@SidedProxy(clientSide = "com.arkham.arkhamplus.client.ClientProxy", serverSide = "com.arkham.arkhamplus.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent preInitEvent)
    {
		proxy.registerRenderers();
    } 
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    
	@EventHandler
	public void postInit(FMLPostInitializationEvent postInitEvent)
	{
		MinecraftForge.EVENT_BUS.register(new InGameGUI());
	}
	
}

