import Account.Account;
import Account.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestAddAccount {
    public static void main(String[] args) {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao实例
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        //创建Account对象，并向Account对象中添加数据
        Account account = new Account();
        account.setUsername("嚯嚯嚯");
        account.setBalance(20000.00);
        //执行addAccount()方法，并获取返回结果
        int num = accountDao.addAccount(account);
        if (num > 0) {
            System.out.println("成功插入了"+num+"条数据!");
        }else{
            System.out.println("插入操作执行失败!");
        }


    }
}
