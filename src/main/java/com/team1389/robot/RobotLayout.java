package com.team1389.robot;

import com.team1389.hardware.inputs.hardware.GyroHardware;
import com.team1389.hardware.inputs.hardware.PDPHardware;
import com.team1389.hardware.outputs.hardware.CANTalonHardware;
import com.team1389.hardware.outputs.hardware.DoubleSolenoidHardware;
import com.team1389.hardware.registry.port_types.SPIPort;

public class RobotLayout extends RobotMap
{
	public PDPHardware pdp;
	public CANTalonHardware leftA;
	public CANTalonHardware leftB;
	public CANTalonHardware rightA;
	public CANTalonHardware rightB;
	public GyroHardware<SPIPort> gyro;
	public DoubleSolenoidHardware flPiston, frPiston, rlPiston, rrPiston;	
}
