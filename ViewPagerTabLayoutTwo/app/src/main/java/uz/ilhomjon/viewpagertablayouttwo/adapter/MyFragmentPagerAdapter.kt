package uz.ilhomjon.viewpagertablayouttwo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.ilhomjon.viewpagertablayouttwo.fragment.ItemViewPagerFragment
import uz.ilhomjon.viewpagertablayouttwo.models.Data

class MyFragmentPagerAdapter(fm: FragmentManager, private val list: List<Data>) :
    FragmentPagerAdapter(fm) {
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment {
        return ItemViewPagerFragment.newInstance(list[position])
    }
}