import com.persistance.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main (String[] args){

//        User andrew = new User("Andrew", "Jackson", "ajackson@aol.com");
//
//        UserDAO userDAO = new UserDAO();
//
//        System.out.println(userDAO.create(andrew));

        UserDAO userDao = new UserDAO();
        AccountsTypeDAO accountsTypeDao = new AccountsTypeDAO();
        AccountsDAO accountsDao = new AccountsDAO();

        User benjamin = new User("Benjamin","Franklin","benjief@gmail.com");
        Integer benjaminUserId = userDao.create(benjamin);

        AccountsType accountsType = new AccountsType("Checking");
        Integer accountsTypeId = accountsTypeDao.create(accountsType);

        Accounts bankAccount = new Accounts(50000.32, accountsTypeId, benjaminUserId, Date.valueOf(LocalDate.now()));
        System.out.println(accountsDao.create(bankAccount));

        }

    }

