/*	
 * 	Copyright 2015 Jacob Knaup
 * 
 * 	This file is part of PROS Sensors Setup Wizard.
 * 
 * 	PROS Sensors Setup Wizard is free software: you can redistribute it and/or modify
 * 	it under the terms of the GNU General Public License as published by
 * 	the Free Software Foundation, either version 3 of the License, or
 * 	(at your option) any later version.
 * 
 * 	PROS Sensors Setup Wizard is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU General Public License for more details.
 * 	You should have received a copy of the GNU General Public License
 * 	along with PROS Sensors Setup Wizard.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package prossensorssetupwizard.performconfiguration;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import tk.knaup.prossensorssetupwizard.popup.actions.Selection;

//adds/replaces code in main.h and init.c
public class PerformEdits {

	// var to store the project on which to perform config
	protected static Selection selectedProject;

	// function to read and replace text in file
	public static void editFile(String fileName, String newContent,
			String oldContent) throws CoreException {
		final ByteArrayOutputStream os = new ByteArrayOutputStream(16384);
		/* Transfer contents */
		try {
			final BufferedReader br = new BufferedReader(new InputStreamReader(
					getFileInputStream(fileName)));
			final PrintWriter out = new PrintWriter(new OutputStreamWriter(os));
			String line;
			while ((line = br.readLine()) != null)
				out.println(line.replaceAll(oldContent, newContent));
			out.close();
			br.close();
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, "Error",
					e.getMessage(), e));
		}
		final ByteArrayInputStream is = new ByteArrayInputStream(
				os.toByteArray());
		final IFile file = Selection.getFileInProject(fileName);
		file.setContents(is, true, true, null);
	}

	// gets input stream from file name
	public static InputStream getFileInputStream(String fileName)
			throws CoreException {

		// create a new file
		IFile newFile = Selection.getFileInProject(fileName);

		// create closes the file stream, so no worries.
		return newFile.getContents();

	}

	// perform three edits; code needs to go in three places
	public static void performConfiguration() {

		// add most sensor code to initialize()
		String newContentInit = SensorsSetup.getAllSensorCode("init.c")
				+ "\n void initialize() { \n"
				+ SensorsSetup.getAllSensorCode("initialize");
		// add sensor structs? to main.h
		String newContentMain = "void operatorControl(); \n \n"
				+ SensorsSetup.getAllSensorCode("main.h");
		// set port states in initializeIO()
		String newContentInitIO = "void initializeIO() {\n"
				+ SensorsSetup.getInitIOCode();

		// perform the edits
		try {
			editFile("init.c", newContentInit,
					Pattern.quote("void initialize() {"));
			editFile("main.h", newContentMain,
					Pattern.quote("void operatorControl();"));
			editFile("init.c", newContentInitIO,
					Pattern.quote("void initializeIO() {"));
			System.out.println("Setup code successfully added to "
					+ Selection.getSelectedProject()
					+ "\n Thank you for using the PROS Sensors Setup Wizard");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out
					.println("There was a problem performing the sensor configuration on "
							+ Selection.getSelectedProject());
		}
	}

}
