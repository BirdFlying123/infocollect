package uestc.model.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import uestc.model.dao.AdminMapper;
import uestc.model.service.AdminService;

@Component("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Autowired
    @Qualifier("adminMapper")
    private AdminMapper adminMapper;

    public boolean valid(String username, String password) {
        int number=adminMapper.checkLogin(username,password);
        if(number==1)
            return true;
        return false;
    }
}
