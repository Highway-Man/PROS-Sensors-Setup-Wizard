PROS Sensors Setup Wizard
=========================
The PROS Sensors Setup Wizard (PSSW) is a wizard for easily configuring sensors in PROS.
### Usage
To open the wizard, right click on an open project in Project Explorer and select VEX > Configure Sensors.
The wizard will first ask which sensors you are using and will then display a series of pages asking for the required information for each of the selected sensor types. Upon completion of the wizard, PSSW will automatically edit init.c and main.h as required, inserting the necessary code with the configuration specified in the wizard.

### Supported Devices
* Digital Outputs (pneumatics, LEDs, etc.)
* Gyroscope
* IMEs
* LCDs
* Optical Shaft Encoders (Quad Encoders)
* Simple Digital Inputs (limit switches, bumper switches, etc.)
* Ultrasonic Range Finders
