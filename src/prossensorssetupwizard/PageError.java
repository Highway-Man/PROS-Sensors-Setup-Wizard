package prossensorssetupwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class PageError extends WizardPage {

	private Composite container;

	public PageError() {
		super("Error Page");
		setTitle("Error");
		setDescription("Conflicting ports!");
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

		Label label1 = new Label(container, SWT.NONE);
		label1.setText("The same digital port has been selected for multiple sensors. Please go back and change the selected ports.");
		label1.setLayoutData(gd2);

		setControl(container);
		setPageComplete(false);
	}
}