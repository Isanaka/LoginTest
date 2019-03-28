package com.isanaka.myapplication.view

import com.isanaka.myapplication.data.model.LoginDetails
import com.isanaka.myapplication.data.model.LoginResponse
import com.isanaka.myapplication.data.network.ApiError
import com.isanaka.myapplication.data.repository.AppRepository
import io.reactivex.disposables.CompositeDisposable


class LoginPresenter(val repo: AppRepository): LoginContract.Presenter {

    private val compositeDisposable = CompositeDisposable()
    private var view: LoginContract.View? = null

    override fun onLogin(loginDetails: LoginDetails) {
        repo.postLogin(loginDetails, fun(it: LoginResponse) {
            view?.onLoginSuccessful(getSuccessMessage(it))
        },fun(it:ApiError) {
            view?.onLoginFailed(it.getErrorMessage())
        }, {
        }).also {
            compositeDisposable.add(it)
        }
    }

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    private fun getSuccessMessage(response: LoginResponse): String = response.data.email +"\n"+response.data.name

}