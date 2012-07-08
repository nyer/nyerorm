package org.nyer.orm.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class PackageLoader {
    //是否遍历，默认否
    private boolean recursive=false;
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

    public  List<Class<?>> load(){
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String packDir = packName.replace(".", "/");
        Enumeration<URL> resources = null;
        try {
           resources =  Thread.currentThread().getContextClassLoader().getResources(packDir);
        } catch (IOException e) {
            e.printStackTrace();
            return classes;
        }
        while(resources.hasMoreElements()){
            URL url = resources.nextElement();
            if(url.getProtocol().equals("file")){//
                String path = "";
                try {
                    path = URLDecoder.decode(url.getFile(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                this.findAndAddClasses(packName,path, classes);
            }else{
                //目前不处理Jar
            }
        }
        return classes;
    }
    
    public  void findAndAddClasses(String packName,String path,List<Class<?>> results){
        File file = new File(path);
        if(!file.exists()){
            return;
        }
        
        File[] files = file.listFiles(new FileFilter() {
            
            public boolean accept(File file) {
               if(file.getName().endsWith(".class") ||(recursive && file.isDirectory())){
                   return true;
               }
               return false;
            }
        });
        for(File f:files){
            if(f.isDirectory()){
                this.findAndAddClasses(packName + "." + f.getName(),f.getAbsolutePath(), results);
            }else{
                String className = f.getName().substring(0,f.getName().length() -6);
                try {
                    results.add(Thread.currentThread().getContextClassLoader().loadClass(packName + "." + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        PackageLoader loader = new PackageLoader();
        loader.setRecursive(true);
        loader.setPackName("org.nyer.orm");
        List<Class<?>> classes = loader.load();
        for(Class<?> clazz:classes)
            System.out.println(clazz.getName());
    }
}
