package uz.ilhomjon.viewpager8.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.ilhomjon.viewpager8.fragments.BlankFragment
import uz.ilhomjon.viewpager8.fragments.ItemView_pagerFragment
import uz.ilhomjon.viewpager8.models.User

class MyFragmentPagerAdapter(fm:FragmentManager, val list: List<User>) :FragmentPagerAdapter(fm) {
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> ItemView_pagerFragment.newInstance(list[position].name, list[position].image)
            1-> BlankFragment()
            2-> ItemView_pagerFragment.newInstance(list[position].name, list[position].image)
            else-> ItemView_pagerFragment.newInstance(list[position].name, list[position].image)
        }
    }

}