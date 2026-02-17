package com.app.wineapp

import retrofit2.http.GET

interface WineService {
    @GET(Constants.PATH_WINES)
    suspend fun getRedsWines() : List<Wine>
}