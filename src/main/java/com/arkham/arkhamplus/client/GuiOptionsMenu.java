package com.arkham.arkhamplus.client;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiOptionsMenu extends GuiScreen {
	
	    private GuiScreen guiScreen;
		
		public static boolean showCompass = true;
		public static boolean showStats = true;
		
		public String compassOnOff;
		public String statsOnOff;
					     
		 public GuiOptionsMenu(GuiScreen guiScreen) 
		 {
			 this.guiScreen = guiScreen;
		 }
		
		 public void initGui()
		 {   
			super.initGui();		 
			this.createButtons();
		 }
		 
		 public void createButtons()
		 {
			 
			 this.buttonList.clear();
			 
			 if(showStats)
			 {
				 statsOnOff = "ON";
			 }else{
				 statsOnOff = "OFF";
			 }
			 
			 if(showCompass)
			 {
				 compassOnOff = "ON";
			 }else{
				 compassOnOff ="OFF";
			 }
			 
			 GuiButton enableStats = new GuiButton(
					 0, 
					 this.width / 2 - 75, 
					 this.height / 6 + 24 - 6, 
					 150, 20, 
					 "Stats Enabled: " + statsOnOff);
			 GuiButton statsOptions = new GuiButton(
					 1, 
					 this.width / 2 - 75, 
					 this.height / 6 + 48 - 6, 
					 150, 20, 
					 "Stats Options");
			 GuiButton enableCompass = new GuiButton(
					 2, 
					 this.width / 2 - 75, 
					 this.height / 6 + 72 - 6, 
					 150, 20, 
					 "Compass Enabled: " + compassOnOff);
			 GuiButton cancelButton = new GuiButton(
					 3, 
					 this.width / 2 - 75, 
					 this.height / 6 + 96 - 6, 
					 150, 20, 
					 "Done");
			 
			 this.buttonList.add(enableStats);
			 this.buttonList.add(statsOptions);
			 this.buttonList.add(enableCompass);
			 this.buttonList.add(cancelButton);

		 }
		 
		protected void actionPerformed(GuiButton button) throws IOException
		 {
			int i = button.id;

			switch(i)
			{
			case 0: showStats = !showStats; this.createButtons();
				break;
			case 1: mc.displayGuiScreen(new GuiOptionsStatsMenu(guiScreen));
				break;
			case 2: showCompass = !showCompass; this.createButtons();
				break;
			case 3: this.mc.displayGuiScreen(this.guiScreen);
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
			this.drawCenteredString(this.fontRendererObj, "Arkham\u002B Options", this.width / 2, 20, 0xFFFFFF);
			super.drawScreen(mouseX, mouseY, partialTicks);
		 }

}
