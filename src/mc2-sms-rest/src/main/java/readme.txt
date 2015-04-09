
Rest Controller Package Structure
-------------------------------- 
package 'edu.mc2.sms.cntrlr.rest' will contain all rest controllers.

  - 'admin' subpackage will contain all admin related Rest Controllers and only admin can access them.
  - Similarly staff and student used 'staff' and 'student' sub packages
  - These Rest Controllers must use a path prefix (ex : '/admin','/staff','/student')
  - Its configured in WebSecurityConfig Classes   
			Config : antMatchers("/**").hasAuthority(ROLE_ADMIN)
			         antMatchers("/staff/**").hasAuthority(ROLE_STAFF)
			         antMatchers("/student/**").hasAuthority(ROLE_STUDENT)
  - Any other Rest Controllers (Ex : Publicly accessible resources or shared resources) can use any path but 
    care should be taken to configure them in WebSecurityConfig.
  - These other Rest Controllers can be placed in 'public' sub package.
	
	
	

