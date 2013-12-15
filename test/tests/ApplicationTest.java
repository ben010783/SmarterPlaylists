package tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.mvc.Http.Response;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void callIndex() {
    	  running(fakeApplication(), new Runnable() {
    		    public void run() {
			        Result result = callAction(
			        		controllers.routes.ref.Application.index()
					);
					assertThat(status(result)).isEqualTo(OK);
			
					result = route(fakeRequest(GET, "/"));
					assertThat(status(result)).isEqualTo(OK);
    		    }
    	  });
    }
    
    @Test
    public void callAbout() {
  	  running(fakeApplication(), new Runnable() {
		    public void run() {
    	Result result = callAction(
    			controllers.routes.ref.Application.about()
    	);
    	assertThat(status(result)).isEqualTo(OK);
    	
		result = route(fakeRequest(GET, "/about"));
		assertThat(status(result)).isEqualTo(OK);
		    }
	  });
    }
    
    @Test
    public void callAdmin() {
    	running(fakeApplication(), new Runnable() {
    		public void run() {
    			Result result = route(fakeRequest(GET, "/admin"));
    			assertThat(result).isNull();
    		}
    	});
    }

}