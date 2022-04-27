package com.kenIT.service.role;

import com.kenIT.config.ConfigReadAndWriteFile;
import com.kenIT.model.Customer;
import com.kenIT.model.Role;
import com.kenIT.model.RoleName;

import java.util.List;

public class RoleServiceImpl implements IRoleService{
    public static String PATH_ROLE = ConfigReadAndWriteFile.PATH + "\\role.txt";
    public static List<Role> roleList = new ConfigReadAndWriteFile<Role>().readFromFile(PATH_ROLE);
    @Override
    public List<Role> findAll() {
         if (roleList.size() >= 2){
             return roleList;
         }else {
             roleList.add( new Role(1, RoleName.CUSTOMER));
             roleList.add(new Role(2, RoleName.ADMIN));
         }
         new ConfigReadAndWriteFile<Role>().writeToFile(PATH_ROLE,roleList);
         return roleList;
    }

    @Override
    public Customer save(Role role) {
        roleList.add(role);
        return null;
    }

    @Override
    public Role findByName(RoleName roleName) {
        for (int i = 0; i < roleList.size(); i++) {
            if (roleName == roleList.get(i).getName()){
                return roleList.get(i);
            }
        }
        return null;
    }
}
