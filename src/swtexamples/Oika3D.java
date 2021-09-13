package swtexamples;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Oika3D {

	protected Shell shlOikad;
	private Composite leftComposite;
	private Composite camControl;
	private Composite JmeCanvas;
	private Composite camView;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Oika3D window = new Oika3D();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlOikad.open();
		shlOikad.layout();
		while (!shlOikad.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlOikad = new Shell();
		shlOikad.setSize(450, 300);
		shlOikad.setText("Oika3D");
		shlOikad.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(shlOikad, SWT.NONE);
		sashForm.setSashWidth(2);
		
		leftComposite = new Composite(sashForm, SWT.NONE);
		
		SashForm sashForm_1 = new SashForm(sashForm, SWT.NONE);
		
		camControl = new Composite(sashForm_1, SWT.BORDER);
		camControl.setLayout(new GridLayout(1, false));
		new Label(camControl, SWT.NONE).setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		
		Label lblNewLabel = new Label(camControl, SWT.NONE);
		lblNewLabel.setText("Sum");
		
		Label lblNewLabel_1 = new Label(camControl, SWT.NONE);
		lblNewLabel_1.setText("Minus");

		new Label(camControl, SWT.NONE).setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		
		Label lblNewLabel_2 = new Label(camControl, SWT.NONE);
		lblNewLabel_2.setText("Up");
		
		Label lblNewLabel_3 = new Label(camControl, SWT.NONE);
		lblNewLabel_3.setText("Down");
		
		Label lblNewLabel_4 = new Label(camControl, SWT.NONE);
		lblNewLabel_4.setText("Right");
		
		Label lblNewLabel_5 = new Label(camControl, SWT.NONE);
		lblNewLabel_5.setText("Left");
		new Label(camControl, SWT.NONE).setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		
		JmeCanvas = new Composite(sashForm_1, SWT.NONE);
		
		camView = new Composite(sashForm_1, SWT.BORDER);
		RowLayout rl_camView = new RowLayout(SWT.VERTICAL);
		rl_camView.center = true;
		rl_camView.fill = true;
		rl_camView.justify = true;
		camView.setLayout(rl_camView);
		
		Button btnNewButton = new Button(camView, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println("Top Camera View");
			}
		});
		btnNewButton.setText("Top");
		
		Button btnNewButton_1 = new Button(camView, SWT.NONE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println("Rear Camera View");
			}
		});
		btnNewButton_1.setText("Rear");
		
		Button btnNewButton_2 = new Button(camView, SWT.NONE);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println("Side Camera View");
			}
		});
		btnNewButton_2.setText("Side");
		
		Button btnNewButton_3 = new Button(camView, SWT.NONE);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println("Isometric Camera View");
			}
		});
		btnNewButton_3.setText("Isom");
		sashForm_1.setWeights(new int[] {1, 6, 1});
		sashForm.setWeights(new int[] {2, 8});

	}

}
