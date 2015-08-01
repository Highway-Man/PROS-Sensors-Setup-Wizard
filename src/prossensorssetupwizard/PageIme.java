package prossensorssetupwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class PageIme extends WizardPage{

	private Composite container;
	public static Text countName;
	public static boolean complete;

	public PageIme() {
		super("IME Page");
		setTitle("IME Configuration");
		setDescription("Configure IMEs on the I2C port");
	}
	
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		GridData gd2 = new GridData(SWT.LEFT, SWT.FILL, true, false);
		gd2.widthHint = SWT.DEFAULT;
		gd2.heightHint = SWT.DEFAULT;
		gd2.horizontalSpan = 2;
		
		GridData gd1 = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd1.horizontalSpan = 1;

		Label label1 = new Label(container, SWT.NONE);
		label1.setText("Enter the name for the variable in which to store the number of initialized IMEs");
		label1.setLayoutData(gd2);
		countName = new Text(container, SWT.BORDER | SWT.SINGLE);
		countName.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				setPageComplete(true);
				complete = true;
			}
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		countName.setLayoutData(gd1);

		setControl(container);
		setPageComplete(false);
	}
	
	
}
