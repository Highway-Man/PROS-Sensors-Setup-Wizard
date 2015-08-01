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

public class PageDigitalOut extends WizardPage{
	
	private Composite container;
	public static Button[] checkDig;	
	public static boolean complete = false;
	
	public PageDigitalOut(){
		super("General Digital Output Page");
		setTitle("Digital Output Configuration");
		setDescription("Configure general digital outputs such as pneumatic solenoids and LEDs");
	}
	
	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		GridData gd2 = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd2.horizontalSpan = 2;
		
		GridData gd1 = new GridData(SWT.LEFT, SWT.FILL, false, false);
		gd1.horizontalSpan = 1;
		
		Label instructions = new Label(container, SWT.NONE);
		instructions.setText("Select the ports to use as digital outputs for pneumatic solenoids, LEDs, etc.");
		instructions.setLayoutData(gd2);

		Label[] labelPort = new Label[13];
		checkDig = new Button[13];
		for(int i = 1; i < 13; i++){
			checkDig[i] = new Button(container, SWT.CHECK);
			checkDig[i].setLayoutData(gd1);
			checkDig[i].addSelectionListener(new SelectionListener() {
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
			labelPort[i] = new Label(container, SWT.NONE);
			labelPort[i].setText("Digital " + i);
			labelPort[i].setLayoutData(gd1);
		}
		
		setControl(container);
		setPageComplete(false);
	}
	
	void newSelectedPorts(){
		for(int i=1; i<14; i++){
			if(checkDig[i].getSelection())
				SetupWizard.selectedPort[i] = true;
		}
	}

}