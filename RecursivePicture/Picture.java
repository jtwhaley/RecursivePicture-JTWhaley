//Hello Mr. Hayes, this is that guy that forgot to put his name on everything.
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }
  public void gray()
  {
      Pixel[] pixelArray = this.getPixels();
      Pixel pixel = null;
      int intensity = 0;

      for (int i = 0; i < pixelArray.length; i++)
      {
          //get the current pixel
          pixel = pixelArray[i];

          //compute the intensity of the pixel (average value)
          intensity = (int) ((pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3);

          //set the pixel color to the new color
          pixel.setColor(new Color(intensity,intensity,intensity));
      }
  }

  public void copyRegularShow(/*sourceFile*/)
    {
      String sourceFile = ("images\\RegularShow.jpg");
      Picture sourcePicture = new Picture(sourceFile);

      Pixel sourcePixel = null;
      Pixel targetPixel = null;


      //width of source must be = or < the canvas I am copying to
      //loop through the columns
      for (int sourceX = 0, targetX = 0;
           sourceX < sourcePicture.getWidth();
           sourceX++, targetX++)
      {
            for (int sourceY = 0, targetY = 0;
                sourceY < sourcePicture.getHeight();
                sourceY++, targetY++)
            {
                sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
                targetPixel = this.getPixel(targetX,targetY);
                targetPixel.setColor(sourcePixel.getColor());
            }
      }
  }
  /**
   * Method to mirror around a verticle line in the middle
   * of the picture based on the width
   */
  public void mirrorVerticle(/*sourceFile*/)
  {
      int width = this.getWidth();
      int mirrorPoint = width/2;
      
      Pixel lp = null; //Left Pixel
      Pixel rp = null; //Right Pixel
      
      //loop through all of the rows.
      for(int y = 0; y<getHeight(); y ++)
      {
          //Loop from 0 to the middle point.
          for (int x = 0; x < mirrorPoint; x++)
          {
              lp = getPixel(x,y);
              rp = getPixel(width - 1 - x,y);
              rp.setColor(lp.getColor());
            }
          
        }
  }
  /**
   * Method to mirror around a Horizontal line in the middle
   * of the picture based on the height
   */
  public void mirrorHorizontal(/*sourceFile*/)
  {
      int height = this.getHeight();
      int mirrorPoint = height/2;
      
      Pixel lp = null; //Left Pixel
      Pixel rp = null; //Right Pixel
      
      //loop through all of the rows.
      for(int x = 0; x<getWidth(); x ++)
      {
          //Loop from 0 to the middle point.
          for (int y = 0; y < mirrorPoint; y++)
          {
              lp = getPixel(x,y);
              rp = getPixel(x,height - 1 - y);
              rp.setColor(lp.getColor());
            }
          
        }
  }
      public void copyRegularShowSmaller()
  {
      Picture butterfly = (new Picture("images\\RegularShow.jpg"));

      Pixel sourcePixel = null;
      Pixel targetPixel = null;


      //width of source must be = or < the canvas I am copying to
      //loop through the columns
      for (int sourceX = 0, targetX = 0;
           sourceX < butterfly.getWidth();
           sourceX+=2, targetX++)
      {
            for (int sourceY = 0, targetY = 0;
                sourceY < butterfly.getHeight();
                sourceY+=2, targetY++)
            {
                sourcePixel = butterfly.getPixel(sourceX,sourceY);
                targetPixel = this.getPixel(targetX,targetY);
                targetPixel.setColor(sourcePixel.getColor());
            }
      }
           
  }
  public void blend()
  {
      Picture logo = new Picture("images/cartoonNetworkLogo.png");
      
      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      
      for (int sourceX = 0, targetX = 0;
           sourceX < logo.getWidth();
           sourceX++, targetX++)
      {
            for (int sourceY = 0, targetY = 0;
                sourceY < logo.getHeight();
                sourceY++, targetY++)
            {
                sourcePixel = logo.getPixel(sourceX,sourceY);
                targetPixel = this.getPixel(targetX,targetY);
                Color color = new Color((sourcePixel.getRed() /2)+ (targetPixel.getRed() /2),(sourcePixel.getGreen() /2)+ (targetPixel.getGreen() /2),
                (sourcePixel.getBlue() /2)+ (targetPixel.getBlue() /2));
                targetPixel.setColor(color);
            }
      }
    }
  public void deepFry()
  {
      String sourceFile = ("images\\RegularShow.jpg");
      Picture sourcePicture = new Picture(sourceFile);

      Pixel sp1 = null;
      Pixel sp2 = null;
      Pixel sp3 = null;
      Pixel sp4 = null;
      Pixel sp5 = null;
      Pixel sp6 = null;
      Pixel sp7 = null;
      Pixel sp8 = null;
      Pixel sp9 = null;
      
      Pixel tp1 = null;
      Pixel tp2 = null;
      Pixel tp3 = null;
      Pixel tp4 = null;
      Pixel tp5 = null;
      Pixel tp6 = null;
      Pixel tp7 = null;
      Pixel tp8 = null;
      Pixel tp9 = null;


      //width of source must be = or < the canvas I am copying to
      //loop through the columns
      for (int sourceX = 1, targetX = 1;
           sourceX < sourcePicture.getWidth()-10;
           sourceX+= 3, targetX+=3)
      {
            for (int sourceY = 1, targetY = 1;
                sourceY < sourcePicture.getHeight()-10;
                sourceY+=3, targetY+=3)
            {
               
                sp1 = sourcePicture.getPixel(sourceX,sourceY);
                sp2 = sourcePicture.getPixel(sourceX-1,sourceY-1);
                sp3 = sourcePicture.getPixel(sourceX-1,sourceY);
                sp4 = sourcePicture.getPixel(sourceX-1,sourceY+1);
                sp5 = sourcePicture.getPixel(sourceX,sourceY+1);
                sp6 = sourcePicture.getPixel(sourceX,sourceY-1);
                sp7 = sourcePicture.getPixel(sourceX+1,sourceY);
                sp8 = sourcePicture.getPixel(sourceX+1,sourceY+1);
                sp9 = sourcePicture.getPixel(sourceX+1,sourceY-1);
                
                double red = Math.random()*80;
                double green = Math.random()*40;
                double blue = Math.random()*60;
                
                double yeet =(sp1.getRed() + sp2.getRed() + sp3.getRed() + sp4.getRed() + sp5.getRed() + sp6.getRed() + sp7.getRed() + sp8.getRed() + sp9.getRed())/9 + red;
                double yeet2 = (255-sp1.getGreen() + sp2.getGreen() + sp3.getGreen() + sp4.getGreen() + sp5.getGreen() + sp6.getGreen() + sp7.getGreen() + sp8.getGreen() + sp9.getGreen())/9 + green;
                double yeet3 = sp1.getBlue() + sp2.getBlue() + sp3.getBlue() + sp4.getBlue() + sp5.getBlue() + sp6.getBlue() + sp7.getBlue() + sp8.getBlue() + sp9.getBlue()/9 + blue;
                if(yeet > 255)
                    yeet = 255 - Math.random()*255;
                if (yeet2 > 255)
                    yeet2 = 255 - Math.random()*255;
                if (yeet3 > 255)
                    yeet3 = 255 - Math.random()*255;
                
                Color color = new Color((int)yeet,(int)yeet2,(int)yeet3);
                
                
                tp1 = this.getPixel(targetX,targetY);
                tp2 = this.getPixel(targetX-1,targetY-1);
                tp3 = this.getPixel(targetX-1,targetY);
                tp4 = this.getPixel(targetX-1,targetY+1);
                tp5 = this.getPixel(targetX,targetY+1);
                tp6 = this.getPixel(targetX,targetY-1);
                tp7 = this.getPixel(targetX+1,targetY);
                tp8 = this.getPixel(targetX+1,targetY+1);
                tp9 = this.getPixel(targetX+1,targetY-1);
            
                tp1.setColor(color);
                tp2.setColor(color);
                tp3.setColor(color);
                tp4.setColor(color);
                tp5.setColor(color);
                tp6.setColor(color);
                tp7.setColor(color);
                tp8.setColor(color);
                tp9.setColor(color);
            
            }
      }
      sourceFile = ("images\\Shrek.png");
      sourcePicture = new Picture(sourceFile);

      Pixel sourcePixel = null;
      Pixel targetPixel = null;


      //width of source must be = or < the canvas I am copying to
      //loop through the columns
      for (int sourceX = 0, targetX = 400;
           sourceX < sourcePicture.getWidth();
           sourceX++, targetX++)
      {
            for (int sourceY = 0, targetY = 220;
                sourceY < sourcePicture.getHeight()-10;
                sourceY++, targetY++)
            {
                sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
                if (sourcePixel.getRed() != 0 && sourcePixel.getGreen() != 0 && sourcePixel.getBlue() != 0)
                {
                    targetPixel = this.getPixel(targetX + (sourceY%10),targetY);
                    targetPixel.setColor(sourcePixel.getColor());
                }
            }
      }
      
    }
  public void SmallerRecursivly(double width, double height, int n, Picture reg)
  {

      Pixel sourcePixel = null;
      Pixel targetPixel = null;
      
       n++;
      if (n >6)
      {
          
        }
      else{

      //width of source must be = or < the canvas I am copying to
      //loop through the columns
      for (int sourceX = 0, targetX = 0;
           sourceX < width;
           sourceX+=2, targetX++)
      {
            for (int sourceY = 0, targetY = 0;
                sourceY < height;
                sourceY+=2, targetY++)
            {
                sourcePixel = reg.getPixel(sourceX,sourceY);
                targetPixel = this.getPixel(targetX,targetY);
                targetPixel.setColor(sourcePixel.getColor());
            }
      }
      SmallerRecursivly(width/2, height/2,n,reg);
    }
           
  }

} // this } is the end of class Picture, put all new methods before this
