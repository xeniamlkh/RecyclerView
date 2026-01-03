package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MessagesAdapterListener {

    private val messagesAdapter by lazy { MessagesAdapter() }
    private val messagesListDataSource = DataSource().getMessages()

    private val messagesList = mutableListOf<Chat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messagesList.addAll(messagesListDataSource)

        createUpdateRecyclerView(messagesList)
    }

    override fun onItemSwipe(position: Int) {
        val newList = messagesList.toMutableList()
        newList.removeAt(position)
        messagesList.clear()
        messagesList.addAll(newList)

        createUpdateRecyclerView(messagesList)
    }

    private fun createUpdateRecyclerView(messagesList: List<Chat>) {
        messagesAdapter.submitList(messagesList)
        val recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        recycleView.adapter = messagesAdapter
        recycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        ItemTouchHelper(ItemTouchHelperCallback(this)).attachToRecyclerView(recycleView)
    }
}