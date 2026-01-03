package otus.gpb.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class MessageViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    private val title: TextView by lazy { view.findViewById(R.id.title) }
    private val author: TextView by lazy { view.findViewById(R.id.author) }
    private val message: TextView by lazy { view.findViewById(R.id.message) }
    private val time: TextView by lazy { view.findViewById(R.id.time) }
    private val icon: ImageView by lazy { view.findViewById(R.id.icon) }

    fun bind(chat: Chat) {
        val drawableImage = ResourcesCompat
            .getDrawable(view.resources, chat.icon, null)
        icon.setImageDrawable(drawableImage)

        title.text = chat.title
        author.text = chat.author
        message.text = chat.message
        time.text = chat.time
    }
}