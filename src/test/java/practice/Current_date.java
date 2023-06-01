package practice;

import java.util.Date;

public class Current_date {

	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(d);
		String a[]=d.toString().split(" ");
		String day = a[0];
		String month = a[1];
		String date = a[2];
		String year = a[5];
		System.out.println(day+" "+month+" "+date+" "+year);

	}

}
