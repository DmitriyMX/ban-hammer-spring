package ru.dmitriymx.plugin.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Optional;
import java.util.Properties;

@SuppressWarnings("deprecation")
public class BukkitYamlPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private final FileConfiguration fileConfiguration;

	public BukkitYamlPlaceholderConfigurer(FileConfiguration fileConfiguration) {
		this.fileConfiguration = fileConfiguration;
	}

	@Override
	protected String resolvePlaceholder(String placeholder, Properties props) {
		return Optional.ofNullable(fileConfiguration.getString(placeholder))
				.orElseGet(() -> super.resolvePlaceholder(placeholder, props));
	}
}
