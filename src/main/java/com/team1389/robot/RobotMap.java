package com.team1389.robot;

import com.team1389.hardware.registry.port_types.CAN;

public class RobotMap {
	
	//Drivetrain
	protected final CAN can_left_A = new CAN(1);
	protected final CAN can_left_B = new CAN(1);
	protected final CAN can_right_A = new CAN(1);
	protected final CAN can_right_B = new CAN(1);
	
	protected final boolean inv_left_A = true;
	protected final boolean inv_left_B = true;
	protected final boolean inv_right_A = true;
	protected final boolean inv_right_B = true;
}
