package com.example.frontend_musink_admin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class BookingAdapter(
    private val bookings: List<Booking>,
    private val onDetailClick: (Booking) -> Unit
) : RecyclerView.Adapter<BookingAdapter.BookingViewHolder>() {

    inner class BookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvBookingId: TextView = itemView.findViewById(R.id.tvBookingId)
        val tvBookingTime: TextView = itemView.findViewById(R.id.tvBookingTime)
        val btnDetail: Button = itemView.findViewById(R.id.btnDetail)
        val container: View = itemView.findViewById(R.id.itemContainer) // tambahkan ini
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_booking, parent, false)
        return BookingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val booking = bookings[position]
        holder.tvBookingId.text = "Booking ID - ${booking.date}"
        holder.tvBookingTime.text = booking.time
        holder.btnDetail.setOnClickListener { onDetailClick(booking) }

        // ⬇️  logika warna
        val bgColor = when (booking.status) {
            "accepted" -> "#4CAF50" // hijau
            "rejected" -> "#F44336" // merah
            else -> "#A1887F"       // default
        }
        holder.container.setBackgroundColor(android.graphics.Color.parseColor(bgColor))
    }

    override fun getItemCount(): Int = bookings.size
}
