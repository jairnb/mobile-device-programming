package com.cvapp.data

import java.time.LocalDate

data class WorkExperience(
    var image: Int,
    var title: String,
    var company: String,
    var dateFrom: LocalDate,
    var dateTo: LocalDate,
    var location: String,
    var description: String
)
