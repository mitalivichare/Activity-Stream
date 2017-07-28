package com.stackroute.activitystream.circleservice;

import java.util.List;

public interface CircleDAO 
{
	public boolean createCircle(Circle circle);
	public boolean updateCircle(Circle circle);
	public boolean deleteCircle(int circleId);
	public Circle getCircleByCircleId(int circleId);
	public Circle getCircleByCircleName(String circleName);
	public List<Circle> getAllCircles();

}
