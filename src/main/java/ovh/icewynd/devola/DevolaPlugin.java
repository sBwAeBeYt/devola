package ovh.icewynd.devola;

import com.google.inject.Inject;
import org.apache.logging.log4j.Logger;
import org.spongepowered.api.Server;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.lifecycle.ConstructPluginEvent;
import org.spongepowered.api.event.lifecycle.StartedEngineEvent;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.plugin.builtin.jvm.Plugin;

import java.nio.file.Path;

@Plugin("devola")
public class DevolaPlugin {
    private final PluginContainer container;
    private final Path pluginDir;
    private final Logger logger;

    @Inject
    public DevolaPlugin(PluginContainer container, @ConfigDir(sharedRoot = false) Path pluginDir, Logger logger) {
        this.container = container;
        this.pluginDir = pluginDir;
        this.logger = logger;
    }

    @Listener
    public void onConstruct(ConstructPluginEvent event) {
        logger.info("Im constructed!");
    }

    @Listener
    public void onStarted(StartedEngineEvent<Server> event) {
        logger.info("Im started!");
    }
}
