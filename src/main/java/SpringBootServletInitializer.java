import com.wdd.studentmanager.StudentmanagerApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

// 用于配置 Servlet 3.0+ 配置的 Spring Boot 应用程序
public class SpringBootServletInitializer extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

    // 重写，构建和配置 SpringApplicationBuilder
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // 设置应用程序的主类为 StudentmanagerApplication
        return application.sources(StudentmanagerApplication.class);
    }
}
