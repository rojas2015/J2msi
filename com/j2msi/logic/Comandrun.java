/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j2msi.logic;

import com.j2msi.until.CopyAll;
import com.j2msi.until.DeleteFolder;
import com.j2msi.until.StreamGobbler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 

import java.util.logging.Level;
import java.util.logging.Logger;
 
 
 

/**
 *
 * @author Mr xxx
 */
public class Comandrun {
 
	//String targetfilewix=System.getProperty("user.home")+"\\wix";
	//String targetfilewix="C:\\Documents and Settings\\xxx\\wix";
	String targetfilewix="C:\\wix";
	//String targetfilewix="C:\\Documents and Settings\\xxx\\Desktop\\abc"+"\\wix";
	//System.getProperty("java.io.tmpdir");
	
	//String targetfilewix=System.getProperty("java.io.tmpdir")+"wix";
	//String targetfilewix="C:\\"+"\\wix";
	String targetfilepath=targetfilewix+"\\bin\\";

    //String p_APPname = "EXEapp";
    // String installfolderName = "My" + p_APPname;
    //source folder
    // String p_sourcebase = "C:\\Documents and Settings\\xxxff\\Desktop\\formfragment\\";
    private String p_jdkpath = "";

    private String p_APPname = "";
    private String installfolderName = "";
    private String p_sourcebase = "\\";
    private String p_targetbase = "\\";
    private String StandloneJre = "";

    //ico
    private String EXEappicofile = "";

//-appclass hnt.HNT -BjvmOptions=-Xmx1024m -BjvmOptions=-Xms512m
    private String appclass = "";
    private String BjvmOptions_Xmx = "";
    private String BjvmOptions_Xms = "";

    private String Bdescription = "";

    String exefolder = "exefolder";
    private String wixscript = "wixscript";
    String runtime = "runtime";
    
    //private String p_sourcepath = getP_sourcebase()  + exefolder;

    // this.getP_targetbase()  + exefolder;
    private String p_targetpath = "";
    String middlepath = exefolder + "\\exedir\\bundles\\";
// getP_sourcebase() + middlepath + getP_APPname();
    private String filepaths = "";

    static String ludeVariablesName = "ludeVariables.wxi";
    private static String heatfile_AppwxsName = "heatfile_App.wxs";
    private static String main_wxsName = "main.wxs";

    String appsource = "appsource";
    // format ico size 48x48
    //getP_sourcepath() + "\\" + appsource + "\\EXEapp.ico";
    String EXEappico = "";

    public void initComandrun() {

        appclass = getAppclass();
        BjvmOptions_Xmx = getBjvmOptions_Xmx();
        BjvmOptions_Xms = getBjvmOptions_Xms();
        //p_jdkpath = "C:\\Program Files\\Java\\javakit-8\\jdk1.8.0_51\\bin";
        p_jdkpath = getP_jdkpath();

        //Clean();
        p_APPname = getP_APPname();
        installfolderName = getInstallfolderName();
        p_targetpath = getP_targetbase() + exefolder;
        filepaths = getP_targetbase() + middlepath + getP_APPname();
        setFilepaths(filepaths);
        setWixscript("wixscript");
        
        //EXEappico = p_targetpath + "\\" + appsource + "\\"+p_APPname+".ico";
        EXEappico = EXEappicofile;
        //create wixscript folder

        Bdescription = p_APPname + " setup !";
        CreateWixscriptFolder();
    }

    public void Cleantargetbase() {
        DeleteFolder df = new DeleteFolder();
        df.delAllFile(getP_targetbase());
    }

    public void CreateWixscriptFolder() {
        String wixscriptpath = getP_targetbase() + wixscript;
        File f = new File(wixscriptpath);
        if ((f.exists() && !f.isDirectory()) || (!f.exists())) {
            f.mkdir();
            System.out.println(" create folder wixscripath");
        }
    }

    
      public void replaceJRE() {

        String url1 = getStandloneJre();
        String url2 = filepaths+"\\jre" ;
        if(!url1.equals("")&&url1!=null){
        	 //clean  
            DeleteFolder df = new DeleteFolder();
            df.delAllFile(url2);

            CopyAll bp = new CopyAll();
            bp.copyFolder(url1, url2);
        }
        
       
        
//         String targetfilepath_2 =  url2 + "\\bin\\" + "msvcr100.dll";
//        String fileinjarpath_2="/j2msi/logic/msvcr100.dll";
//        CopyAll.copyFilefromjar(Comandrun.class,targetfilepath_2, fileinjarpath_2);
        
        
        
//        //msvcp100.dll
//        //msvcr100.dll      
//        //packager.dll
//        String targetfilepath_1 =  url2 + "\\bin\\" + "msvcp100.dll";
//        String fileinjarpath_1="/j2msi/logic/msvcp100.dll";
//        CopyAll.copyFilefromjar(Comandrun.class,targetfilepath_1, fileinjarpath_1);
        
       
       
//        String targetfilepath_3 =  url2 + "\\bin\\" + "packager.dll";
//        String fileinjarpath_3="/j2msi/logic/packager.dll";
//        CopyAll.copyFilefromjar(Comandrun.class,targetfilepath_3, fileinjarpath_3);

    }
         
      
      
    public void copySource() {

        String url1 = getP_sourcebase();
        //url2 = getP_targetbase() + exefolder + "\\" + appsource;
        String url2=this.getFilepaths();
        CopyAll bp = new CopyAll();
        bp.copyFolder(url1, url2);

    }
   public void Createexefolder(){
       
       String strfolder=this.getFilepaths();
       File f=new File(strfolder);
       if(!f.exists()){
           f.mkdirs();
       }
       
   }
    
    public void copyIco() {
        String striconew = this.getFilepaths() + "\\" + this.getP_APPname() + ".ico";
        File fnew = new File(striconew);

        String strico = this.getEXEappicofile();
        File f = new File(strico);
        
        CopyAll ca = new CopyAll();
        ca.copyFile(strico, striconew);
    }
    
    //main.wxs
    public void copymainwxs() {
        String targetfilepath = getP_targetbase() + wixscript + "\\" + "main.wxs";
        String fileinjarpath="/com/j2msi/logic/main.wxs";
        CopyAll.copyFilefromjar(Comandrun.class,targetfilepath, fileinjarpath);
    }

    // copyUidll   //WixUIExtension.dll
    public void copyUidll() {
        //WixUIExtension.dll
        String targetfilepath = getP_targetbase() + wixscript + "\\" + "WixUIExtension.dll";
        String fileinjarpath="/com/j2msi/logic/WixUIExtension.dll";
        CopyAll.copyFilefromjar(Comandrun.class,targetfilepath, fileinjarpath);
  
    }

   

    public boolean productExe() {

        boolean issuccess = false;
        //C:\Documents and Settings\xxx\bin>java -jar "C:\Documents and Settings\dist\J2MSI.jar"
        
        //String cmdstr="cmd.exe /k start/wait  javapackager.exe -deploy -name EXEapp -Bdescription=\"This is test fragment\" -Bvendor=\"EXEapp\" -Btitle=\"EXEapp selector\" -BappVersion=\"1.0.1\" -Bidentifier=\"20150817\" -Bcopyright=\"copyright EXEapp@2015\" -BmenuHint=true -BshortcutHint=true -appclass hnt.HNT -BjvmOptions=-Xmx1024m -BjvmOptions=-Xms512m  -Bicon=less.ico   -native image -srcdir appsource -outdir exedir -outfile ProductName";
        // String cmdstr="cmd.exe /c start/wait  javapackager.exe -deploy -name EXEapp -Bdescription=\"This is test fragment\" -Bvendor=\"EXEapp\" -Btitle=\"EXEapp selector\" -BappVersion=\"1.0.1\" -Bidentifier=\"20150817\" -Bcopyright=\"copyright EXEapp@2015\" -BmenuHint=true -BshortcutHint=true -appclass hnt.HNT -BjvmOptions=-Xmx1024m -BjvmOptions=-Xms512m  -Bicon=less.ico   -native image -srcdir appsource -outdir exedir -outfile ProductName";
        // System.out.println(System.getenv("path"));
       // jdkfolder       
        //System.out.println(" crun  path"+Comandrun.class.getClass().getResource("/jdk1.8.0_51/bin").getPath());
        //Comandrun.class.getClass().getResource("/")
        //jdk1.8.0_51\bin
        //String tmpjdk=Comandrun.class.getClass().getResource("/jdk1.8.0_51/bin").getPath();
        
        
        //p_jdkpath
        String cmdstr = p_jdkpath + "\\javapackager.exe -deploy -name " + p_APPname + " -Bdescription=\"" + Bdescription + "\" -Bvendor=\"EXEapp\" -Btitle=\"EXEapp selector\" -BappVersion=\"1.0.1\" -Bidentifier=\"20150817\" -Bcopyright=\"copyright EXEapp@2015\" -BmenuHint=true -BshortcutHint=true -appclass " + getAppclass() + " -BjvmOptions=-Xmx" + getBjvmOptions_Xmx() + "m -BjvmOptions=-Xms" + getBjvmOptions_Xms() + "m  -Bicon=\"" + EXEappico + "\"   -native image -srcdir appsource -outdir exedir -outfile ProductName";
        //System.out.println(cmdstr);
        //File dir = new File(getP_sourcepath()); p_targetpath
        File dir = new File(p_targetpath);
        Process p;
         
            try {
				p = Runtime.getRuntime().exec(cmdstr, null, dir);
				// int timelast= p.waitFor();
	            // p.waitFor(20,TimeUnit.SECONDS);
	            StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "ERROR");
	            // kick off stderr  
	            errorGobbler.start();

	            StreamGobbler outGobbler = new StreamGobbler(p.getInputStream(), "STDOUT");
	            // kick off stdout  
	            outGobbler.start();

	            p.waitFor();
	            System.out.println(" productExe executed  time last!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        //Logger.getLogger(Comandrun.class.getName()).log(Level.SEVERE, null, ex);
        //ShowDialogbox("Exe has formed! folder is:" + filepaths);

        return issuccess;
    }

	String[] classNames = { "candle.exe", "candle.exe.config", "darice.cub",
			"dark.exe", "dark.exe.config", "difxapp_x64.wixlib",
			"difxapp_x86.wixlib", "heat.exe", "heat.exe.config",
			"insignia.exe", "insignia.exe.config", "light.exe",
			"light.exe.config", "lit.exe", "lit.exe.config", "lux.exe",
			"lux.exe.config", "LuxTasks.dll", "melt.exe", "melt.exe.config",
			"mergemod.cub", "mergemod.dll",
			"Microsoft.Deployment.Compression.Cab.dll",
			"Microsoft.Deployment.Compression.dll",
			"Microsoft.Deployment.Resources.dll",
			"Microsoft.Deployment.WindowsInstaller.dll",
			"Microsoft.Deployment.WindowsInstaller.Package.dll",
			"mspatchc.dll", "nit.exe", "nit.exe.config", "pyro.exe",
			"pyro.exe.config", "shine.exe", "shine.exe.config", "smoke.exe",
			"smoke.exe.config", "ThmViewer.exe", "torch.exe",
			"torch.exe.config", "wconsole.dll", "winterop.dll", "wix.dll",
			"WixBalExtension.dll", "WixComPlusExtension.dll", "WixCop.exe",
			"WixDependencyExtension.dll", "WixDifxAppExtension.dll",
			"WixDirectXExtension.dll", "WixFirewallExtension.dll",
			"WixGamingExtension.dll", "WixIIsExtension.dll",
			"WixLuxExtension.dll", "WixMsmqExtension.dll",
			"WixNetFxExtension.dll", "WixPSExtension.dll",
			"WixSqlExtension.dll", "WixTagExtension.dll", "WixTasks.dll",
			"WixUIExtension.dll", "WixUtilExtension.dll", "WixVSExtension.dll"

	};
    public void copyWixtotemp() {
    	
    	File fbase=new File(targetfilepath);
    	if(!fbase.exists()){
    		fbase.mkdirs();
    	}
     
        //InputStream  input=Comandrun.class.getResourceAsStream(fileinjarpath);
     	String packageName="com/wix/bin/";
		//List<String> classNames = PackageUtil.getClassName(packageName, false);
		System.out.println("copyWixtotemp classNames--->"+classNames);
		if (classNames != null) {
			for (String className : classNames) {
				//String filename=className.substring(className.lastIndexOf("\\")+1);
				String filename=className;
				CopyAll.copyFilefromjarv2(Comandrun.class,targetfilepath+filename, "/"+packageName+filename);
			}
		}
		    
    }
    
    public void CleanTempWix(){
    	DeleteFolder df = new DeleteFolder();
        df.delAllFile(targetfilewix);
    }
    
    //folder exedir  
    public static void main(String[] args) {
    	
        Comandrun c = new Comandrun();
      // System.out.println(c.getFileRealPath("")) ;
       //c.copyWixtotemp();
     
		  //c.productHeatfilestest("");
		//test create folder 
		   // c.CreateWixscriptFolder();
		
		//        c.productExe();
		  
		  //  c.productHeatfilestest("");
		
		
		//        c.productludeVariables("");
		//        c.writerludeVariablestoTagetfiles(c.getMain_wxsName());
		//        c.writerludeVariablestoTagetfiles(c.getHeatfile_AppwxsName());
		//        c.productInstaller("");
		// copy WixUIExtension.dll
		//productMainwxs()   // Mainwxs  need to complete  template 
		   
     
    }
     public boolean productHeatfiles(String filepath) {

         //heat dir "C:\Documents and Settings\xxxff\Desktop\formfragment\exefolder\exedir\bundles\EXEapp" -dr installfolder -cg MyExeGroup -gg -gl -sf - srd -var "var.exefolder" -out ".\heatfile_Exe.wxs"
    	 //String cmdHeatstr ="\""+targetfilepath+"heat.exe"+ " dir\" \"" + getFilepaths() + "\" -dr INSTALLFOLDER -cg MyAppGroup -gg -sreg -var \"var.exefolder\" -out \"" + this.getP_targetbase() + wixscript +"\\"+ "heatfile_App.wxs";
    	  String cmdHeatstr = targetfilepath+"heat.exe "+ " dir \"" + getFilepaths() + "\" -dr INSTALLFOLDER -cg MyAppGroup -gg -sreg -var \"var.exefolder\" -out \"" + this.getP_targetbase() + wixscript +"\\"+ "heatfile_App.wxs";
    
        File dir = new File(getP_targetbase() + wixscript);

        Process p;
      
            try {
				p = Runtime.getRuntime().exec(cmdHeatstr, null, dir);
				StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "ERROR");
	            // kick off stderr  
	            errorGobbler.start();

	            StreamGobbler outGobbler = new StreamGobbler(p.getInputStream(), "STDOUT");
	            // kick off stdout  
	            outGobbler.start();

	            p.waitFor();

				//long keep=10;
				//p.waitFor(keep,TimeUnit.SECONDS);
	            System.out.println(" productHeatfiles executed  time last!");

	            p.destroy();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
        boolean issuccess = false;
        return issuccess;
    }
 

    // include ludeVariables.wxi  to Heatfiles
    // <?include $(sys.CURRENTDIR)\ludeVariables.wxi ?>
    public void writerludeVariablestoTagetfiles(String targetfile) {
        // main_wxsName heatfile_AppwxsName
        String insertstr = "<?include $(sys.CURRENTDIR)\\ludeVariables.wxi ?>";
      
        StringBuilder  s= new StringBuilder();
 
        //String wixscript="wixscript";
        //   String p_sourcebase="C:\\Documents and Settings\\xxxff\\Desktop\\formfragment\\";
        //C:\Documents and Settings\xxxff\Desktop\formfragment\wixscript\ludeVariables.wxi
        File f = new File(getP_targetbase() + wixscript + "\\" + targetfile);
        System.out.println(getP_targetbase() + wixscript + "\\" + targetfile);
        
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Comandrun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        BufferedReader br = null;
        String input = null;

        try {
            FileReader fr = new FileReader(f);
            br = new BufferedReader(fr);

            while ((input = br.readLine()) != null) {
                
                if (input.trim().equals("<Wix xmlns=\"http://schemas.microsoft.com/wix/2006/wi\">")) {
                    s.append(insertstr);
                }
               
                 s.append(input.trim());
                 s.append("\n");
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Comandrun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Comandrun.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
        	
        	  File fnew = new File(getP_targetbase() + wixscript + "\\" + targetfile);
              if(fnew.exists()){
            	  fnew.delete();
            	  fnew.createNewFile();
              }else{
            	  try {
            		  fnew.createNewFile();
                  } catch (IOException ex) {
                      Logger.getLogger(Comandrun.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
      
              String stnew= "<?"+s.toString().substring(s.toString().indexOf("xml"));
              
        	
			FileWriter fw=  new FileWriter(fnew);
			
			fw.write(stnew);
			//fw.write(s.toString(),2,s.toString().length()-2);
			fw.flush();
			fw.close();
			 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }

    //ludeVariables.wxi  
    public void productludeVariables(String filepath) {

        StringBuilder s = new StringBuilder();

        s.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
                .append("\n")
                .append(" <Include>")
                .append("\n")
                .append("<?define Basefolder=\"")
                .append(getFilepaths())
                .append("\"?>")
                .append("\n")
                .append("<?define appfolder=\"$(var.Basefolder)\\app\"?>")
                .append("\n")
                .append("<?define exefolder=\"$(var.Basefolder)\"?> ")
                .append("\n")
                .append("<?define BasefolderApp=\"$(var.appfolder)\\\"?>")
                .append("\n")
                .append("<?define Basefoldershort=\"$(var.Basefolder)\"?>")
                .append("\n")
                .append("<?define ProductName=\"" + getP_APPname() + "\" ?>")
                .append("\n")
                .append("<?define installfolderName=\"" + getInstallfolderName() + "\" ?>")
                .append("\n")
                .append("<?define ExeName=\"" + getP_APPname() + ".exe\" ?>")
                .append("\n")
                .append("</Include>");

        //String wixscript="wixscript";
        //   String p_sourcebase="C:\\Documents and Settings\\xxxff\\Desktop\\formfragment\\";
        //C:\Documents and Settings\xxxff\Desktop\formfragment\wixscript\ludeVariables.wxi
        File f = new File(this.getP_targetbase() + wixscript + "\\" + ludeVariablesName);

        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Comandrun.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(this.getP_targetbase() + wixscript + "\\" + ludeVariablesName);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(f));
            bw.write(s.toString());
            System.out.println(s.toString());
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Comandrun.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean productInstaller(String filepath) {

        //candle.exe main.wxs heatfile_App.wxs  
        //light.exe -out testfragment.msi main.wixobj heatfile_App.wixobj
        // String filepaths=p_sourcebase+wixscript+"\\"+main_wxsName;
        //heat dir "C:\Documents and Settings\xxxff\Desktop\formfragment\exefolder\exedir\bundles\EXEapp" -dr installfolder -cg MyExeGroup -gg -gl -sf - srd -var "var.exefolder" -out ".\heatfile_Exe.wxs"
        String cmdstr_candle =targetfilepath+"candle.exe"+  " main.wxs heatfile_App.wxs ludeVariables.wxi";
        String cmdstr_light =targetfilepath+"light.exe"+ " -out " + this.getP_APPname() + ".msi main.wixobj heatfile_App.wixobj -ext WixUIExtension.dll";

        //  C:\Documents and Settings\xxxff\Desktop\formfragment\wixscript
        File dir = new File(getP_targetbase() + wixscript);
        Process p = null;

        //candle
        

            try {
				p = Runtime.getRuntime().exec(cmdstr_candle, null, dir);
				StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "ERROR");
	            // kick off stderr  
	            errorGobbler.start();

	            StreamGobbler outGobbler = new StreamGobbler(p.getInputStream(), "STDOUT");
	            // kick off stdout  
	            outGobbler.start();

	            p.waitFor();
	            //             long keep=20;
	            //             p.waitFor(keep,TimeUnit.SECONDS);
	            //            System.out.println(" productInstaller   candle executed  time last!"); 
	            p.destroy();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        

        long begin = System.currentTimeMillis();

        //light  

            try {
				p = Runtime.getRuntime().exec(cmdstr_light, null, dir);
				StreamGobbler errorGobbler2 = new StreamGobbler(p.getErrorStream(), "ERROR");
	            // kick off stderr  
	            errorGobbler2.start();

	            StreamGobbler outGobbler2 = new StreamGobbler(p.getInputStream(), "STDOUT");
	            // kick off stdout  
	            outGobbler2.start();

	            p.waitFor();
	            //             long keep=120;
	            //             p.waitFor(keep,TimeUnit.SECONDS);

	            p.destroy();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            
            long end = System.currentTimeMillis();

            System.out.println(" productInstaller   light  executed  time last!" + (end - begin));

        

        boolean issuccess = false;
       // ShowDialogbox("Installer has formed! folder is:" + getP_targetbase() + wixscript);
        return issuccess;
    }

    public void productMainwxs() {
        // filepaths \app\ico
    }

    /**
     * @return the p_APPname
     */
    public String getP_APPname() {
        return p_APPname;
    }

    /**
     * @param p_APPname the p_APPname to set
     */
    public void setP_APPname(String p_APPname) {
        this.p_APPname = p_APPname;
    }

    /**
     * @return the installfolderName
     */
    public String getInstallfolderName() {
        return installfolderName;
    }

    /**
     * @param installfolderName the installfolderName to set
     */
    public void setInstallfolderName(String installfolderName) {
        this.installfolderName = installfolderName;
    }

    /**
     * @return the p_sourcebase
     */
    public String getP_sourcebase() {
        return p_sourcebase;
    }

    /**
     * @param p_sourcebase the p_sourcebase to set
     */
    public void setP_sourcebase(String p_sourcebase) {
        this.p_sourcebase = p_sourcebase;
    }

    /**
     * @return the p_targetbase
     */
    public String getP_targetbase() {
        return p_targetbase;
    }

    /**
     * @param p_targetbase the p_targetbase to set
     */
    public void setP_targetbase(String p_targetbase) {
        this.p_targetbase = p_targetbase;
    }

    /**
     * @return the EXEappicofile
     */
    public String getEXEappicofile() {
        return EXEappicofile;
    }

    /**
     * @param EXEappicofile the EXEappicofile to set
     */
    public void setEXEappicofile(String EXEappicofile) {
        this.EXEappicofile = EXEappicofile;
    }

//    public String getP_sourcepath() {
//        return p_sourcepath;
//    }
//
//    
//    public void setP_sourcepath(String p_sourcepath) {
//        this.p_sourcepath = p_sourcepath;
//    }
    /**
     * @return the filepaths
     */
    public String getFilepaths() {
        return filepaths;
    }

    /**
     * @param filepaths the filepaths to set
     */
    public void setFilepaths(String filepaths) {
        this.filepaths = filepaths;
    }

    /**
     * @return the appclass
     */
    public String getAppclass() {
        return appclass;
    }

    /**
     * @param appclass the appclass to set
     */
    public void setAppclass(String appclass) {
        this.appclass = appclass;
    }

    /**
     * @return the BjvmOptions_Xmx
     */
    public String getBjvmOptions_Xmx() {
        return BjvmOptions_Xmx;
    }

    /**
     * @param BjvmOptions_Xmx the BjvmOptions_Xmx to set
     */
    public void setBjvmOptions_Xmx(String BjvmOptions_Xmx) {
        this.BjvmOptions_Xmx = BjvmOptions_Xmx;
    }

    /**
     * @return the BjvmOptions_Xms
     */
    public String getBjvmOptions_Xms() {
        return BjvmOptions_Xms;
    }

    /**
     * @param BjvmOptions_Xms the BjvmOptions_Xms to set
     */
    public void setBjvmOptions_Xms(String BjvmOptions_Xms) {
        this.BjvmOptions_Xms = BjvmOptions_Xms;
    }

    //ShowDialogbox("Exe has formed! folder is:");
    public   void ShowDialogbox(String messages) {
 
    }

    /**
     * @return the p_jdkpath
     */
    public String getP_jdkpath() {
        return p_jdkpath;
    }

    /**
     * @param p_jdkpath the p_jdkpath to set
     */
    public void setP_jdkpath(String p_jdkpath) {
        this.p_jdkpath = p_jdkpath;
    }

    /**
     * @return the heatfile_AppwxsName
     */
    public String getHeatfile_AppwxsName() {
        return heatfile_AppwxsName;
    }

    /**
     * @param aHeatfile_AppwxsName the heatfile_AppwxsName to set
     */
    public void setHeatfile_AppwxsName(String aHeatfile_AppwxsName) {
        heatfile_AppwxsName = aHeatfile_AppwxsName;
    }

    /**
     * @return the main_wxsName
     */
    public String getMain_wxsName() {
        return main_wxsName;
    }

    /**
     * @param aMain_wxsName the main_wxsName to set
     */
    public void setMain_wxsName(String aMain_wxsName) {
        main_wxsName = aMain_wxsName;
    }

    /**
     * @return the StandloneJre
     */
    public String getStandloneJre() {
        return StandloneJre;
    }

    /**
     * @param StandloneJre the StandloneJre to set
     */
    public void setStandloneJre(String StandloneJre) {
        this.StandloneJre = StandloneJre;
    }

    /**
     * @return the wixscript
     */
    public String getWixscript() {
        return wixscript;
    }

    /**
     * @param wixscript the wixscript to set
     */
    public void setWixscript(String wixscript) {
        this.wixscript = wixscript;
    }
}
