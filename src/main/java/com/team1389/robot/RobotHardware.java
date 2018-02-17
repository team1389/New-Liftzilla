package com.team1389.robot;

import com.team1389.hardware.inputs.hardware.GyroHardware;
import com.team1389.hardware.outputs.hardware.CANTalonHardware;
import com.team1389.hardware.registry.Registry;
import com.team1389.hardware.registry.port_types.PortInstance;
import com.team1389.hardware.registry.port_types.SPIPort;

import edu.wpi.first.wpilibj.SPI;

public class RobotHardware extends RobotLayout {
	
	Registry registry;
	
	public RobotHardware()
	{
		registry = new Registry();
		initDriveTrain();
	}
	
	public Registry getRegistry()
	{
		return registry;
	}
	//The constructor GyroHardware<PortInstance>(Function<SPIPort,Gyro>, SPIPort, Registry) is undefined
	public void initDriveTrain()
	{
		leftA = new CANTalonHardware(inv_left_A, can_left_A, registry);
		leftB = new CANTalonHardware(inv_left_B, can_left_B, registry);
		rightA = new CANTalonHardware(inv_right_A, can_right_A, registry);
		rightB = new CANTalonHardware(inv_right_B, can_right_B, registry);
		
		gyro = new GyroHardware<SPIPort>(GyroHardware.NAVX, spi_GyroPort, registry);
	}
}
// Nav X
