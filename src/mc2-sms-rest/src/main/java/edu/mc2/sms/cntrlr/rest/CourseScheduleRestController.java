package edu.mc2.sms.cntrlr.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wordnik.swagger.annotations.ApiOperation;

import edu.mc2.sms.common.MinimizerUtil;
import edu.mc2.sms.jpa.entity.CourseSchedule;
import edu.mc2.sms.service.CourseScheduleService;

@RestController
@RequestMapping("/course_schedule")
public class CourseScheduleRestController {

	@Autowired
	private CourseScheduleService courseScheduleService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public CourseSchedule getCourseSchedule(@PathVariable int id) {
		return courseScheduleService.getCourseSchedule(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CourseSchedule> getCourseSchedules(
			@RequestParam(value = "instructorUserName", required = false) String instructorUserName) {
		if(instructorUserName == null){
			return courseScheduleService.getCourseSchedulesData();
		}else{
			return courseScheduleService.getCourseSchedulesData(instructorUserName);
		}
		
	}

	@RequestMapping(value = "/min/{id}", method = RequestMethod.GET)
	public CourseSchedule getCourseScheduleMinimal(@PathVariable int id) {
		return MinimizerUtil.getMinimizedCourseSchedule(courseScheduleService.getCourseSchedule(id));
	}
	
	// FIXME:Try to get less data from Database itself
	@RequestMapping(value = "/min", method = RequestMethod.GET)
	public List<CourseSchedule> getCourseSchedulesMinimal(
			@RequestParam(value = "instructorUserName", required = false) String instructorUserName) {
		if(instructorUserName == null){
			return MinimizerUtil.getMinimizedCourseSchedules(courseScheduleService
					.getCourseSchedulesData());
		}else{
			return MinimizerUtil.getMinimizedCourseSchedules(courseScheduleService
					.getCourseSchedulesData(instructorUserName));
		}
	}
	
	
	
	@ApiOperation(value = "", notes = "Only Supply Course ID and Instructor userName - Other Nested Elements are Ignored")
	@RequestMapping(method = RequestMethod.POST)
	public void createCourseSchedule(@RequestBody CourseSchedule courseSchedule, UriComponentsBuilder uriBuilder,HttpServletResponse response) {
		courseScheduleService.createCourseSchedule(courseSchedule);
		response.setStatus(HttpStatus.SC_CREATED);
		response.setHeader("Location", uriBuilder.path("/course_schedule/{id}")
				.buildAndExpand(courseSchedule.getId()).toUriString());
	}
	
	
	@ApiOperation(value = "", notes = "Only Supply Course ID and Instructor userName - Other Nested Elements are Ignored")
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public void editCourseSchedule(@PathVariable int id,@RequestBody CourseSchedule courseSchedule, HttpServletResponse response) {
		courseScheduleService.editCourseSchedule(id,courseSchedule);
		response.setStatus(HttpStatus.SC_OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCourseSchedule(@PathVariable int id,HttpServletResponse response) {
		courseScheduleService.deleteCourseSchedule(id);
		response.setStatus(HttpStatus.SC_OK);
	}
	

}