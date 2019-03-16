package kz.epamlibrary.explore

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_explore.view.*
import kz.epamlibrary.R

class ExploreFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        view.categories_see_all.setOnClickListener {
            val intent = Intent(activity, CategoriesActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}