                  /*  File:  polar3AA.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class polar3AA extends Template {

     static {templateClass = new polar3AA() ; }

     public void setup() {
          filePrefix = "polar3AA" ;  // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 6.0*0.35 ;      // in inches
          ysize = 1.6*0.35 ;   // in inches. 
          xmin = -3.5 ;
          xmax = 4.0 ;
          ymin = -0.1 ;
          ymax =  1.5 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          double R = 0.4 ;
          double r = 0.1 ;

          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0,xmax,0) ;
          fLine(0,ymin,0,ymax) ;
          fTeXlabel(xmax+0.05,0.0, "lc", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fEllipticalArc(0, 0, R, R, 0, 180, OPEN) ;
          fTeXlabel(-0.65*R, 0.85*R, "br", "$\\pi$") ;

          double x1 = 3  ; double y1 = 0 ;
          double x2 = -3  ; double y2 = 0 ;
 
          fEnv("useColorPs", "true") ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "0 0.53333 0.8 setrgbcolor  " ;
          String Pink = "1 0.3333 0.6666 setrgbcolor  " ;
          String Orange = "0.93333 0.46666 0.2 setrgbcolor  " ;

          fEnv("lineWidth", 2.0) ;
          canvas.append( new fPsWrite(Orange+"\n")) ;
          fLine(0, 0,  xmax, 0) ;
          fDisk(x1,y1, r, r, FILLED) ;
          fTeXlabel(x1,y1+0.1, "bc", "$(3,0)$") ;
          fTeXlabel(x1,y1-0.15, "tc", "$r=-3,\\ \\theta=\\pi$") ;

          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(0, 0,  xmin, 0) ;
          fDisk(x2,y2, r, r, FILLED) ;
          fTeXlabel(x2,y2+0.1, "bc", "$(-3,0)$") ;
          fTeXlabel(x2,y2-0.15, "tc", "$r=3,\\ \\theta=\\pi$") ;

     }
}
