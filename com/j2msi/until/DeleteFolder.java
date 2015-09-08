/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2msi.until;

import java.io.File;

/**
 *
 * @author xxxff
 */
public class DeleteFolder {

//       public   void deleteDirSub(File dir) {
//        if (dir.isDirectory()) {
//            String[] children = dir.list();
// 
//            for (int i=0; i<children.length; i++) {
//                //  deleteDirSub(new File(dir, children[i]));
//                File f=new File(dir, children[i]);
//                f.delete();
//                  
//            }
//        }
//    }
//       
//        public   boolean deleteDirAll(File dir) {
//        if (dir.isDirectory()) {
//            String[] children = dir.list();
// 
//            for (int i=0; i<children.length; i++) {
//                boolean success = deleteDirAll(new File(dir, children[i]));
//                if (!success) {
//                    return false;
//                }
//            }
//        }
//        return dir.delete();
//    }
    public   boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);
                delFolder(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }

    public   void delFolder(String folderPath) {
        try {
            delAllFile(folderPath);
            String filePath = folderPath;
            filePath = filePath.toString();
            java.io.File myFilePath = new java.io.File(filePath);
            myFilePath.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        DeleteFolder df = new DeleteFolder();

        String filepath = "C:\\Documents and Settings\\xxxff\\Desktop\\b";
        File f = new File(filepath);
        df.delAllFile(filepath);
        //df.deleteDirSub(f);
        //df.deleteDirAll(f);
    }
}
