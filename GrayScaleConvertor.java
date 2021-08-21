
/**
 * Write a description of GrayScaleConvertor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class GrayScaleConvertor {
    //create a function makeGray with a return type ImageResource, pass the image
    // as argument
    public ImageResource makeGray(ImageResource inImage){
        
        //create a resultant image of same size of the inImage
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        //use for loop to iterate over each pixel
        for(Pixel px: outImage.pixels()){
            //get the size of each pixel and store it in a new variable inPixel
            Pixel inPixel = inImage.getPixel(px.getX(), px.getY());
            
            //to make the pixel gray, its rgb value will be set to the average 
            // of Red, Green and Blue values
            int avg = (inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
            
            //set r,g and b value to average value of rgb value
            px.setRed(avg);
            px.setGreen(avg);
            px.setBlue(avg);
        }
        
        //return the resultant image
        return outImage;
    }
    
    //test function
    public void testGray(){
        //create a variable ir of type Image to select the image
        ImageResource ir = new ImageResource();
        //call the makeGray function and store the resultant image in variable gray
        ImageResource gray = makeGray(ir);
        
        //draw() function is used to display the resultant image
        gray.draw();
    }
    
    //converting many images at once
    public void SelectAndConvert(){
        //Directory resource is used to select many images at once
        DirectoryResource dr = new DirectoryResource();
        //use for loop to iterate over each image file
        for(File f: dr.selectedFiles()){
            //store the file as image in a new variable inFile of Image type
            ImageResource inFile = new ImageResource(f);
            //call the function makeGray and store the resultant image in variable gray
            ImageResource gray = makeGray(inFile);
            
            //use getName() to get the name of the file
            String fname = f.getName();
            //add gray to the file name
            String newName = "gray-"+fname;
            
            //set the new file name to the resultant image
            gray.setFileName(newName);
            //display the image
            gray.draw();
            //save() is java's in-built function to save the image or file
            gray.save();
        }
    }
}
