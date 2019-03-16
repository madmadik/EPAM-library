package kz.epamlibrary.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_notification.view.*
import kz.epamlibrary.R
import kz.epamlibrary.entity.Notification

class NotificationsAdapter(private val notifications: ArrayList<Notification>) :
    RecyclerView.Adapter<NotificationsAdapter.NotificationViewHolder>() {


    class NotificationViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NotificationsAdapter.NotificationViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)

        return NotificationViewHolder(item)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notifications[position]

        holder.itemView.date.text = notification.date
        holder.itemView.notification_content.text = notification.content
        holder.itemView.status.text = notification.status

    }

    override fun getItemCount(): Int {
        return notifications.size
    }
}