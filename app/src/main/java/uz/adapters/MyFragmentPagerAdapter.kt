package uz.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.fragmenta.ItemViewPager

import uz.utils.User

class MyFragmentPagerAdapter(  fm:FragmentManager, private val list:ArrayList<User>  ):FragmentPagerAdapter(fm) {
    override fun getCount(): Int = list.size


    override fun getItem(position: Int): Fragment {
        return  ItemViewPager.newInstance(list[position].backround,list[position].chName,list[position].asName,list[position].yozuv)

    }

//    override fun getPageTitle(position: Int): CharSequence? {
//
//return list[position].name
//
//    }
}