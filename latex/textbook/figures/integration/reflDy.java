                  /*  File:  reflDy.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class reflDy extends Template {

     static {templateClass = new reflDy() ; }

     public void setup() {
          filePrefix = "reflDy" ; // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.5*1.3 ;      // in inches
          ysize = 1.0*1.3 ;   // in inches. This gives ysize/xsize ~ golden ratio.
          xmin = -75 ;
          xmax =  75 ;
          ymin = -25 ;
          ymax = 75 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
         String White  = "1 1 1 setrgbcolor  " ;
          String Black  = "0 0 0 setrgbcolor  " ;
          String Yellow = "0.86667 0.66667 0.2 setrgbcolor  " ;
          String Red    = "0.73333 0.33333 0.4 setrgbcolor  " ;
          String Blue   = "      0 0.26667 0.53333 setrgbcolor  " ;
          String LtBlue   = "0.2     0.6     0.8 setrgbcolor  " ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0, xmax, 0) ;
          fLine( 0, ymin, 0, ymax) ;
          double x1 = 10 ; double y1 =  60 ;
          double x2 = 60 ; double y2 = 50 ;
          double x3 = 0 ; double y3 = 0 ;
          double r = 2.5 ;

          fEnv("psFillGray", 0.8) ;
          { 
            double[] xlist = { x1, x2, x3} ;
            double[] ylist = { y1, y2, y3} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }     
          fTeXlabel(25, 43, "ct", "$\\mathcal{R}$") ;

          fEnv("psFillGray", 0.6) ;
          { 
            double[] xlist = {-x1,-x2,-x3} ;
            double[] ylist = { y1, y2, y3} ;
            fPolygon(xlist, ylist, 3, FILLED) ;
           }    
          fTeXlabel(-23, 43, "ct", "$\\mathcal{R}_y$") ;
 

          fEnv("lineWidth", 1.5) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Yellow+"\n")) ;
          fLine(x1,y1, x2,y2) ;
          fLine(-x1,y1, -x2,y2) ;

          fEnv("psFillColor", Red) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fDisk(x1, y1, r, r, FILLED) ;
          fLine(x1,y1, x3,y3) ;
          fTeXlabel(x1+2, y1+1, "bl", "$(1,6)$") ;
          fDisk(-x1, y1, r, r, FILLED) ;
          fLine(-x1,y1, x3,y3) ;
          fTeXlabel(-x1-2, y1+1, "br", "$(-1,6)$") ;

          fEnv("psFillColor", Blue) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fDisk(x2, y2, r, r, FILLED) ;
          fDisk(-x2, y2, r, r, FILLED) ;
          fLine(x2,y2, x3,y3) ;
          fLine(-x2,y2, x3,y3) ;
          fTeXlabel(x2+2, y2, "cl", "$(6,5)$") ;
          fTeXlabel(-x2-2, y2, "cr", "$(-6,5)$") ;

          fTeXlabel(xmax, -2, "tr", "$x$") ;
          fTeXlabel(-1, ymax, "tr", "$y$") ;
          fTeXlabel(0, ymin-3, "tc", "$\\mathcal{R}_y=$reflection of $\\mathcal{R}$ across the $y$-axis") ;




     }
}
