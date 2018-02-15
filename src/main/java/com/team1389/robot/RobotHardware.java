package com.team1389.robot;

import com.team1389.hardware.outputs.hardware.CANTalonHardware;
import com.team1389.hardware.registry.Registry;

public class RobotHardware extends RobotLayout {
	
	Registry registry;
	
	public RobotHardware()
	{
		initDriveTrain();
	}
	
	public Registry getRegistry()
	{
		return registry;
	}
	
	public void initDriveTrain()
	{
		leftA = new CANTalonHardware(inv_left_A, can_left_A, registry);
		leftB = new CANTalonHardware(inv_left_A, can_left_B, registry);
		rightA = new CANTalonHardware(inv_right_A, can_right_A, registry);
		rightB = new CANTalonHardware(inv_right_B, can_right_B, registry);
	}
}
