package com.team1389.autos;

import com.team1389.robot.RobotConstants;

public class AutoConstants {

	public static final double BASELINE_DIST = 93.3, BASELINE_SPEED = 5;
	
	public static final double AUTO_TEST_DIS = 10, AUTO_TEST_TURN_ANGLE = 90;
	public static final boolean AUTO_TEST_ABSOLUTE = true;
	
	public static final double SWITCH_ONE_DIST = 1, SWITCH_ONE_TURN_ANGLE = 90, SWITCH_ONE_DIST_TWO = 1;
	public static final boolean SWITCH_ONE_ABSOLUTE = true;
	
	public static final double SWITCH_TWO_DIS = 1, SWITCH_TWO_TURN_ANGLE = 90, SWITCH_TWO_DIS_TWO = 1, SWITCH_TWO_TURN_ANGLE_TWO = 90,
			SWITCH_TWO_DIS_THREE = 1;
	public static final boolean SWITCH_TWO_ABSOLUTE = true, SWITCH_TWO_ABSOLUTE_TWO = true;
	
	public static final double SCALE_ONE_DIS = 1, SCALE_ONE_TURN_ANGLE = 90, SCALE_ONE_DIS_TWO = 1;
	public static final boolean SCALE_ONE_ABSOLUTE = true;
	
	public static final double SCALE_TWO_DIS = 1, SCALE_TWO_TURN_ANGLE = 90, SCALE_TWO_DIS_TWO = 1, SCALE_TWO_TURN_ANGLE_TWO = 90,
			SCALE_TWO_DIS_THREE = 1;
	public static final boolean SCALE_TWO_ABSOLUTE = true, SCALE_TWO_ABSOLUTE_TWO = true;

	public static double getRotations(double distInches)
	{
		return distInches / (RobotConstants.WheelDiameter * Math.PI);
	}

	public static double getTimeToTravel(double inches, double percentVoltage)
	{
		double inchesPerSec = RobotConstants.MaxVelocity * percentVoltage;
		return inches / inchesPerSec;
	}
}
