package com.lvb.studys.kotlin.api.wsuserlogin.config

import com.lvb.studys.kotlin.api.wsuserlogin.entity.Role
import com.lvb.studys.kotlin.api.wsuserlogin.entity.User
import com.lvb.studys.kotlin.api.wsuserlogin.repository.IRoleRepository
import com.lvb.studys.kotlin.api.wsuserlogin.repository.IUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextRefreshedEvent
import java.util.*

@Configuration
class SetupDataLoader @Autowired constructor(
    private val userRepository: IUserRepository,
    private val roleRepository: IRoleRepository
): ApplicationListener<ContextRefreshedEvent> { // This interface is an event observer, this means that when the application context is created the method onApplicationEvent will be called

    override fun onApplicationEvent(event: ContextRefreshedEvent) {

        userRepository.deleteAll()
        roleRepository.deleteAll()


        val roleAdmin = Role(name = "ROLE_ADMIN")
        val roleUser = Role(name = "ROLE_USER")

        createRoleIfMotFound(roleAdmin)
        createRoleIfMotFound(roleUser)

        val userJoao = User(firstName = "Joao", lastName = "Silva", email = "jo.silva@mail.com")
        val userMaria = User(firstName = "Maria", lastName = "Oliveira", email = "ma.oliveira@mail.com")

        userJoao.roles = listOf(roleAdmin)
        userMaria.roles = listOf(roleUser)


        createUserIfMotFound(userJoao)
        createUserIfMotFound(userMaria)

    }


    private fun createUserIfMotFound(user: User): User {
        val obj : Optional<User> = userRepository.findByEmail(user.email)

        if(obj.isPresent)
            return obj.get()

        return userRepository.save(user)

    }

    private fun createRoleIfMotFound(role: Role): Role {
        val obj : Optional<Role> = roleRepository.findByName(role.name)

        if(obj.isPresent)
            return obj.get()

        return roleRepository.save(role)

    }

}