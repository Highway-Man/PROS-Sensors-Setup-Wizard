package prossensorssetupwizard.performconfiguration;

import prossensorssetupwizard.PageDigitalIn;
import prossensorssetupwizard.PageDigitalOut;
import prossensorssetupwizard.PageGyro;
import prossensorssetupwizard.PageIme;
import prossensorssetupwizard.PageLcd;
import prossensorssetupwizard.PageOne;
import prossensorssetupwizard.PageTwo;
import prossensorssetupwizard.PageUltrasonic;

public class SensorsSetup {
	
	static String getEncoderCode() {

		String encoder1Init = PageOne.enc1Name.getText() + " = encoderInit(" + PageOne.combo11.getText() + ","
				+ PageOne.combo12.getText() + "," + PageOne.enc1Rev.getSelection() + ");";

		String encoder2Init = PageOne.enc2Name.getText() + " = encoderInit(" + PageOne.combo21.getText() + ","
				+ PageOne.combo22.getText() + "," + PageOne.enc2Rev.getSelection() + ");";

		String encoder3Init = PageOne.enc3Name.getText() + " = encoderInit(" + PageOne.combo31.getText() + ","
				+ PageOne.combo32.getText() + "," + PageOne.enc3Rev.getSelection() + ");";
		
		String encoder4Init = PageOne.enc4Name.getText() + " = encoderInit(" + PageOne.combo41.getText() + ","
				+ PageOne.combo42.getText() + "," + PageOne.enc4Rev.getSelection() + ");";
		String encoder5Init = PageOne.enc5Name.getText() + " = encoderInit(" + PageOne.combo51.getText() + ","
				+ PageOne.combo52.getText() + "," + PageOne.enc5Rev.getSelection() + ");";

		String encoderAllInit;

		if (PageOne.combo51.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init + "\n" + encoder4Init + "\n" + encoder5Init;
		else if (PageOne.combo41.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init + "\n" + encoder4Init;
		else if (PageOne.combo31.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init;
		else if (PageOne.combo21.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init;
		else
			encoderAllInit = encoder1Init;

		return encoderAllInit;
	}
	
	static String getEncoderVars(){

		String encoder1Init = "Encoder " + PageOne.enc1Name.getText() + ";";

		String encoder2Init = "Encoder " + PageOne.enc2Name.getText() + ";";

		String encoder3Init = "Encoder " + PageOne.enc3Name.getText() + ";";
		
		String encoder4Init = "Encoder " + PageOne.enc4Name.getText() + ";";
		
		String encoder5Init = "Encoder " + PageOne.enc5Name.getText() + ";";

		String encoderAllInit;

		if (PageOne.combo51.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init + "\n" + encoder4Init + "\n" + encoder5Init;
		else if (PageOne.combo41.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init + "\n" + encoder4Init;
		else if (PageOne.combo31.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init;
		else if (PageOne.combo21.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init;
		else
			encoderAllInit = encoder1Init;

		return encoderAllInit;
	}

	static String gyroInit = PageGyro.gyroName.getText() + " = gyroInit("
			+ PageGyro.gyroPort.getText() + ");";
	
	static String gyroVar = "Gyro " + PageGyro.gyroName.getText() +";";

	static String getUltrasonicCode() {

		String ultrasonic1Init = PageUltrasonic.ult1Name.getText() + " = ultrasonicInit("
				+ PageUltrasonic.ult1PortEcho.getText() + ", "
				+ PageUltrasonic.ult1PortPing.getText() + ");";
		
		String ultrasonic2Init = PageUltrasonic.ult2Name.getText() + " = ultrasonicInit("
				+ PageUltrasonic.ult2PortEcho.getText() + ", "
				+ PageUltrasonic.ult2PortPing.getText() + ");";
		
		String ultrasonic3Init = PageUltrasonic.ult3Name.getText() + " = ultrasonicInit("
				+ PageUltrasonic.ult3PortEcho.getText() + ", "
				+ PageUltrasonic.ult3PortPing.getText() + ");";

		if(PageUltrasonic.ult3PortEcho.getText() != "")
			return ultrasonic1Init + "\n" + ultrasonic2Init + "\n" + ultrasonic3Init;
		else if (PageUltrasonic.ult2PortEcho.getText() != "")
			return ultrasonic1Init + "\n" + ultrasonic2Init;
		return ultrasonic1Init;
	}
	
	static String getUltrasonicVars() {

		String ultrasonic1Init = "Ultrasonic "
				+ PageUltrasonic.ult1Name.getText() +";";
		
		String ultrasonic2Init = "Ultrasonic " + ";";
		
		String ultrasonic3Init = "Ultrasonic " + ";";

		if(PageUltrasonic.ult3PortEcho.getText() != "")
			return ultrasonic1Init + "\n" + ultrasonic2Init + "\n" + ultrasonic3Init;
		else if (PageUltrasonic.ult2PortEcho.getText() != "")
			return ultrasonic1Init + "\n" + ultrasonic2Init;
		return ultrasonic1Init;
	}
	
	static String getImeCode(){
		return "int " + PageIme.countName.getText() + " = imeInitializeAll();";
	}
	
	static String getLcdCode(){
		String lcd1Init = "lcdInit(uart1);\n" + "lcdClear(uart1);";
		String lcd2Init = "lcdInit(uart2);" + "\n" + "lcdClear(uart2);";
		if(PageLcd.checkLcd1.getSelection() && PageLcd.checkLcd1.getSelection())
			return lcd1Init + "\n" + lcd2Init;
		else if(PageLcd.checkLcd1.getSelection())
			return lcd1Init;
		else if (PageLcd.checkLcd2.getSelection())
			return lcd2Init;
		else return null;
	}
	
	static String getInputsCode(){
		String inputsCode = "";
		for(int i=1; i < 13; i++){
			if(PageDigitalIn.checkDig[i].getSelection())
				inputsCode = inputsCode + "pinMode(" + i + ", INPUT);" + "\n";
		}
		return inputsCode;
	}
	
	static String getOutputsCode(){
		String outputsCode = "";
		for(int i=1; i<13; i++){
			if(PageDigitalOut.checkDig[i].getSelection())
				outputsCode = outputsCode + "digitalWrite(" + i + ", LOW);" + "\n" + "pinMode(" + i + ", OUTPUT);" + "\n";
		}
		return outputsCode;
	}
	
	public static String getAllSensorCode(String where) {
		String encoder, gyro, ultrasonic, ime, lcd;
		encoder = gyro = ultrasonic = ime = lcd = "";
		
		if (PageTwo.getCheckSelection(PageTwo.check1)){
			if (where == "initialize")
				encoder = getEncoderCode() + "\n";
			else if(where == "init.c")
				encoder = getEncoderVars() + "\n";
			else if (where == "main.h")
				encoder = "extern " + getEncoderVars() + "\n";				
		}
		if (PageTwo.getCheckSelection(PageTwo.check2)){
			if(where == "initialize")
				gyro = gyroInit + "\n";
			else if(where == "init.c")
				gyro = gyroVar + "\n";
			else if(where == "main.h")
				gyro = "extern " + gyroVar + "\n";
		}
		if (PageTwo.getCheckSelection(PageTwo.checkUlt)){
			if(where == "initialize")
				ultrasonic = getUltrasonicCode() + "\n";
			else if(where == "init.c")
				ultrasonic = getUltrasonicVars() + "\n";
			else if(where == "main.h")
				ultrasonic = "extern " + getUltrasonicVars() + "\n";
		}
		if (PageTwo.getCheckSelection(PageTwo.checkIme)){
			if(where == "initialize")
				ime = getImeCode() + "\n";
		}
		if (PageTwo.getCheckSelection(PageTwo.checkLcd)){
			if(where == "initialize")
			lcd = getLcdCode() + "\n";
		}
		
		return encoder + gyro + ultrasonic + ime + lcd;		
	}
	
	public static String getInitIOCode(){
		String inputs = "";
		String outputs = "";
		if (PageTwo.checkInput.getSelection())
			inputs = getInputsCode() + "\n";
		if (PageTwo.checkOutput.getSelection())
			outputs = getOutputsCode() + "\n";
		return inputs + outputs;
	}
	

}
