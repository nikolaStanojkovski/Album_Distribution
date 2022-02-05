package com.musicdistribution.albumdistribution.data.firebase.auth

import com.google.firebase.database.DataSnapshot
import com.musicdistribution.albumdistribution.data.domain.Role
import com.musicdistribution.albumdistribution.model.firebase.User

class FirebaseAuthUser {
    companion object {
        var user: User? = null

        fun updateUser(snapshot: DataSnapshot) {
            val newUser = getUser(snapshot.value as HashMap<String, Object>)
            user = newUser
        }

        fun getUser(value: HashMap<String, Object>): User {
            return User(
                value["name"]!!.toString(),
                value["surname"]!!.toString(),
                value["email"]!!.toString(),
                Role.valueOf(value["role"]!!.toString()),
                value["noFollowers"]!!.toString().toLong(),
                value["noFollowing"]!!.toString().toLong()
            )
        }
    }
}