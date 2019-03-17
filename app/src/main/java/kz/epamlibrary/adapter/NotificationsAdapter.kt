package kz.epamlibrary.adapter

import android.annotation.SuppressLint
import android.graphics.Color
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

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notification = notifications[position]

        if(notification.status == "Accepted") {
            holder.itemView.status.setTextColor(Color.parseColor("#00ab81"))
            holder.itemView.divider.setBackgroundColor(Color.parseColor("#00ab81"))
        } else if(notification.status == "Rejected") {
            holder.itemView.status.setTextColor(Color.parseColor("#EB5463"))
            holder.itemView.divider.setBackgroundColor(Color.parseColor("#EB5463"))
        } else {
            holder.itemView.status.setTextColor(Color.parseColor("#FFE03E"))
            holder.itemView.divider.setBackgroundColor(Color.parseColor("#FFE03E"))
        }
        holder.itemView.date.text = notification.date
        holder.itemView.notification_content.text = notification.content
        holder.itemView.status.text = notification.status

    }

    override fun getItemCount(): Int {
        return notifications.size
    }
}