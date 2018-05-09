

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
        //reg.deepFry();
        //reg.mirrorVerticle();
        //reg.SmallerRecursivly(1280.0,720.0, 1,reg );
        //reg.superMirror();
        reg.superGreen();
        reg.explore();
        
    }
}
