package com.isanaka.myapplication.di.module

import com.isanaka.myapplication.view.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityProviders {
    @ContributesAndroidInjector
    abstract fun provideLoginFragment(): LoginFragment
}