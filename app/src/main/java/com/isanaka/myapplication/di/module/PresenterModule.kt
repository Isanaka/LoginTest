package com.isanaka.myapplication.di.module

import com.isanaka.myapplication.data.repository.AppRepository
import com.isanaka.myapplication.view.LoginContract
import com.isanaka.myapplication.view.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesLoginPresenter(repo: AppRepository): LoginContract.Presenter = LoginPresenter(repo)
}
