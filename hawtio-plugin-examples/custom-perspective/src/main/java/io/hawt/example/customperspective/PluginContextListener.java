package io.hawt.example.customperspective;

import io.hawt.web.plugin.HawtioPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * A context listener to manage this plugin's MBean registration
 */
public class PluginContextListener implements ServletContextListener {

    private static final Logger LOG = LoggerFactory.getLogger(PluginContextListener.class);

    HawtioPlugin plugin;

    public void contextInitialized(ServletContextEvent servletContextEvent) {

        /**
         * Rather than using blueprint we'll just initialize our plugin MBean
         * right here using the HawtioPlugin helper class
         */

        plugin = new HawtioPlugin();
        plugin.setContext("/custom-perspective");
        plugin.setName("custom-perspective");
        plugin.setScripts("app/js/plugin.js");
        plugin.setDomain(null);
        plugin.init();
        LOG.info("Initialized custom perspective plugin");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        plugin.destroy();
        LOG.info("Destroying custom perspective plugin");
    }

}
