package com.thisisnotajoke.interview.model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

sealed class PeopleState {
    object Loading: PeopleState()
    data class Success(val people: People): PeopleState()
    data class Error(val error: String): PeopleState()
}

@Serializable
data class People(@SerialName("people") val value: List<Person> = emptyList())

@Serializable
data class Person(
    val uuid: String,
    @SerialName("full_name")
    val fullName: String,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("email_address")
    val emailAddress: String,
    val biography: String? = null,
    val photo_url_small: String? = null,
    val photo_url_large: String? = null,
    val team: String,
    @SerialName("person_type")
    val personType: PersonType,
)

enum class PersonType {
    FULL_TIME,
    PART_TIME,
    CONTRACTOR
}