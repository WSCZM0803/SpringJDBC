import Account.Account;
import Account.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SelectAllAccountTest {
    public static void main(String[] args) {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao实例
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        List<Account> account = accountDao.selectAccount();
        for (Account act : account) {
            System.out.println(act);
        }
    }
}
