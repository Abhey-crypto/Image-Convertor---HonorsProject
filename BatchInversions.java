
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class BatchInversions{
    //create a function makeGray with a return type ImageResource, pass the image
    // as argument
    public ImageResource makeInversion(ImageResource inImage){
        
        //create a resultant image of same size of the inImage
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        //use for loop to iterate over each pixel
        for(Pixel px: outImage.pixels()){
            
            //get the size of each pixel and store it in a new variable inPixel
            Pixel inPixel = inImage.getPixel(px.getX(), px.getY());
            
            //to invert the image subtarct the actual red, green and blue value
            //from 255 and it will produce a negative of image
            //do it for all Red, Green and Blue pixel.
            px.setRed(255 - inPixel.getRed());
            px.setGreen(255 - inPixel.getGreen());
            px.setBlue(255 - inPixel.getBlue());
        }
        
        //return the resultant image
        return outImage;
    }
    
    //test function
    public void testGray(){
        //create a variable ir of type Image to select the image
        ImageResource ir = new ImageResource();
        //call the makeGray function and store the resultant image in variable gray
        ImageResource invert = makeInversion(ir);
        
        //draw() function is used to display the resultant image
        invert.draw();
    }
    
    public void SelectAndConvert(){
        //Directory resource is used to select many images at once
        DirectoryResource dr = new DirectoryResource();
        //use for loop to iterate over each image file
        for(File f: dr.selectedFiles()){
            //store the file as image in a new variable inFile of Image type
            ImageResource inFile = new ImageResource(f);
            //call the function makeGray and store the resultant image in variable gray
            ImageResource invert = makeInversion(inFile);
            
            //use getName() to get the name of the file
            String fname = f.getName();
            //add gray to the file name
            String newName = "inverted-"+fname;
            
            //set the new file name to the resultant image
            invert.setFileName(newName);
            //display the image
            invert.draw();
            //save() is java's in-built function to save the image or file
            invert.save();
        }
    }
}

