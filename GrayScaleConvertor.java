
/**
 * Write a description of GrayScaleConvertor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class GrayScaleConvertor {
    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel px: outImage.pixels()){
            Pixel inPixel = inImage.getPixel(px.getX(), px.getY());
            
            int avg = (inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
            
            px.setRed(avg);
            px.setGreen(avg);
            px.setBlue(avg);
        }
        return outImage;
    }
    
    public void testGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    
    public void SelectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource inFile = new ImageResource(f);
            ImageResource gray = makeGray(inFile);
            String fname = f.getName();
            String newName = "gray-"+fname;
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }
    }
}
