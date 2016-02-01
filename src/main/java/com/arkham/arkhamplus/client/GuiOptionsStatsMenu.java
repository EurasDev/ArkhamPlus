package com.arkham.arkhamplus.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiOptionsStatsMenu extends GuiScreen {

	public GuiScreen guiScreen;
	public static List<String> statList = new ArrayList<String>();
	
	public String _showName;
	public String _showFPS;
	public String _showPlayerCount;
	public String _showPing;
	public String _showBiome;
	public String _showHealth;
	public String _showArmor;
	public static boolean showName = true;	
	public static boolean showFPS = true;	
	public static boolean showPlayerCount = true;	
	public static boolean showPing = true;
	public static boolean showBiome;
	public static boolean showHealth;
	public static boolean showArmor;
	
	public GuiOptionsStatsMenu(GuiScreen guiScreen)
	{
		this.guiScreen = guiScreen;
	}
	
	public void initGui()
	 {   
		super.initGui();		 
		this.createButtons();
	 }

	private void createButtons() {
		
		 this.buttonList.clear();
		 statList.clear();
		 
		 if(showName)
		 {
			 _showName = "ON";
			 statList.add("Name");	 
		 }else{
			 _showName ="OFF";
		 }

		 if(showFPS)
		 {
			 _showFPS = "ON";
			 statList.add("FPS");	
		 }else{
			 _showFPS ="OFF";
		 }
		 
		 if(showPlayerCount)
		 {
			 _showPlayerCount = "ON";
			 statList.add("pCount");	
		 }else{
			 _showPlayerCount = "OFF";
		 }
		 
		 if(showPing)
		 {
			 _showPing = "ON";
			 statList.add("Ping");	
		 }else{
			 _showPing = "OFF";
		 }
		 
		 if(showBiome)
		 {
			 _showBiome = "ON";
			 statList.add("Biome");	
		 }else{
			 _showBiome = "OFF";
		 }
		 
		 if(showHealth)
		 {
			 _showHealth = "ON";
			 statList.add("Health");	
		 }else{
			 _showHealth = "OFF";
		 }
		 
		 if(showArmor)
		 {
			 _showArmor = "ON";
			 statList.add("Armor");	
		 }else{
			 _showArmor = "OFF";
		 }
		 
		 GuiButton showNameButton = new GuiButton(
				 0, 
				 this.width / 2 - 155, 
				 this.height / 6 + 24 - 6, 
				 150, 20, 
				 "Name: " + _showName);
		 GuiButton showFPSButton = new GuiButton(
				 1, 
				 this.width / 2 + 5, 
				 this.height / 6 + 24 - 6, 
				 150, 20, 
				 "FPS: " + _showFPS);
		 GuiButton showPlayerCountButton = new GuiButton(
				 2, 
				 this.width / 2 - 155, 
				 this.height / 6 + 48 - 6, 
				 150, 20, 
				 "Player Count: " + _showPlayerCount);
		 GuiButton showPingButton = new GuiButton(
				 3, 
				 this.width / 2 + 5, 
				 this.height / 6 + 48 - 6, 
				 150, 20, 
				 "Ping: " + _showPing);
		 GuiButton showBiomeButton = new GuiButton(
				 5, 
				 this.width / 2 - 155, 
				 this.height / 6 + 72 - 6, 
				 150, 20, 
				 "Biome: " + _showBiome);
		 GuiButton showHealthButton = new GuiButton(
				 6, 
				 this.width / 2 + 5, 
				 this.height / 6 + 72 - 6, 
				 150, 20, 
				 "Health: " + _showHealth);
		 GuiButton showArmorButton = new GuiButton(
				 7, 
				 this.width / 2 - 155, 
				 this.height / 6 + 96 - 6, 
				 150, 20, 
				 "Armor: " + _showArmor);
		 GuiButton doneButton = new GuiButton(
				 4, 
				 this.width / 2 + 5, 
				 this.height / 6 + 96 - 6, 
				 150, 20, 
				 "Done");
		 
		 this.buttonList.add(showNameButton);
		 this.buttonList.add(showFPSButton);
		 this.buttonList.add(showPlayerCountButton);
		 this.buttonList.add(showPingButton);
		 this.buttonList.add(showBiomeButton);
		 this.buttonList.add(showHealthButton);
		 this.buttonList.add(showArmorButton);
		 this.buttonList.add(doneButton);
	}

	protected void actionPerformed(GuiButton button) throws IOException
	{	
		int i = button.id;
		
		switch(i)
		{
		case 0: showName = !showName; this.createButtons(); 
			break;
		case 1: showFPS = !showFPS; this.createButtons(); 
			break;
		case 2: showPlayerCount = !showPlayerCount; this.createButtons(); 
			break;
		case 3: showPing = !showPing; this.createButtons(); 
			break;
		case 4: this.mc.displayGuiScreen(this.guiScreen);
			break;
		case 5: showBiome = !showBiome; this.createButtons();
			break;
		case 6: showHealth = !showHealth; this.createButtons();
			break;
		case 7: showArmor = !showArmor; this.createButtons();
			break;
		}
	}
	
	@Override
	public void updateScreen()
    {
		 super.updateScreen();   
    }
	
	 public void drawScreen(int mouseX, int mouseY, float partialTicks)
	 { 
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRendererObj, "Arkham\u002B Stats", this.width / 2, 20, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, partialTicks);
	 }

}
