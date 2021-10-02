package swtexamples;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ImageTest {    
    public static void main(String[] args) {
        final Display display = new Display();

        final Image image = new Image(display,"icons/Arrow2.png");


        final Rectangle rect = image.getBounds();
        Shell shell = new Shell(display);
        shell.setText("Matrix Tranformations");
        shell.setLayout(new FillLayout());
        final Canvas canvas = new Canvas(shell, SWT.DOUBLE_BUFFERED);
        canvas.addPaintListener(new PaintListener () {
            public void paintControl(PaintEvent e) {    
                GC gc = e.gc;
                gc.setAdvanced(true);
                if (!gc.getAdvanced()){
                    gc.drawText("Advanced graphics not supported", 30, 30, true);
                    return;
                }

                // Original image
                int x = 30, y = 30;
                gc.drawImage(image, x, y); 
                x += rect.width + 30;

                Transform transform = new Transform(display);

                // Note that the tranform is applied to the whole GC therefore
                // the coordinates need to be adjusted too.

                // Reflect around the y axis.
                transform.setElements(-1, 0, 0, 1, 0 ,0);
                gc.setTransform(transform);
                gc.drawImage(image, -1*x-rect.width, y);



                // Rotate by 45 degrees 
                float cos45 = (float)Math.cos(Math.PI/4);
                float sin45 = (float)Math.sin(Math.PI/4);
                transform.setElements(cos45, sin45, -sin45, cos45, 0, 0);
                gc.setTransform(transform);
                gc.drawImage(image, x , y);

                float cos15 = (float)Math.cos(Math.PI/12);
                float sin15 = (float)Math.sin(Math.PI/12);
                transform.setElements(cos15, sin15, -sin15, cos15, 0, 0);
                gc.setTransform(transform);
                gc.drawImage(image, x+rect.width/2 , y+rect.height/2);

                transform.dispose();
            }
        });

        shell.setSize(1024, 768);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        image.dispose();
        display.dispose();
    }
}
