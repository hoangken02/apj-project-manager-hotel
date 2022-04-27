package com.kenIT.service.role;

import com.kenIT.model.Role;
import com.kenIT.model.RoleName;
import com.kenIT.service.IServiceGeneric;

public interface IRoleService extends IServiceGeneric<Role> {
    Role findByName(RoleName name);

}
