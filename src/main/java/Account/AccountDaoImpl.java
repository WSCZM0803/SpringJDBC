package Account;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;

public class AccountDaoImpl implements AccountDao{
    //定义JDBCTemplate属性以及其setter方法
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Account selectAccountById(int id) {
        String sql = "select * from account where id = ? " ;
        //创建一个新的BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //将id绑定到SQL语句中，并通过RowMapper返回单行记录
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    public List<Account> selectAccount() {
        String sql = "select * from account";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    //添加账户
    public int addAccount(Account account) {
        //定义SQL
        String sql = "insert into account(username,balance) value(?,?)";
        //定义数组来存放SQL语句中的参数
        Object[] obj = new Object[]{
                account.getUsername(),
                account.getBalance()
        };
        //执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, obj);
        return num;
    }

        //更新账户
    public int updateAccount(Account account) {
        //定义SQL
        String sql = "update account set username=?,balance=? where id=?";
        //定义数组来存放SQL语句中的参数
        Object [] params = new Object[]{
          account.getUsername(),
          account.getBalance(),
          account.getId()
        };
        //执行更新操作，返回的是受SQL语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, params);
        return num;
    }

        //删除账户
    public int deleteAccount(int id) {
        String sql = "delete from account where id = ? ";
        //执行删除操作
        int num = this.jdbcTemplate.update(sql, id);
        return num;
    }
}
