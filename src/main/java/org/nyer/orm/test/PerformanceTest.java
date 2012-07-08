package org.nyer.orm.test;

import java.util.List;

import org.nyer.orm.OrmContext;
import org.nyer.orm.util.PackageLoader;

import junit.framework.TestCase;

public class PerformanceTest extends TestCase{
    @Override
    protected void setUp() throws Exception {
        PackageLoader loader = new PackageLoader();
        loader.setPackName("org.nyer.copyright.guessfb.model");
        loader.setRecursive(Boolean.valueOf(true));
        List<Class<?>> clazzes = loader.load();
        OrmContext.buildOrmContext(clazzes);
    }
    public void testQuery() throws Exception {
        
    }
}
