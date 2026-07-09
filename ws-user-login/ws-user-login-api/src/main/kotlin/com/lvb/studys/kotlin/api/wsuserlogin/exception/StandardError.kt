package com.lvb.studys.kotlin.api.wsuserlogin.exception

import java.io.Serializable

data class StandardError (
    val timeStamp : Long,
    val status : Int,
    val error : String,
    val message : String,
    val path : String,
) : Serializable