

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
        String reg1 = ("images/RegularShowBlendedWithLogo.png");
        String reg2 = ("images/RegularShowDeepFried.png");
        String reg3 = ("images/RegularShowGreen.png");
        String reg4 = ("images/RegularShowRecursiveShrink.png");
        String reg5 = ("images/RegularShowSuperMirror.png");
        String reg6 = ("images/RegularShow.jpg");
        
        myCanvas.copyRegularShow(reg1,0,0);
        myCanvas.copyRegularShow(reg2,1280,0);
        myCanvas.copyRegularShow(reg3,0,720);
        myCanvas.copyRegularShow(reg4,1280,720);
        myCanvas.copyRegularShow(reg5,0,1440);
        myCanvas.copyRegularShow(reg6,1280,1440);
        myCanvas.write("images\\FinishedCollage.jpg");
        //reg.blend();
        //reg.deepFry();
        //reg.mirrorVerticle();
        //reg.SmallerRecursivly(1280.0,720.0, 1,reg );
        //reg.superMirror();
        //reg.superGreen();
        //reg.explore();
        //reg.write("images\\RegularShowBlendedWithLogo.png");
    }
}
