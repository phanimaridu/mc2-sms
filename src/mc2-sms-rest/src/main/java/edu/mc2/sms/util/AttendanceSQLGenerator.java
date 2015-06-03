package edu.mc2.sms.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import ch.qos.logback.core.util.FileUtil;

public class AttendanceSQLGenerator {

	//INSERT INTO `attendance_by` VALUES ('4', '2015-05-31 17:08:14', 'admin');
	//INSERT INTO `attendance` VALUES ('41', '1', 'Present', '1', '4');

	
	private static String ATTENDANCE_BY_SQL_TEMPLATE = "\n\nINSERT INTO `attendance_by` VALUES ('ID', 'DTT', 'TB', 'CSI');\n\n";
	private static String ATTENDANCE_SQL_TEMPLATE = "INSERT INTO `attendance` VALUES ('ID', 'CEI',";
	private static String ATTENDANCE_PRESENT_POSTFIX = "null, '1', 'AB_ID');\n";
	private static String ATTENDANCE_ABSENT_POSTFIX = "'Absent', '2', 'AB_ID');\n";
	
	private static long MILLI_SECONDS_PER_DAY = 24*60*60*1000;
	
	
	
	public static StringBuilder getAttendanceSQLs(int startId,
			int[] courseErollmentIds,Date startDate,int noOfClasses,
			String takenBy,int courseScheduleId){
		
		Random random = new Random();
		StringBuilder result = new StringBuilder();
		
		String attendanceByStaffQry = ATTENDANCE_BY_SQL_TEMPLATE.replace("TB", takenBy);
		attendanceByStaffQry = attendanceByStaffQry.replace("CSI", courseScheduleId + "");
		
		for(int noOfClassesCounter = 1; noOfClassesCounter <= noOfClasses; noOfClassesCounter ++){
			Date classDate = new Date(startDate.getTime() + ((noOfClassesCounter - 1)*MILLI_SECONDS_PER_DAY));
			//2015-04-11 18:00:23
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int attendanceById = startId + noOfClassesCounter - 1;
			String attendanceByQry = attendanceByStaffQry.replace("ID", attendanceById + "");
			attendanceByQry = attendanceByQry.replace("DTT", sdf.format(classDate));
			
			result.append(attendanceByQry);
			
			String presentPostFix = ATTENDANCE_PRESENT_POSTFIX.replace("AB_ID", attendanceById + "");
			String absentPostFix =  ATTENDANCE_ABSENT_POSTFIX.replace("AB_ID", attendanceById + "");
			
			
			for(int courseErollmentId : courseErollmentIds){
				String sqlQryResult = ATTENDANCE_SQL_TEMPLATE.replace("ID", startId + "");
				sqlQryResult = sqlQryResult.replace("CEI", courseErollmentId + "");
				
				//Configure Present % here
				int randomNo = random.nextInt(100) + 1;
				if(randomNo > 70){
					sqlQryResult = sqlQryResult + absentPostFix;
				}else{
					sqlQryResult = sqlQryResult + presentPostFix;
				}
				result.append(sqlQryResult);

				startId ++;
			}
			
		}
		
		
		return result;
	}
	
	

	//
	
	
	/*
	 public static void main(String[] args) {
		int startId = 1;
		int[] physicsCcourseErollmentIds   = {1,4,7,10,13,16,19,22,25,28,31,34,37,40,43,46,49,52,55,58};
		int[] mathCcourseErollmentIds      = {2,5,8,11,14,17,20,23,26,29,32,35,38,41,44,47,50,53,56,59};
		int[] scienceCcourseErollmentIds   = {3,6,9,12,15,18,21,24,27,30,33,36,39,42,45,48,51,54,57,60};
		//int[] courseErollmentIds = {1,4,7};
		int noOfClasses = 45;
		Date startDate = new Date((new Date()).getTime() - (noOfClasses + 1)* MILLI_SECONDS_PER_DAY);
		String takenBy = "admin";
		
		
		
		//System.out.println(getAttendanceSQLs(1000, physicsCcourseErollmentIds, startDate, noOfClasses, takenBy,1));

		//System.out.println(getAttendanceSQLs(2000, mathCcourseErollmentIds, startDate, noOfClasses, takenBy,2));

		System.out.println(getAttendanceSQLs(3000, scienceCcourseErollmentIds, startDate, noOfClasses, takenBy,3));
		
	}
	 */
	
	 
	
	
		
		
}
