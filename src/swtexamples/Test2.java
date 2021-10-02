package swtexamples;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;

public class Test2 {
    protected static final int Y_STEP = 20;
    static int shellStyle = SWT.NO_REDRAW_RESIZE | SWT.NO_BACKGROUND
            | SWT.H_SCROLL | SWT.CLOSE | SWT.V_SCROLL | SWT.RESIZE;
    static int canvasStyle = SWT.NO_REDRAW_RESIZE;// | SWT.H_SCROLL |

    // SWT.V_SCROLL;

    public static void main(String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display, shellStyle);
        shell.setLayout(new FillLayout());
        shell.setBackground(display.getSystemColor((SWT.COLOR_CYAN)));
        shell.setText("Canvas Test");
        shell.setSize(300, 200);

        final Canvas canvas = new Canvas(shell, canvasStyle);
        canvas.setLayout(new FillLayout());
        canvas.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

        final Point origin = new Point(10, 20);
        final ScrollBar hBar = shell.getHorizontalBar();
        Rectangle size = canvas.getBounds();
        hBar.setMaximum(size.width);
        hBar.setMinimum(0);

        final ScrollBar vBar = shell.getVerticalBar();
        hBar.setMaximum(size.height);
        hBar.setMinimum(0);

        // Create a paint handler for the canvas
        canvas.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent e) {
                // Do some drawing
                e.gc.drawString("Rows", origin.x, origin.y);
                e.gc.drawString("Data", 120, 20);
                for (int i = 0; i < 10; i++) {
                    e.gc.drawString("Row Header" + (i + 1), origin.x, origin.y
                            + (i + 1) * Y_STEP);
                    for (int j = 0; j < 10; j++) {
                        e.gc.drawRectangle(origin.x + 110 + (j * 20), origin.y
                                + (i + 1) * Y_STEP, 20, 20);
                        e.gc.drawString("C" + (j + 1), origin.x + 110 + 2
                                + (j * 20), origin.y + (i + 1) * Y_STEP + 1);
                    }
                }

            }

        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();

    }
}