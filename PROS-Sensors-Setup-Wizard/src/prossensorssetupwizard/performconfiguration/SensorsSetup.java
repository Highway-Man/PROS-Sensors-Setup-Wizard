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

import prossensorssetupwizard.PageDigitalIn;
import prossensorssetupwizard.PageDigitalOut;
import prossensorssetupwizard.PageGyro;
import prossensorssetupwizard.PageIme;
import prossensorssetupwizard.PageLcd;
import prossensorssetupwizard.PageEncoder;
import prossensorssetupwizard.PageInitial;
import prossensorssetupwizard.PageUltrasonic;

//creates code to be added to PROS files
public class SensorsSetup {
		
	//main encoder code; 1 string for each encoder
	static String getEncoderCode() {

		String encoder1Init = PageEncoder.enc1Name.getText().replaceAll("\\s","_") + " = encoderInit(" + PageEncoder.combo11.getText() + ","
				+ PageEncoder.combo12.getText() + "," + PageEncoder.enc1Rev.getSelection() + ");";

		String encoder2Init = PageEncoder.enc2Name.getText().replaceAll("\\s","_") + " = encoderInit(" + PageEncoder.combo21.getText() + ","
				+ PageEncoder.combo22.getText() + "," + PageEncoder.enc2Rev.getSelection() + ");";

		String encoder3Init = PageEncoder.enc3Name.getText().replaceAll("\\s","_") + " = encoderInit(" + PageEncoder.combo31.getText() + ","
				+ PageEncoder.combo32.getText() + "," + PageEncoder.enc3Rev.getSelection() + ");";
		
		String encoder4Init = PageEncoder.enc4Name.getText().replaceAll("\\s","_") + " = encoderInit(" + PageEncoder.combo41.getText() + ","
				+ PageEncoder.combo42.getText() + "," + PageEncoder.enc4Rev.getSelection() + ");";
		
		String encoder5Init = PageEncoder.enc5Name.getText().replaceAll("\\s","_") + " = encoderInit(" + PageEncoder.combo51.getText() + ","
				+ PageEncoder.combo52.getText() + "," + PageEncoder.enc5Rev.getSelection() + ");";

		String encoderAllInit;

		//only use strings for as many encoders as we are using
		if (PageEncoder.combo51.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init + "\n" + encoder4Init + "\n" + encoder5Init;
		else if (PageEncoder.combo41.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init + "\n" + encoder4Init;
		else if (PageEncoder.combo31.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init;
		else if (PageEncoder.combo21.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init;
		else
			encoderAllInit = encoder1Init;

		return encoderAllInit;
	}
	
	//generate code for encoder names 
	static String getEncoderVars(String where){

		String encoder1Init = "Encoder " + PageEncoder.enc1Name.getText().replaceAll("\\s","_") + ";";

		String encoder2Init = "Encoder " + PageEncoder.enc2Name.getText().replaceAll("\\s","_") + ";";

		String encoder3Init = "Encoder " + PageEncoder.enc3Name.getText().replaceAll("\\s","_") + ";";
		
		String encoder4Init = "Encoder " + PageEncoder.enc4Name.getText().replaceAll("\\s","_") + ";";
		
		String encoder5Init = "Encoder " + PageEncoder.enc5Name.getText().replaceAll("\\s","_") + ";";
		
		if(where == "main.h"){
			encoder1Init = "extern " + encoder1Init;
			encoder2Init = "extern " + encoder2Init;
			encoder3Init = "extern " + encoder3Init;
			encoder4Init = "extern " + encoder4Init;
			encoder5Init = "extern " + encoder5Init;
		}

		String encoderAllInit;

		//only use as many strings as we have encoders
		if (PageEncoder.combo51.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init + "\n" + encoder4Init + "\n" + encoder5Init;
		else if (PageEncoder.combo41.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init + "\n" + encoder4Init;
		else if (PageEncoder.combo31.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init + "\n"
					+ encoder3Init;
		else if (PageEncoder.combo21.getText() != "")
			encoderAllInit = encoder1Init + "\n" + encoder2Init;
		else
			encoderAllInit = encoder1Init;

		return encoderAllInit;
	}

	//generate gyro init code
	static String gyroInit = PageGyro.gyroName.getText().replaceAll("\\s","_") + " = gyroInit("
			+ PageGyro.gyroPort.getText() + ",0);";
	
	//generate gyro struct with gyro name
	static String gyroVar = "Gyro " + PageGyro.gyroName.getText().replaceAll("\\s","_") +";";

	//ultrasonic
	static String getUltrasonicCode() {

		String ultrasonic1Init = PageUltrasonic.ult1Name.getText().replaceAll("\\s","_") + " = ultrasonicInit("
				+ PageUltrasonic.ult1PortEcho.getText() + ", "
				+ PageUltrasonic.ult1PortPing.getText() + ");";
		
		String ultrasonic2Init = PageUltrasonic.ult2Name.getText().replaceAll("\\s","_") + " = ultrasonicInit("
				+ PageUltrasonic.ult2PortEcho.getText() + ", "
				+ PageUltrasonic.ult2PortPing.getText() + ");";
		
		String ultrasonic3Init = PageUltrasonic.ult3Name.getText().replaceAll("\\s","_") + " = ultrasonicInit("
				+ PageUltrasonic.ult3PortEcho.getText() + ", "
				+ PageUltrasonic.ult3PortPing.getText() + ");";

		if(PageUltrasonic.ult3PortEcho.getText() != "")
			return ultrasonic1Init + "\n" + ultrasonic2Init + "\n" + ultrasonic3Init;
		else if (PageUltrasonic.ult2PortEcho.getText() != "")
			return ultrasonic1Init + "\n" + ultrasonic2Init;
		return ultrasonic1Init;
	}
	
	//ultrasonic name
	static String getUltrasonicVars(String where) {
		String ultrasonic1Init = "Ultrasonic "
				+ PageUltrasonic.ult1Name.getText().replaceAll("\\s","_") +";";
		
		String ultrasonic2Init = "Ultrasonic "
				+ PageUltrasonic.ult2Name.getText().replaceAll("\\s","_") +";";
		
		String ultrasonic3Init = "Ultrasonic "
				+ PageUltrasonic.ult3Name.getText().replaceAll("\\s","_") +";";
		
		if(where == "main.h"){
			ultrasonic1Init = "extern " + ultrasonic1Init;
			ultrasonic2Init = "extern " + ultrasonic2Init;
			ultrasonic3Init = "extern " + ultrasonic3Init;
		}

		if(PageUltrasonic.ult3PortEcho.getText() != "")
			return ultrasonic1Init + "\n" + ultrasonic2Init + "\n" + ultrasonic3Init;
		else if (PageUltrasonic.ult2PortEcho.getText() != "")
			return ultrasonic1Init + "\n" + ultrasonic2Init;
		return ultrasonic1Init;
	}
	
	//ime init
	static String getImeCode(){
		return "int " + PageIme.countName.getText().replaceAll("\\s","_") + " = imeInitializeAll();";
	}
	
	//lccd init
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
	
	//generate code for setting port mode to input
	static String getInputsCode(){
		String inputsCode = "";
		for(int i=1; i < 13; i++){
			if(PageDigitalIn.checkDig[i].getSelection())
				inputsCode = inputsCode + "pinMode(" + i + ", INPUT);" + "\n";
		}
		return inputsCode;
	}
	
	//generate code for setting ports to output
	static String getOutputsCode(){
		String outputsCode = "";
		for(int i=1; i<13; i++){
			if(PageDigitalOut.checkDig[i].getSelection())
				outputsCode = outputsCode + "digitalWrite(" + i + ", LOW);" + "\n" + "pinMode(" + i + ", OUTPUT);" + "\n";
		}
		return outputsCode;
	}
	
	//string the code for the individual sensor types together
	public static String getAllSensorCode(String where) {
		String encoder, gyro, ultrasonic, ime, lcd;
		encoder = gyro = ultrasonic = ime = lcd = "";
				
		if (PageInitial.getCheckSelection(PageInitial.checkEncoder)){
			if (where == "initialize")
				encoder = getEncoderCode() + "\n";
			else if(where == "init.c")
				encoder = getEncoderVars(where) + "\n";
			else if (where == "main.h")
				encoder = getEncoderVars(where) + "\n";				
		}
		if (PageInitial.getCheckSelection(PageInitial.checkGyro)){
			if(where == "initialize")
				gyro = gyroInit + "\n";
			else if(where == "init.c")
				gyro = gyroVar + "\n";
			else if(where == "main.h")
				gyro = "extern " + gyroVar + "\n";
		}
		if (PageInitial.getCheckSelection(PageInitial.checkUlt)){
			if(where == "initialize")
				ultrasonic = getUltrasonicCode() + "\n";
			else if(where == "init.c")
				ultrasonic = getUltrasonicVars(where) + "\n";
			else if(where == "main.h")
				ultrasonic = getUltrasonicVars(where) + "\n";
		}
		if (PageInitial.getCheckSelection(PageInitial.checkIme)){
			if(where == "initialize")
				ime = getImeCode() + "\n";
		}
		if (PageInitial.getCheckSelection(PageInitial.checkLcd)){
			if(where == "initialize")
			lcd = getLcdCode() + "\n";
		}
		
		return encoder + gyro + ultrasonic + ime + lcd;		
	}
	
	//combine the code to go in initIO together into one string
	public static String getInitIOCode(){
		String inputs = "";
		String outputs = "";
		if (PageInitial.checkInput.getSelection())
			inputs = getInputsCode() + "\n";
		if (PageInitial.checkOutput.getSelection())
			outputs = getOutputsCode() + "\n";
		return inputs + outputs;
	}
	

}
