package prossensorssetupwizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;

import prossensorssetupwizard.performconfiguration.PerformEdits;



public class SetupWizard extends Wizard{
	
	public static Composite container;
	
	protected PageEncoder encoder;
	protected PageInitial initial;
	protected PageGyro gyro;
	protected PageUltrasonic ultrasonic;
	protected PageIme ime;
	protected PageLcd lcd;
	protected PageDigitalIn input;
	protected PageDigitalOut output;
	protected PageEnd end;
	
	boolean canFinish = false;
	public static boolean selectedPort[];
	
	public SetupWizard(){
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle(){
		return "Export My Data";
	}
	
	@Override
	public void addPages(){
		encoder = new PageEncoder();
		initial = new PageInitial();
		gyro = new PageGyro();
		ultrasonic = new PageUltrasonic();
		ime = new PageIme();
		lcd = new PageLcd();
		input = new PageDigitalIn();
		output = new PageDigitalOut();
		end = new PageEnd();
		addPage(initial);
		addPage(encoder);
		addPage(gyro);
		addPage(ultrasonic);
		addPage(ime);
		addPage(lcd);
		addPage(input);
		addPage(output);
		addPage(end);
	}
	
	
	@Override
	public IWizardPage getNextPage(IWizardPage currentPage) {
	    if (PageInitial.getCheckSelection(PageInitial.check1) && !PageEncoder.complete) 
	       return encoder;
	    else if (PageInitial.getCheckSelection(PageInitial.check2) && !PageGyro.complete)
	    	return gyro;
	    else if (PageInitial.getCheckSelection(PageInitial.checkUlt) && !PageUltrasonic.complete)
	    	return ultrasonic;
	    else if(PageInitial.getCheckSelection(PageInitial.checkIme) && !PageIme.complete)
	    	return ime;
	    else if (PageInitial.getCheckSelection(PageInitial.checkLcd) && !PageLcd.complete)
	    	return lcd;
	    else if (PageInitial.getCheckSelection(PageInitial.checkInput) && !PageDigitalIn.complete)
	    	return input;
	    else if (PageInitial.getCheckSelection(PageInitial.checkOutput) && !PageDigitalOut.complete)
	    	return output;
	    else{ 
	    	canFinish = true;
	        return end;
	    }
	} 
	
	@Override
	public boolean canFinish(){
		return canFinish;
	}
		
	@Override
	public boolean performFinish(){
						
		PerformEdits.performConfiguration();
		
		return true;
	}
	
	

}
