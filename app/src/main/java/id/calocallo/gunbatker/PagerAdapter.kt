package id.calocallo.gunbatker

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.calocallo.gunbatker.landing.Landing1Fragment
import id.calocallo.gunbatker.landing.Landing2Fragment
import id.calocallo.gunbatker.landing.Landing3Fragment

class PagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    private val fragments = arrayOf(Landing1Fragment(), Landing2Fragment(), Landing3Fragment())
    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}