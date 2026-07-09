package com.lvb.studys.kotlin.api.pointofsaleapi.jwt.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.Calendar

@Service
class JwtService(
    @Value("\${security.jwt.expiration}")
    val expiration: Int,
    @Value("\${security.jwt.key}")
    val key: String
) {

    fun generateToken(username: String): String {

        val currentTime = Calendar.getInstance()
        currentTime.add(Calendar.MINUTE, expiration)

        return Jwts.builder()
            .setSubject(username)
            .setExpiration(currentTime.time)
            .signWith(SignatureAlgorithm.HS256, key)
            .compact()
    }

    fun getUsername(token: String): String {

        val claims = getClaims(token)
        return claims.subject

    }

    private fun getClaims (token: String): Claims {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).body
    }

}