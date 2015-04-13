package edu.mc2.sms.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class AttendanceSQLGenerator {

	private static String SQL_TEMPLATE = "INSERT INTO `attendance` VALUES ('ID', 'CEI', 'DTT', 'TB', ";
	private static String PRESENT_POSTFIX = "null, '1');\n";
	private static String ABSENT_POSTFIX = "'Absent', '2');\n";
	
	private static long MILLI_SECONDS_PER_DAY = 24*60*60*1000;
	
	
	
	public static StringBuilder getAttendanceSQLs(int startId,
			int[] courseErollmentIds,Date startDate,int noOfClasses,String takenBy){
		
		Random random = new Random();
		StringBuilder result = new StringBuilder();
		
		String sqlQry = SQL_TEMPLATE.replace("TB", takenBy);
		
		for(int noOfClassesCounter = 1; noOfClassesCounter <= noOfClasses; noOfClassesCounter ++){
			Date classDate = new Date(startDate.getTime() + ((noOfClassesCounter - 1)*MILLI_SECONDS_PER_DAY));
			//2015-04-11 18:00:23
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sqlQryWithDate = sqlQry.replace("DTT", sdf.format(classDate));
			for(int courseErollmentId : courseErollmentIds){
				String sqlQryResult = sqlQryWithDate.replace("ID", startId + "");
				sqlQryResult = sqlQryResult.replace("CEI", courseErollmentId + "");
				
				//Configure Present % here
				int randomNo = random.nextInt(100) + 1;
				if(randomNo > 70){
					sqlQryResult = sqlQryResult + ABSENT_POSTFIX;
				}else{
					sqlQryResult = sqlQryResult + PRESENT_POSTFIX;
				}
				result.append(sqlQryResult);

				startId ++;
			}
			
		}
		
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		int startId = 1;
		int[] courseErollmentIds = {1,4,7,10,13,16,19,22,25,28,31,34,37,40,43,46,49,52,55};
		//int[] courseErollmentIds = {1,4,7};
		Date startDate = new Date();
		int noOfClasses = 45;
		String takenBy = "math_teacher";
		
		System.out.println(getAttendanceSQLs(startId, courseErollmentIds, startDate, noOfClasses, takenBy));
		
		
	}
}
