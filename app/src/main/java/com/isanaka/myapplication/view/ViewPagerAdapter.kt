package com.isanaka.myapplication.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.isanaka.myapplication.data.model.FragmentDetails


class ViewPagerAdapter: FragmentPagerAdapter {
    private  var mFragments: MutableList<Fragment> = mutableListOf()
    private  var mFragmentTitles: MutableList<String> = mutableListOf()

    constructor(fragmentManager: FragmentManager) : super(fragmentManager)

    override fun getItem(position: Int): Fragment = mFragments.get(position)

    override fun getCount(): Int = mFragments.size

    fun addragment(fragmentDetails: FragmentDetails) {
        mFragments.add(fragmentDetails.fragment)
        mFragmentTitles.add(fragmentDetails.title)
    }

    override fun getPageTitle(position: Int) : String = mFragmentTitles[position]
}