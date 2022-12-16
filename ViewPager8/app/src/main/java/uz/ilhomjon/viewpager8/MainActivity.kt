package uz.ilhomjon.viewpager8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.google.android.material.tabs.TabLayout
import uz.ilhomjon.viewpager8.adapters.MyFragmentPagerAdapter
import uz.ilhomjon.viewpager8.adapters.MyViewPagerAdapter
import uz.ilhomjon.viewpager8.databinding.ActivityMainBinding
import uz.ilhomjon.viewpager8.databinding.ItemTabViewBinding
import uz.ilhomjon.viewpager8.models.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var list:ArrayList<User>
//    private lateinit var myViewPagerAdapter: MyViewPagerAdapter
private lateinit var myFragmentPagerAdapter: MyFragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

//        myViewPagerAdapter = MyViewPagerAdapter(this, list)
//        binding.myViewPager.adapter = myViewPagerAdapter

        myFragmentPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager, list)
        binding.myViewPager.adapter = myFragmentPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.myViewPager)

        setTab()
    }

    private fun loadData() {
        list = ArrayList()
        list.add(User("Ta'lim", "https://storage.kun.uz/source/thumbnails/_medium/8/gM7avo218ArYlIQc_W0jDLfBLW_wPTrV_medium.jpg"))
        list.add(User("Soqqa", "https://storage.kun.uz/source/8/DbMblbQjSkyVslePxDCjGsKhuQG1JqbY.jpg"))
       list.add(User("Kontrakt", "https://storage.kun.uz/source/8/zCEwB4m4M44hCcb4_0X8khWm2-pg2Xgg.jpg"))
    }

    private fun setTab(){
        val tabCount = binding.tabLayout.tabCount

        for (i in 0 until tabCount){
            val tabItemView = ItemTabViewBinding.inflate(layoutInflater)
            val tab = binding.tabLayout.getTabAt(i)
            tab?.customView = tabItemView.root
            tabItemView.tabTv.text = list[i].name
            if (i==0){
                tabItemView.imageIndicator.visibility = View.VISIBLE
            }else{
                tabItemView.imageIndicator.visibility = View.GONE
            }
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.image_indicator)?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.findViewById<ImageView>(R.id.image_indicator)?.visibility = View.GONE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}