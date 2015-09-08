/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2msi.until;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xxx
 */
public class CopyAll {
    
    
    static String url1="C:\\Documents and Settings\\xx\\Desktop\\b\\";
    
    static String url2="C:\\Documents and Settings\\xx\\Desktop\\a\\";
    
    
    
    
   public void  copyFile(String oldPath, String newPath) { 
       try { 
           int bytesum = 0; 
           int byteread = 0; 
           File oldfile = new File(oldPath); 
           if (oldfile.exists()) {  
               InputStream inStream = new FileInputStream(oldPath);  
               FileOutputStream fs = new FileOutputStream(newPath); 
               byte[] buffer = new byte[1444]; 
               int length; 
               while ( (byteread = inStream.read(buffer)) != -1) { 
                   bytesum += byteread;  
                   System.out.println(bytesum); 
                   fs.write(buffer, 0, byteread); 
               } 
               inStream.close(); 
           } 
       } 
       catch (Exception e) { 
           System.out.println("xxxx"); 
           e.printStackTrace(); 
       } 
   } 
     
   public void  copyFolder(String oldPath, String newPath) { 
       try { 
           (new File(newPath)).mkdirs(); 
           File a=new File(oldPath); 
           String[] file=a.list(); 
           File temp=null; 
           for (int i = 0; i < file.length; i++) { 
               if(oldPath.endsWith(File.separator)){ 
                   temp=new File(oldPath+file[i]); 
               } 
               else{ 
                   temp=new File(oldPath+File.separator+file[i]); 
               } 
               if(temp.isFile()){ 
                   FileInputStream input = new FileInputStream(temp); 
                   FileOutputStream output = new FileOutputStream(newPath + "/" + 
                           (temp.getName()).toString()); 
                   byte[] b = new byte[1024 * 5]; 
                   int len; 
                   while ( (len = input.read(b)) != -1) { 
                       output.write(b, 0, len); 
                   } 
                   output.flush(); 
                   output.close(); 
                   input.close(); 
               } 
               if(temp.isDirectory()){ 
                   copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]); 
               } 
           } 
       } 
       catch (Exception e) { 
           System.out.println("xxxx"); 
           e.printStackTrace(); 
       } 
   }
   
   
   
   public static void copyFilefromjar(Class clazz,String targetfilepath,String fileinjarpath) {
        //  System.out.println(getP_sourcebase() + wixscript + "\\" + targetfile);
        //String newfile = getP_targetbase() + wixscript + "\\" + "main.wxs";
       String newfile = targetfilepath;

        File newf = new File(newfile);
        if (!newf.exists()) {
            try {
                newf.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(clazz.getName()).log(Level.SEVERE, null, ex);
            }
        }

        BufferedReader br = null;
        BufferedWriter bw = null;

        //byte[] chars = new byte[1024];
        try {
           
            //InputStream input = clazz.getResource("/j2msi/logic/main.wxs").openStream();
            InputStream input = clazz.getResource(fileinjarpath).openStream();
            //System.out.println ( this .getClass () .getResource ( "/ conf.ini " )) ;
            br = new BufferedReader(new InputStreamReader(input));
            bw = new BufferedWriter(new FileWriter(newf));
            String copystr = null;
            while (true) {
                copystr = br.readLine();
                if (copystr == null) {
                    break;
                } else {
                    bw.write(copystr + "\n");
                }

            }

            bw.close();
            br.close();
            input.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(clazz.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clazz.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   public static void main(String args[]){
    CopyAll bp = new CopyAll();
    bp.copyFolder(url1,url2);
   }
}
