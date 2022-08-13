import Account.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDeleteAccount {
    public static void main(String[] args) {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取AccountDao实例
        AccountDao accountDao =(AccountDao) applicationContext.getBean("accountDao");
        //执行deleteAccount（）方法，并获取返回值
        int num = accountDao.deleteAccount(1);
        if (num > 0) {
            System.out.println("成功删除了"+num+"条数据!");
        }else{
            System.out.println("删除操作执行失败!");
        }
    }
}