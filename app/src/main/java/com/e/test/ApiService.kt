package com.e.test

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET
        (value = "v1/json/2/all_leagues.php")
    suspend fun getLeagues(): Response<LeaguesResponse>
}