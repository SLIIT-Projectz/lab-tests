package com.test3;

import java.util.ArrayList;

public class AlarmApp {

	public static void main(String[] args) {
		ArrayList<AlarmClock> store = new ArrayList<>();
		AlarmClock ac1 = new AlarmClock();
		AlarmClock ac2 = new AlarmClock();
		
		ac1.InputAlarm();
		ac2.InputAlarm();
		store.add(ac1);
		store.add(ac2);
		
		for(AlarmClock ob: store) {
			ob.ShowAlarm();
		}
	}

}
