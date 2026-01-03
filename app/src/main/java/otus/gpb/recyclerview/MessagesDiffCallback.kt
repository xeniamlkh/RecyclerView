package otus.gpb.recyclerview

import androidx.recyclerview.widget.DiffUtil

class MessagesDiffCallback: DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(
        oldItem: Chat,
        newItem: Chat
    ): Boolean {
       return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: Chat,
        newItem: Chat
    ): Boolean {
        return oldItem.id == newItem.id
    }
}