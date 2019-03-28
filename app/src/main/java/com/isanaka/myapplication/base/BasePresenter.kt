package com.isanaka.myapplication.base

interface BasePresenter<T> {
    fun attachView(view: T)

    fun detachView()
}
