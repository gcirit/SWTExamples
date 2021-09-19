package swtexamples;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

 

public class RawDataExample {

 

    public static void main(String[] args) {

       Display display = new Display();

       Shell shell = new Shell(display);
       shell.setSize(572, 85);

       RowLayout rl_shell = new RowLayout();
       shell.setLayout(rl_shell);

       Button button1 = new Button(shell, SWT.PUSH);

       button1.setText("Button 1");

       button1.setLayoutData(new RowData(50, 40));

       Button button2 = new Button(shell, SWT.PUSH);

       button2.setText("Button 2");

       button2.setLayoutData(new RowData(50, 30));

       Button button3 = new Button(shell, SWT.PUSH);

       button3.setText("Button 3");

       button3.setLayoutData(new RowData(50, 20));

       shell.pack();
       
       Button btnNewButton = new Button(shell, SWT.NONE);
       btnNewButton.setText("New Button");

       shell.open();

       while (!shell.isDisposed()) {

          if (!display.readAndDispatch()) display.sleep();

       }
    }
}
  
