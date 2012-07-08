package org.nyer.orm.web;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.nyer.orm.OrmContext;
import org.nyer.orm.util.PackageLoader;

/**
 * Application Lifecycle Listener implementation class OrmModelListener
 *
 */
public class OrmModelListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    private boolean recursive;
    private String packName;
    
    
    public boolean isRecursive() {
        return recursive;
    }

    public void setRecursive(boolean recursive) {
        this.recursive = recursive;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public OrmModelListener() {
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        
    }

    public void contextInitialized(ServletContextEvent sce) {
        PackageLoader loader = new PackageLoader();
        packName = sce.getServletContext().getInitParameter("packName");
        String recur = sce.getServletContext().getInitParameter("recursive");
        loader.setPackName(packName);
        loader.setRecursive(Boolean.valueOf(recur));
        List<Class<?>> clazzes = loader.load();
        OrmContext.buildOrmContext(clazzes);
    }
	
}
