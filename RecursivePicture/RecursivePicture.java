

/**
 * Write a description of class RecursivePicture here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecursivePicture
{
    public static void main (String args[])
    {
        Picture myCanvas = new Picture("images/LargeCanvas.jpg");
        Picture reg = new Picture("images/RegularShow.jpg");
        //reg.blend();
        //reg.explore();
        myCanvas.deepFry();
        myCanvas.explore();
        //reg.mirrorVerticle();
        //reg.explore();
        
        
    }
}
