package com.arkham.arkhamplus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

public class NewStat {
	
	public static enum statType {
		Name,
		FPS,
		PlayerCount,
		Ping,
		Biome,
		Health,
		Armor
	}
	
	public Minecraft mc;
	public Gui g;
	public String statTitle;
	public int statPos_x;
	public int statPos_y;
	
	public NewStat(Minecraft mc, InGameGUI g, String title, int x, int y, statType type)
	{
		this.mc = mc;
		this.g = g;
		this.statTitle = title;
		this.statPos_x = x;
		this.statPos_y = y;
		mc.getTextureManager().bindTexture(new ResourceLocation("arkhamplus:textures/gui/icon.png"));
		draw(type);	
	}

	private void draw(statType type) {
		switch(type)
		{
		default: 
			break;
		case Name: getName();
			break;
		case FPS: getFPS();
			break;
		case PlayerCount: getPlayers();
			break;
		case Ping: getPing();
			break;	
		case Biome: getBiome();
			break;
		case Health: getHealth();
			break;
		case Armor: getArmor();
			break;
		}
	}

	public void getName() {
		g.drawModalRectWithCustomSizedTexture(statPos_x, statPos_y, 0, 0, 8, 8, 8, 8);
		g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.WHITE + "" + EnumChatFormatting.ITALIC + mc.getMinecraft().thePlayer.getDisplayNameString(), statPos_x + 15, statPos_y, 0xFFFFFF);
	}
	
	private void getFPS() {
		g.drawModalRectWithCustomSizedTexture(statPos_x, statPos_y, 0, 0, 8, 8, 8, 8);
		g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.WHITE + "" + EnumChatFormatting.ITALIC + mc.getDebugFPS(), statPos_x + 15, statPos_y, 0xFFFFFF);
	}
	
	private void getPlayers() {
		g.drawModalRectWithCustomSizedTexture(statPos_x, statPos_y, 0, 0, 8, 8, 8, 8);
		g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.WHITE + "" + EnumChatFormatting.ITALIC + mc.getMinecraft().theWorld.playerEntities.size(), statPos_x + 15, statPos_y, 0xFFFFFF);
	}
	
	private void getPing() {
		g.drawModalRectWithCustomSizedTexture(statPos_x, statPos_y, 0, 0, 8, 8, 8, 8);
		g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.WHITE + "" + EnumChatFormatting.ITALIC + ping(), statPos_x + 15, statPos_y, 0xFFFFFF);
	}
	
	private String ping() 
	{	      	         
	    NetHandlerPlayClient handler = this.mc.thePlayer.sendQueue;
	    List list = new ArrayList(handler.func_175106_d());
	    Iterator iterator = list.iterator();
	    
	    while (iterator.hasNext())
	    {
	         NetworkPlayerInfo networkplayerinfo = (NetworkPlayerInfo) iterator.next();	 
	         if(networkplayerinfo.getResponseTime() > 0 && networkplayerinfo.getResponseTime() < 1000)
	         {
		         return networkplayerinfo.getResponseTime() + "ms";
	         }
	    }	 
	    return "null";
	}	
	
	private void getBiome() {
		g.drawModalRectWithCustomSizedTexture(statPos_x, statPos_y, 0, 0, 8, 8, 8, 8);
		String biomeName = mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName;
		g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.WHITE + "" + EnumChatFormatting.ITALIC + biomeName, statPos_x + 15, statPos_y, 0xFFFFFF);
	}
	
	private void getHealth() 
	{
		g.drawModalRectWithCustomSizedTexture(statPos_x, statPos_y, 0, 0, 8, 8, 8, 8);
		float health = mc.getMinecraft().thePlayer.getHealth() / 2;
		if(health > 6)
		{
			g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + (float)(Math.ceil(health * 2) / 2) + EnumChatFormatting.RESET, statPos_x + 15, statPos_y, 0xFFFFFF);		
		}else if(health < 4)
		{
			g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + (float)(Math.ceil(health * 2) / 2) + EnumChatFormatting.RESET, statPos_x + 15, statPos_y, 0xFFFFFF);
		}else{
			g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + (float)(Math.ceil(health * 2) / 2) + EnumChatFormatting.RESET, statPos_x + 15, statPos_y, 0xFFFFFF);
		}
	}

	private void getArmor() 
	{
		g.drawModalRectWithCustomSizedTexture(statPos_x, statPos_y, 0, 0, 8, 8, 8, 8);
		float armor = (float)mc.getMinecraft().thePlayer.getTotalArmorValue() / 2;
		if(armor > 6)
		{
			
			g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.GREEN + "" + EnumChatFormatting.ITALIC + (float)(Math.ceil(armor * 2) / 2) + EnumChatFormatting.RESET, statPos_x + 15, statPos_y, 0xFFFFFF);		
		}else if(armor < 4)
		{
			g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + (float)(Math.ceil(armor * 2) / 2) + EnumChatFormatting.RESET, statPos_x + 15, statPos_y, 0xFFFFFF);
		}else{
			g.drawString(mc.fontRendererObj, EnumChatFormatting.GRAY + statTitle + EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + (float)(Math.ceil(armor * 2) / 2) + EnumChatFormatting.RESET, statPos_x + 15, statPos_y, 0xFFFFFF);
		}
	}


}
