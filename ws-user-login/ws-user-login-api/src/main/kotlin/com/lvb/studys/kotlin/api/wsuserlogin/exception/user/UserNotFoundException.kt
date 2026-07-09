package com.lvb.studys.kotlin.api.wsuserlogin.exception.user

import java.io.Serializable
import java.lang.RuntimeException

class UserNotFoundException(errorMessage: String = "User not found") : RuntimeException(errorMessage), Serializable