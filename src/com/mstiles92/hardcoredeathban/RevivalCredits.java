package com.mstiles92.hardcoredeathban;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class RevivalCredits {
	
	private final HardcoreDeathBanPlugin plugin;
	private YamlConfiguration creditConfig;
	private File configFile;
	private boolean loaded = false;
	
	public RevivalCredits(HardcoreDeathBanPlugin plugin) {
		this.plugin = plugin;
	}
	
	public void load(String filename) {
		
		configFile = new File(plugin.getDataFolder(), filename);
		
		if (configFile.exists()) {
			creditConfig = new YamlConfiguration();
			try {
				creditConfig.load(configFile);
			}
			catch (FileNotFoundException e) {
				// TODO Handle catching exception
			}
			catch (IOException e) {
				// TODO Handle catching exception
			}
			catch (InvalidConfigurationException e) {
				// TODO Handle catching exception
			}
			loaded = true;
		} else {
			try {
				configFile.createNewFile();
				creditConfig = new YamlConfiguration();
				creditConfig.load(configFile);
			}
			catch (IOException e) {
				// TODO Handle catching exception
			}
			catch (InvalidConfigurationException e) {
				// TODO Handle catching exception
			}
		}	
	}
	
	public void save() {
		try {
			creditConfig.save(configFile);
		}
		catch (IOException e) {
			// TODO Handle catching exception
		}
	}
	
	public File getFile() {
		return configFile;
	}
	
	public YamlConfiguration getConfig() {
		if (!loaded) {
			load("credits.yml");
		}
		return creditConfig;
	}
}
