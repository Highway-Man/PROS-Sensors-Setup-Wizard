package prossensorssetupwizard.performconfiguration;

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

public class PerformEdits {

	protected static Selection selectedProject;

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

	public static InputStream getFileInputStream(String fileName)
			throws CoreException {

		// create a new file
		IFile newFile = Selection.getFileInProject(fileName);

		// create closes the file stream, so no worries.
		return newFile.getContents();

	}

	public static void performConfiguration() {
		
		String newContentInit = SensorsSetup.getAllSensorCode("init.c") + "\n void initialize() { \n" + SensorsSetup.getAllSensorCode("initialize");
		String newContentMain = "void operatorControl(); \n \n" + SensorsSetup.getAllSensorCode("main.h");
		String newContentInitIO = "void initializeIO() {\n" + SensorsSetup.getInitIOCode();
		
		try {
			editFile("init.c", newContentInit, Pattern.quote("void initialize() {"));
			editFile("main.h", newContentMain, Pattern.quote("void operatorControl();"));
			editFile("init.c", newContentInitIO, Pattern.quote("void initializeIO() {"));
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
