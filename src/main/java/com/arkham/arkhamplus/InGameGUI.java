package com.arkham.arkhamplus;

import java.io.IOException;

import com.arkham.arkhamplus.client.GuiOptionsMenu;
import com.arkham.arkhamplus.client.GuiOptionsStatsMenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class InGameGUI extends Gui {
	
	private Minecraft mc;
	public boolean playerHasLoggedIn = false;
	
	public InGameGUI()
	{
		this.mc = Minecraft.getMinecraft();
		playerHasLoggedIn = !playerHasLoggedIn;
		GuiOptionsStatsMenu.statList.add("Name");
		GuiOptionsStatsMenu.statList.add("FPS");
		GuiOptionsStatsMenu.statList.add("pCount");
		GuiOptionsStatsMenu.statList.add("Ping");
	}
	
	@SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Text event) throws IOException
    {	    
		if(GuiOptionsMenu.showStats)
		{
			drawStatsBG();
			int statsPos_Y = 10;
			
			for(String s : GuiOptionsStatsMenu.statList)
			{
				statsPos_Y += 15;
				
				if(s == "Name")
					if(GuiOptionsStatsMenu.showName){ NewStat nameStat = new NewStat(mc, this, "Name: ", 8, statsPos_Y, NewStat.statType.Name); }
				if(s == "FPS")
					if(GuiOptionsStatsMenu.showFPS){ NewStat fpsStat = new NewStat(mc, this, "FPS: ", 8, statsPos_Y, NewStat.statType.FPS); }
				if(s == "pCount")
					if(GuiOptionsStatsMenu.showPlayerCount){ NewStat playerStat = new NewStat(mc, this, "Players: ", 8, statsPos_Y, NewStat.statType.PlayerCount); }
				if(s == "Ping")
					if(GuiOptionsStatsMenu.showPing){ NewStat pingStat = new NewStat(mc, this, "Ping: ", 8, statsPos_Y, NewStat.statType.Ping); }
				if(s == "Biome")
					if(GuiOptionsStatsMenu.showBiome){ NewStat biomeStat = new NewStat(mc, this, "Biome: ", 8, statsPos_Y, NewStat.statType.Biome); }
				if(s == "Health")
					if(GuiOptionsStatsMenu.showHealth) { NewStat healthStat = new NewStat(mc, this, "Health: ", 8, statsPos_Y, NewStat.statType.Health); }
				if(s == "Armor")
					if(GuiOptionsStatsMenu.showArmor){ NewStat armorStat = new NewStat(mc, this, "Armor: ", 8, statsPos_Y, NewStat.statType.Armor); }
			}
		}
   	    
        if(GuiOptionsMenu.showCompass)
        {
            drawCompass();
        }
        
        if(playerHasLoggedIn)
        {
        	sendMessage();
        }
    }

	private void sendMessage() 
	{
		mc.thePlayer.addChatMessage(new ChatComponentText(
				EnumChatFormatting.AQUA + 	
				"-\u005B" + 
				EnumChatFormatting.WHITE + 
				"" + 
				EnumChatFormatting.ITALIC + 
				"Arkham" + "\u002B" + 
				EnumChatFormatting.AQUA +
				"\u005D- " + 
				EnumChatFormatting.GRAY + 
				"\u00BB " + 
				EnumChatFormatting.WHITE + 
				"Hi " + 
				EnumChatFormatting.YELLOW +
				mc.thePlayer.getDisplayNameString() + 
				EnumChatFormatting.WHITE +
				"\u0021 " + "Thanks for using Arkham" + "\u002B " +
				EnumChatFormatting.GRAY + 
				"\u00AB "
				));	
		playerHasLoggedIn = !playerHasLoggedIn;
	}
	
	private void drawStatsBG() 
	{
		int statsHeight = 25;
		statsHeight += GuiOptionsStatsMenu.statList.size() * 15;
		
		mc.getTextureManager().bindTexture(new ResourceLocation("arkhamplus:textures/gui/border-start.png"));
		this.drawModalRectWithCustomSizedTexture(2, 2, 0, 0, 125, 10, 125, 10);
		mc.getTextureManager().bindTexture(new ResourceLocation("arkhamplus:textures/gui/border-end.png"));
		this.drawModalRectWithCustomSizedTexture(2, statsHeight, 0, 0, 125, 10, 125, 10);
		this.drawRect(4, 12, 125, statsHeight, 0xBF000000);
        this.drawString(mc.fontRendererObj, EnumChatFormatting.WHITE + "Arkham\u002B " + EnumChatFormatting.AQUA + "\u00BB" + EnumChatFormatting.WHITE + " v1.0" + EnumChatFormatting.RESET, 10 + 16, 8, 0xFFFFFF);
	}

	private void drawCompass()
	{
		ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		int width = scaled.getScaledWidth();
		
        int direction = MathHelper.floor_double(((mc.thePlayer.rotationYaw * 256F) / 360F) + 0.5D) & 255;
        
		 mc.getTextureManager().bindTexture(new ResourceLocation("arkhamplus:textures/gui/compass.png"));
		 if (direction < 128)
		 {
		     this.drawTexturedModalRect(width / 2 - (65 / 2), 10, direction, (0 * 24), 65, 12);
		 }else{
			 this.drawTexturedModalRect(width / 2 - (65 / 2), 10, direction - 128, (0 * 24) + 12, 65, 12);
		 }
		    // Compass Arrow
	        this.drawTexturedModalRect(width / 2 - 2.5f, 10, 
	        		192, 0, 5, 3);
	        // Compass Sides
	        this.drawTexturedModalRect((width / 2 - 8) - (65 / 2) - (13 / 2) + 1, 10, 
	        		0, 24, 13, 12);
	        this.drawTexturedModalRect((width / 2) + (65 / 2) + 1, 10, 
	        		13, 24, 13, 12);	    
	        // Bat Head
	        this.drawTexturedModalRect((width / 2) - 7.5f, 2, 
	        		35, 24, 15, 8);	 
	        // Bat Tail
	        this.drawTexturedModalRect((width / 2) - 4.5f, 22, 
	        		26, 24, 9, 8);	        
	}
}

