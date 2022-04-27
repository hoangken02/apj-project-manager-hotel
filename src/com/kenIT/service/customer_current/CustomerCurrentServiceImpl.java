package com.kenIT.service.customer_current;

import com.kenIT.config.ConfigReadAndWriteFile;
import com.kenIT.model.Customer;
import com.kenIT.model.CustomerCurrent;

import java.util.List;

public class CustomerCurrentServiceImpl implements ICustomerCurrentService{
    public static final String PATH_CUSTOMER_CURRENT = new ConfigReadAndWriteFile().PATH+"\\customer_current.txt";
    public static List<CustomerCurrent> customerCurrentsList = new ConfigReadAndWriteFile().readFromFile(PATH_CUSTOMER_CURRENT);
    @Override
    public List<CustomerCurrent> findAll() {
        new ConfigReadAndWriteFile<CustomerCurrent>().writeToFile(PATH_CUSTOMER_CURRENT,customerCurrentsList);
        return customerCurrentsList;
    }

    @Override
    public Customer save(CustomerCurrent customerCurrent) {
        customerCurrentsList.clear();
        customerCurrentsList.add(customerCurrent);
        return null;
    }
}
