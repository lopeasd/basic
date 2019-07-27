package com.learn.jvm;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.sql.Driver;
import java.util.StringTokenizer;

/**
 * @Description 查看启动，扩展，系统加载器，加载那个目录下的包
 * @Author shixiaofei
 * @Date 2019/7/27 8:43
 * @Version 1.0
 */
public class ClassLoaderDirsExample {


    public static void main(String[] args) {


        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }

        ClassLoader cs;



        URLClassLoader cl;


        System.out.println("=============查看类加载器是从哪个包下加载的类===============");
        ProtectionDomain pd = Driver.class.getProtectionDomain();
        CodeSource codeSource = pd.getCodeSource();
        System.out.println(codeSource);
        System.out.println("extDirs2");

        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

    }

    private static File[] getExtDirs() {
        //加载<JAVA_HOME>/lib/ext目录中的类库
        String s = System.getProperty("java.ext.dirs");
        File[] dirs;
        if (s != null) {
            StringTokenizer st =
                    new StringTokenizer(s, File.pathSeparator);
            int count = st.countTokens();
            dirs = new File[count];
            for (int i = 0; i < count; i++) {
                dirs[i] = new File(st.nextToken());
            }
        } else {
            dirs = new File[0];
        }
        return dirs;
    }
}
