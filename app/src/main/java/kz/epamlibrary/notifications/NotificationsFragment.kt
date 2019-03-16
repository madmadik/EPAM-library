package kz.epamlibrary.notifications

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.fragment_notifications.view.*
import kz.epamlibrary.R
import kz.epamlibrary.adapter.NotificationsAdapter
import kz.epamlibrary.entity.Notification

class NotificationsFragment: Fragment() {

    private var notifications = ArrayList<Notification>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)

        initNotifications()

        view.notifications_recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = NotificationsAdapter(notifications)
        }
        return view
    }

    private fun initNotifications() {
        notifications.add(Notification("Zhuma хочет арендовать вашу книгу “Java for Dummies” ...", "12 March 2019", "Accepted"))
        notifications.add(Notification("Zhuma хочет арендовать вашу книгу “Java for Dummies” ...", "12 March 2019", "Accepted"))
        notifications.add(Notification("Zhuma хочет арендовать вашу книгу “Java for Dummies” ...", "12 March 2019", "Accepted"))
        notifications.add(Notification("Zhuma хочет арендовать вашу книгу “Java for Dummies” ...", "12 March 2019", "Accepted"))
        notifications.add(Notification("Zhuma хочет арендовать вашу книгу “Java for Dummies” ...", "12 March 2019", "Accepted"))
        notifications.add(Notification("Zhuma хочет арендовать вашу книгу “Java for Dummies” ...", "12 March 2019", "Accepted"))
        notifications.add(Notification("Zhuma хочет арендовать вашу книгу “Java for Dummies” ...", "12 March 2019", "Accepted"))
        notifications.add(Notification("Zhuma хочет арендовать вашу книгу “Java for Dummies” ...", "12 March 2019", "Accepted"))
        notifications.add(Notification("Zhuma хочет арендовать вашу книгу “Java for Dummies” ...", "12 March 2019", "Accepted"))

    }
}