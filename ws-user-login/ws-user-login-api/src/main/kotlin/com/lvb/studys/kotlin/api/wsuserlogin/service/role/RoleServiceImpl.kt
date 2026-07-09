package com.lvb.studys.kotlin.api.wsuserlogin.service.role

import com.lvb.studys.kotlin.api.wsuserlogin.repository.IRoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoleServiceImpl @Autowired constructor(
    private val iRoleRepository: IRoleRepository
) : IRoleService {


}