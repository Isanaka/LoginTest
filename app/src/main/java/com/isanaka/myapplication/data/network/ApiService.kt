package com.isanaka.myapplication.data.network

import com.isanaka.myapplication.data.model.LoginDetails
import io.reactivex.Observable
import retrofit2.http.GET
import com.isanaka.myapplication.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST



interface ApiService {

    @POST("Technical/login")
    fun postLogin(@Body loginDetails: LoginDetails): Observable<LoginResponse>

}