package prossensorssetupwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class PageTwo extends WizardPage{
	
	private Composite container;
	public static Button check2;
	public static Button check1;
	public static Button checkUlt;
	public static Button checkIme;
	public static Button checkLcd;
	public static Button checkInput;
	public static Button checkOutput;
	
	public PageTwo(){
		super("Second Page");
		setTitle("Second Page");
		setDescription("Now this is the second page");
		
	}
	
	@Override
	public void createControl(Composite parent){
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		//GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		
		Label labelCheck1 = new Label(container, SWT.NONE);
		labelCheck1.setText("Quad Encoders");
		check1 = new Button(container, SWT.CHECK);
		check1.setSelection(true);
		
		Label labelCheck2 = new Label(container, SWT.NONE);
		labelCheck2.setText("Gyroscope");
		check2 = new Button(container, SWT.CHECK);
		check2.setSelection(true);
		
		Label labelCheckUlt = new Label(container, SWT.NONE);
		labelCheckUlt.setText("Ultrasonic");
		checkUlt = new Button(container, SWT.CHECK);
		checkUlt.setSelection(true);
		
		Label labelCheckIme = new Label(container, SWT.NONE);
		labelCheckIme.setText("IME");
		checkIme = new Button(container, SWT.CHECK);
		checkIme.setSelection(true);
		
		Label labelCheckLcd = new Label(container, SWT.NONE);
		labelCheckLcd.setText("LCD");
		checkLcd = new Button(container, SWT.CHECK);
		checkLcd.setSelection(true);
		
		Label labelCheckInput = new Label(container, SWT.NONE);
		labelCheckInput.setText("General Input");
		checkInput = new Button(container, SWT.CHECK);
		
		Label labelCheckOutput = new Label(container, SWT.NONE);
		labelCheckOutput.setText("General Output");
		checkOutput = new Button(container, SWT.CHECK);
		
		setControl(container);
		setPageComplete(true);
	}
	
	public static boolean getCheckSelection(Button check){
		return check.getSelection();
	}
	

}
