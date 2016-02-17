package ch.csbe.ifa.bidirektional;

import ch.csbe.ifa.bidirektional.model.*;

public class Bidirektional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ausgabe("text", 4, 5, 6, 3);
		Person p = new Person();
		Person p1 = new Person();
		Person p2 = new Person();
		Auto a = new Auto(p1);
		Auto a1 = new Auto(p2);
		p.setAuto(a);
		p1.setAuto(a);
		p.setAuto(a1);
	
		
		System.out.println(p1.getAuto() == a);
		System.out.println(a.getPerson() == p1);
		System.out.println(p.getAuto() == a1);
		System.out.println(a1.getPerson() == p);
		System.out.println(p2.getAuto() == null);
		//System.out.println(a1.getPerson() == p);
		
		
	}
	
	public static void ausgabe(String a, int ... i){
		for(int b : i){
			System.out.println(b);
		}
	}

}
