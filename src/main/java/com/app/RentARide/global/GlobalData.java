package com.app.RentARide.global;

import java.util.ArrayList;
import java.util.List;

import com.app.RentARide.entity.Vehicle;

public class GlobalData {
	public static List<Vehicle> cart;
	static {
		cart=new ArrayList<>();
	}
}
