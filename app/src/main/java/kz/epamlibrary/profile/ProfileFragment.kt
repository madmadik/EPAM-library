package kz.epamlibrary.profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kz.epamlibrary.R
import kz.epamlibrary.profile.mylibrary.MyLibraryFragment

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        view.myLibrary.setOnClickListener {
            openMyLibrary()
        }
        view.rentedBooks.setOnClickListener {
            openRentedBooks()
        }
        view.wishList.setOnClickListener {
            openMyWishList()
        }

        return view
    }

    private fun openMyLibrary() {
        replaceFragment(MyLibraryFragment())
    }

    private fun openRentedBooks() {

    }

    private fun openMyWishList() {
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = activity!!.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}
