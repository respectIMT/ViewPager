package uz.fragmenta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.saidarabxon.akramov.h19tablayout.R
import uz.saidarabxon.akramov.h19tablayout.databinding.FragmentItemViewPagerBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"


class ItemViewPager : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)
        }
    }
    lateinit var binding: FragmentItemViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =FragmentItemViewPagerBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.line1.setBackgroundResource(param1?.toInt()!!)
        binding.title.text=param3
        binding.textView.text= param4


        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: Int, param2: String, param3: String, param4: String) =
            ItemViewPager().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1.toString())
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                }
            }
    }
}