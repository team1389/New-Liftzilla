package com.team1389.robot;

import com.team1389.hardware.inputs.hardware.PDPHardware;
import com.team1389.hardware.inputs.hardware.SpartanGyro;
import com.team1389.hardware.outputs.hardware.CANTalonHardware;
import com.team1389.hardware.outputs.hardware.DoubleSolenoidHardware;

public class RobotLayout extends RobotMap
{
	public PDPHardware pdp;
	public CANTalonHardware leftA;
	public CANTalonHardware leftB;
	public CANTalonHardware rightA;
	public CANTalonHardware rightB;
	public SpartanGyro gyro;
	public DoubleSolenoidHardware flPiston, frPiston, rlPiston, rrPiston;	
}
