package io.github.pronze.sba.fix;

import io.github.pronze.sba.config.SBAConfig;
import io.github.pronze.sba.utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.screamingsandals.bedwars.Main;

public class PerWorldPluginFix extends BaseFix {

    private boolean isProblematic;
    @Override
    public void detect() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("PerWorldPlugins");

        if (plugin != null) {
            isProblematic = !plugin.getDescription().getAuthors().contains("TonimatasDEV");
        } else {
            isProblematic = false;
        }
    }

    @Override
    public void fix(SBAConfig cfg) {
        if (isProblematic) {
            Bukkit.getServer().getPluginManager().disablePlugin(Main.getInstance());
        }
    }

    @Override
    public void warn() {
        Logger.error("SBA FATAL ERROR::PerWorldPlugin breaks custom plugin events required by Bedwars and SBA");
        Logger.error("SBA Will shutdown due to incompatible plugin(s)");
    }

    @Override
    public boolean IsProblematic() {
        return isProblematic;
    }

    @Override
    public boolean IsCritical() {
        return IsProblematic();
    }
    
}
