package prossensorssetupwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class PageLcd extends WizardPage {
	
	private Composite container;
	public static Button checkLcd1;
	public static Button checkLcd2;
	public static boolean complete;

	public PageLcd() {
		super("Lcd Page");
		setTitle("LCD Configuration");
		setDescription("Configure up to 2 LCDs on the selected uart port(s)");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		GridData gd = new GridData(SWT.LEFT, SWT.FILL, false, false);
		gd.widthHint = SWT.DEFAULT;
		gd.heightHint = SWT.DEFAULT;
		gd.horizontalSpan = 1;

		Label labelCheckLcd1 = new Label(container, SWT.NONE);
		labelCheckLcd1.setText("uart1");
		checkLcd1 = new Button(container, SWT.CHECK);
		checkLcd1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				setPageComplete(true);
				complete = true;
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Label labelCheckLcd2 = new Label(container, SWT.NONE);
		labelCheckLcd2.setText("uart2");
		checkLcd2 = new Button(container, SWT.CHECK);
		checkLcd2.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				setPageComplete(true);
				complete=true;
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			}
		});

		setControl(container);
		setPageComplete(false);
	}

}
