package com.team1389.robot;

import com.team1389.hardware.registry.port_types.CAN;
import com.team1389.hardware.registry.port_types.SPIPort;

import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
	
	//Drivetrain
	protected final CAN can_left_A = new CAN(10);
	protected final CAN can_left_B = new CAN(8);
	protected final CAN can_right_A = new CAN(12);
	protected final CAN can_right_B = new CAN(7);
	
	protected final boolean inv_left_A = true;
	protected final boolean inv_left_B = true;
	protected final boolean inv_right_A = true;
	protected final boolean inv_right_B = true;
	
	protected final SPIPort spi_GyroPort = new SPIPort(SPI.Port.kOnboardCS0);
}
