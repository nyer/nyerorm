package org.nyer.copyright.guessfb.service;

import org.nyer.copyright.guessfb.model.User;

public class UserService extends BaseService{
    public User login(User user){
        String sql = "select * from user where userName = ? and password = ?";
        user = queryForObject(sql, new Object[]{user.getUserName(),user.getPassword()}, User.class);
        return user;
    }
    
    public boolean isUserNameExist(String userName){
        String sql = "select * from user where userName= ?";
        return queryForObject(sql, new Object[]{userName}, User.class) != null;
    }
    
    public User regUser(User user){
        user.setId(null);
        super.save(user);
        return user;
    }
    
    public User updateUser(User user){
        User local = get(User.class, user.getId());
        local.setEmail(user.getEmail());
        local.setPassword(user.getPassword());
        return local;
    }
}
