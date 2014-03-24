package com.dandelion.memberapp.dao;

import com.dandelion.memberapp.dao.data.UserMapper;
import com.dandelion.memberapp.exception.MemberAppException;
import com.dandelion.memberapp.exception.WebserviceErrors;
import com.dandelion.memberapp.model.po.User;
import com.dandelion.memberapp.model.po.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ouroc on 3/24/14.
 */
@Repository
public class AccountDao {
    @Autowired
    private UserMapper userMapper;

    public User selectAccountByIdAndPassword(long id, String password) throws MemberAppException {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(id).andPasswordEqualTo(password);
        List<User> list = userMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        } else if (list.size() > 1) {
            throw new MemberAppException(
                    WebserviceErrors.EMAIL_PASSWORD_WRONG_CODE,
                    WebserviceErrors.EMAIL_PASSWORD_WRONG_MESSAGE);
        } else {
            return list.get(0);
        }
    }
    public void updateAccount(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

}
