package com.team1389.autonomous;

import com.team1389.auto.AutoModeBase;
import com.team1389.auto.AutoModeEndedException;
import com.team1389.robot.RobotSoftware;
import com.team1389.util.Timer;
import com.team1389.util.list.AddList;
import com.team1389.watch.Watchable;

public class Movement extends AutoModeBase{

	RobotSoftware robot; 
	double time;
	double voltage;
	Timer timer;
	
	public Movement(double voltage, double time, RobotSoftware robot)
	{
		this.voltage = voltage;
		this.time = time;
		this.robot = robot;
		timer.zero();
	}
	
	public void go()
	{
		robot.leftA.getVoltageController().set(voltage);
		robot.leftB.getVoltageController().set(voltage);
		robot.rightA.getVoltageController().set(voltage);
		robot.rightB.getVoltageController().set(voltage);

	}
	
	public void stop()
	{
		robot.leftA.getVoltageController().set(0);
		robot.leftB.getVoltageController().set(0);
		robot.rightA.getVoltageController().set(0);
		robot.rightB.getVoltageController().set(0);
	}
	
	
	@Override
	public AddList<Watchable> getSubWatchables(AddList<Watchable> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void routine() throws AutoModeEndedException {
		while(time <= timer.get())
		{
			go();
		}
		
		stop();		
	}

}
