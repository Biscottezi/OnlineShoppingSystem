/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author ASUS
 */
public class uploadFile implements Serializable{
    private static final String UPLOAD_DIR = "img";
    
    public static String uploadFile(HttpServletRequest request) throws IOException, ServletException {
                String fileName = "";
                try {
                    Part filePart = request.getPart("photo");
                    fileName = (String) getFileName(filePart);

                    String applicationPath = request.getServletContext().getRealPath("");
                    String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
                    InputStream inputStream = null;
                    OutputStream outputStream = null;
                    try {
                        File outputFilePath = new File(basePath + fileName);
                        inputStream = filePart.getInputStream();
                        outputStream = new FileOutputStream(outputFilePath);
                        int read = 0;
                        final byte[] bytes = new byte[1024];
                        while ((read = inputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                fileName = "";
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }

        } catch (IOException | ServletException e) {
            fileName = "";
        }
        return fileName;
    }
    
    public static String uploadFiles(HttpServletRequest request) throws IOException, ServletException {
                String fileName = "";
                try {
                    String applicationPath = request.getServletContext().getRealPath("");
                    String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
                    InputStream inputStream = null;
                    OutputStream outputStream = null;
                    
                    ArrayList<Part> filePart = (ArrayList<Part>)request.getParts();
                    for(int i = 0; i<filePart.size(); i++){
                        fileName = (String) getFileName(filePart.get(i));
                        try {
                            File outputFilePath = new File(basePath + fileName);
                            inputStream = filePart.get(i).getInputStream();
                            outputStream = new FileOutputStream(outputFilePath);
                            int read = 0;
                            final byte[] bytes = new byte[1024];
                            while ((read = inputStream.read(bytes)) != -1) {
                                outputStream.write(bytes, 0, read);
                            }
                        } catch (Exception e) {
                            fileName = "";
                        } finally {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                        }
                    }
                } catch (IOException | ServletException e) {
                    fileName = "";
                }
                return fileName;
    }
    
    
    

    public static String getFileName(Part part) {       
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }

        return null;
    }
}
