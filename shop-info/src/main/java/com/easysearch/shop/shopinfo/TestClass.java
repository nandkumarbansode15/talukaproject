package com.easysearch.shop.shopinfo;

class PrintOne implements Runnable{
	
	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public void run() {
		System.out.println(value);
		value++;
	}
	
	
	
	
}

class PrintTwo implements Runnable{
	
	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public void run() {
		
			while(true)
			{
				if(value>1)
				{
					System.out.println(value);
					value++;
					break;
				}
			}
		
	}
	
	
	
	
}

class PrintThree implements Runnable {

	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public void run() {

		while (true) {
			if (value > 2) {
				System.out.println(value);
				break;
			}
		}

	}

}
	
	
	
	

public class TestClass {
	
	public static void main(String[] s)
	{
		
		Integer value=new Integer(1);
		PrintOne p=new PrintOne();
		p.setValue(value);
		Thread t=new Thread(p);
		t.start();
		
		PrintTwo p1=new PrintTwo();
		p1.setValue(value);
		Thread t1=new Thread(p1);
		
		t1.start();
		
		PrintThree p2=new PrintThree();
		p2.setValue(value);
		Thread t2=new Thread(p2);
		
		t2.start();
		
		
	}

}
