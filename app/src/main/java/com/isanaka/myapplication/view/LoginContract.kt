package com.isanaka.myapplication.view

import com.isanaka.myapplication.base.BasePresenter
import com.isanaka.myapplication.base.BaseView
import com.isanaka.myapplication.data.model.LoginDetails
import com.isanaka.myapplication.data.network.ApiError


class LoginContract {

    interface  Presenter: BasePresenter<View> {
        fun onLogin(loginDetails: LoginDetails)
    }


    interface View: BaseView {
        fun onLoginSuccessful(message: String)
        fun onLoginFailed(string: String)
    }
}