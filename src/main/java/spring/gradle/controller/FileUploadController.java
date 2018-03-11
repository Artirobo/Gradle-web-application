package spring.gradle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by arti on 8/19/17.
 */
@Controller
public class FileUploadController {



    private static final Logger logger = LoggerFactory
            .getLogger(FileUploadController.class);

    // private static String UPLOAD_LOCATION = "C:/mytemp/";
    private static String UPLOAD_LOCATION = "/home/arti/upload/";


    @RequestMapping(value = {"/fileupload"}, method = RequestMethod.GET)
    public String welcome(Model model) {

        return  "fileupload";
    }

    @RequestMapping(value = "/fileupload/add", method = RequestMethod.POST)
    public @ResponseBody
    String uploadHandler(@RequestParam("name") String name, @RequestParam("file")MultipartFile file){
        if(file!=null){
            try {
//
////                this is a method to upload
//                //yo file ko bite stream garne
//                byte[] bytes=file.getBytes();
//                //yo file ko naam
//                String rootPath = System.getProperty("uploadfile.home");
//                //yo dir file banako
//                File dir=new File(rootPath+File.separator+"tmpFiles");
//                if(!dir.exists())
//                    dir.mkdirs();
//
//                //file server and get absolute path determine garya
//                File serverfile=new File(dir.getAbsolutePath()+File.separator+name);
//                //and yo stream garya pic upload garda.
//                BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverfile));
//
//                stream.write(bytes);
//                stream.close();
//
//
//
//                this is a  best method to copy a data location  pic in  local drive
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_LOCATION
                        + file.getOriginalFilename()));


                File serverfile=new File(UPLOAD_LOCATION+File.separator+name);

                logger.info("Server location"+serverfile.getAbsolutePath());
                return "your  succesful  upload file"+name;

            }catch (Exception e){
                return "You failed to upload " + name + " => " + e.getMessage();

            }


        }else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }


    }


    @RequestMapping(value = "/fileupload/multiple" ,method = RequestMethod.POST)
    public @ResponseBody String multipleFile(@RequestParam("name") String[] names,@RequestParam("file") MultipartFile[] files){

        if (files.length != names.length)
            return "Mandatory information missing";
        String message = "";
        //yo file ko lenght ya   file ko length
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String name = names[i];

            //yo  eauta file stream garda ko ho
            try {
//                byte[] bytes = file.getBytes();
//                String rootPath=System.getProperty("catalina.home");
//                File dir = new File(rootPath + File.separator + "tmpFiles");
//                if (!dir.exists())
//                    dir.mkdirs();
//
//
//                // Create the file on server
//                File serverFile = new File(dir.getAbsolutePath()
//                        + File.separator + name);
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(serverFile));
//                stream.write(bytes);
//                stream.close();
//
//
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_LOCATION
                        + file.getOriginalFilename()));


                File serverfile=new File(UPLOAD_LOCATION+File.separator+name);


                logger.info("Server File Location="
                        + serverfile.getAbsolutePath());

                message = message + "You successfully uploaded file=" + name
                        + "<br />";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        }
        return message;
    }




}

