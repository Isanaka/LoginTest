package com.isanaka.myapplication.data.repository

import com.isanaka.myapplication.data.model.LoginDetails
import com.isanaka.myapplication.data.model.LoginResponse
import com.isanaka.myapplication.data.network.ApiError
import io.reactivex.disposables.Disposable

interface AppRepository {

    fun postLogin(
        loginDetails: LoginDetails,
        success: (LoginResponse) -> Unit,
        failure: (ApiError) -> Unit = {},
        terminate: () -> Unit = {}
    ): Disposable
}