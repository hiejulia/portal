package com.baeldung.spring.util;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
//import com.fasterxml.uuid.Generators;
//import com.leeyonsoft.clonepintrest.application.*;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;


public class ImageUtil {

    // save image
    public static String saveImage(byte[] inputBytes)
    {
//        String largeImageFilePath="";
//        try
//        {
//            String fileName=Generators.randomBasedGenerator().generate().toString()+".jpg";
//            String fileFullPath=SiteSettings.LargeImageFilePath+fileName;
//            File dest=new File(fileFullPath);
//            FileUtils.writeByteArrayToFile(dest, inputBytes);
//            largeImageFilePath=fileName;
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        return largeImageFilePath;
        return "";
    }


    public static String resizeImage(String originalImageFileName,
                                     int resizedWidth) throws IOException {

     /*   *//*String originalImageFilePath=SiteSettings.LargeImageFilePath+originalImageFileName;*//*

        File originalImage = new File(originalImageFilePath);

        BufferedImage originalBfImage = ImageIO.read(originalImage);

        int originalImageWidth=originalBfImage.getWidth();

        int originalImageHeight=originalBfImage.getHeight();

        int resizedImageHeight=(resizedWidth*originalImageHeight)/originalImageWidth;

        BufferedImage tagBfImage=new BufferedImage(resizedWidth, resizedImageHeight, BufferedImage.TYPE_INT_RGB);

        tagBfImage.getGraphics().drawImage(originalBfImage, 0, 0, resizedWidth, resizedImageHeight, null);

        String thumbnailImagePath=SiteSettings.ThumbnailFilePath+originalImageFileName;

        FileOutputStream fileOutStream=new FileOutputStream(thumbnailImagePath);

        JPEGImageEncoder JpgEncoder=JPEGCodec.createJPEGEncoder(fileOutStream);

        JpgEncoder.encode(tagBfImage);

        fileOutStream.close();

        return thumbnailImagePath;

*/
        return "";
    }

}