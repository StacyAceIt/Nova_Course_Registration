package course_registeration_Java;
import java.io.FileWriter;

import java.io.IOException;

import org.json.simple.JSONArray;

import org.json.simple.JSONObject;

public class InputCourses {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONObject myCourses = new JSONObject();

        myCourses.put("firstName", "Lokesh");

        myCourses.put("lastName", "Gupta");

        myCourses.put("website", "howtodoinjava.com");

         

        JSONObject courseObject = new JSONObject();

        courseObject.put("employee", myCourses);


        JSONObject myCourses2 = new JSONObject();

        myCourses2.put("firstName", "Brian");

        myCourses2.put("lastName", "Schultz");

        myCourses2.put("website", "example.com");

         

        JSONObject courseObject2 = new JSONObject();

        courseObject2.put("employee", myCourses2);
              

        JSONArray CourseList = new JSONArray();

        CourseList.add(courseObject);
        CourseList.add(courseObject2);

        try (FileWriter file = new FileWriter("courses.json")) {
            file.write(CourseList.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
