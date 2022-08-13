import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbcTemplate {
    public static void main(String[] args) {
        /*
        调用execute()方法建表
         */
        //初始化spring容器，加载applicationContext.xml配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取JDBCtemplate的实例
        JdbcTemplate jdbcTemplate =(JdbcTemplate) applicationContext.getBean("JdbcTemplate");
        //使用excute（）方法执行sql语句，创建用户账户管理表account
        jdbcTemplate.execute("create table account("+
                "id int primary key auto_increment,"+
                "username varchar (50),"+
                "balance double )");
        System.out.println("账户表account创建成功!");



    }
}
