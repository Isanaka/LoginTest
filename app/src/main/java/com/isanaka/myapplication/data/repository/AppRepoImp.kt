package com.isanaka.myapplication.data.repository

import com.isanaka.myapplication.data.model.LoginDetails
import com.isanaka.myapplication.data.model.LoginResponse
import com.isanaka.myapplication.data.network.ApiDisposable
import com.isanaka.myapplication.data.network.ApiError
import com.isanaka.myapplication.data.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AppRepoImpl(
    private val apiService: ApiService
) : AppRepository {

    override fun postLogin(
        loginDetails: LoginDetails,
        success: (LoginResponse) -> Unit,
        failure: (ApiError) -> Unit,
        terminate: () -> Unit
    ): Disposable {
        return apiService.postLogin(loginDetails)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate(terminate)
            .subscribeWith(
                ApiDisposable<LoginResponse>(
                    {

                        success(it)
                    },
                    failure
                )
            )
    }


}