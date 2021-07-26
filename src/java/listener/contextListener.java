/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author ASUS
 */
public class contextListener implements ServletContextListener {
    
    private final String siteMapFileName = "SiteMap.txt";
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        Map<String, String> siteMap = new HashMap<>();
        String realPath = sc.getRealPath("/");

        String filePath = realPath + "WEB-INF/" + siteMapFileName;
        File file = new File(filePath);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line, "=");
                String label = tokenizer.nextToken().trim();
                String source = tokenizer.nextToken().trim();
                siteMap.put(label, source);
            }

        } catch (FileNotFoundException ex) {
            sc.log("ServletListener FileNotFoundException: " + ex.getMessage());
        } 

        sc.setAttribute("SITE_MAP_ATTRI", siteMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
