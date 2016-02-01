package com.arkham.arkhamplus.client;

import java.io.IOException;

import com.arkham.arkhamplus.CommonProxy;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy
{	
	public ClientProxy()
	{
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this); 
	}
			
	@SubscribeEvent
	public void onInitGuiEvent(InitGuiEvent.Post event)
	{
		if(event.gui instanceof GuiMainMenu)
		{			
			for(Object b : event.buttonList)
			{
				if(((GuiButton) b).id == 14) {
					((GuiButton) b).visible = false;
				}
			}
			
			int i = event.gui.height / 4 + 48;
			GuiButton playButton = new GuiButton(30, event.gui.width / 2 - 100, i + 24 * 2, "Play Arkham!");
			playButton.setWidth(98);
			event.buttonList.add(playButton);
			
			GuiMainMenu g = (GuiMainMenu)event.gui;
		}
		
		if(event.gui instanceof GuiOptions)
		{
			GuiButton vcOptions = new GuiButton(500, event.gui.width / 2 - 75, event.gui.height / 6 + 24 - 6, 150, 20, "Arkham\u002B Options");
			event.buttonList.add(vcOptions);
		}
	}
	
	
	
	@SubscribeEvent
	public void onActionPerformed(ActionPerformedEvent.Pre event)  throws IOException
	{
        if (event.button.id == 30)
        {
        	FMLClientHandler. instance().setupServerList();
			FMLClientHandler.instance().connectToServer(FMLClientHandler.instance().getClient().currentScreen, new ServerData("Arkham", "mc.arkhamnetwork.org:25565"));
        }
        if(event.button.id == 500)
        {
        	event.gui.mc.displayGuiScreen(new GuiOptionsMenu(event.gui));
        }
	}
}
