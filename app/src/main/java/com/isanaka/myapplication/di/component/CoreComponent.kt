package com.isanaka.myapplication.di.component

import android.app.Application
import com.isanaka.myapplication.di.module.ActivityBuilder
import com.isanaka.myapplication.di.module.NetworkModule
import com.isanaka.myapplication.di.module.PresenterModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, NetworkModule::class, ActivityBuilder::class,
        PresenterModule::class]
)
interface CoreComponent : AndroidInjector<com.isanaka.myapplication.core.MyApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }
}