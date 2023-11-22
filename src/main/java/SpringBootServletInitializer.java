import com.wdd.studentmanager.StudentmanagerApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class SpringBootServletInitializer extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StudentmanagerApplication.class);
    }

}
