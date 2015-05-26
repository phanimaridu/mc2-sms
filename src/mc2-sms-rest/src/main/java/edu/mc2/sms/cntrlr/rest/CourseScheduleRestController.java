package edu.mc2.sms.cntrlr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mc2.sms.common.MinimizerUtil;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.service.CourseScheduleService;

@RestController
@RequestMapping("/course_schedule")
public class CourseScheduleRestController {

	@Autowired
	private CourseScheduleService courseScheduleService;

	@RequestMapping(method = RequestMethod.GET)
	public List<CourseSchedule> getCourseSchedules(
			@RequestParam(value = "instructorUserName", required = false) String instructorUserName) {
		return courseScheduleService.getCourseSchedulesData(instructorUserName);
	}

	// FIXME:Try to get less data from Database itself
	@RequestMapping(value = "/min", method = RequestMethod.GET)
	public List<CourseSchedule> getCourseSchedulesMinimal(
			@RequestParam(value = "instructorUserName", required = false) String instructorUserName) {
		return MinimizerUtil.getMinimizedCourseSchedule(courseScheduleService
				.getCourseSchedulesData(instructorUserName));
	}

}