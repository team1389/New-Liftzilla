package com.team1389.autonomous;

public enum AutonOption {
	DRIVE_STRAIGHT("Drive Stright"), TEST_SENSORS("Test Sensors");

	public final String name;

	AutonOption(String name) {
		this.name = name;
	}
}
