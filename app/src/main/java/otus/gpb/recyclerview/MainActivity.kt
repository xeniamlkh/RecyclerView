package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MessagesAdapterListener {

    private lateinit var recycleView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    private val messagesAdapter by lazy { MessagesAdapter() }
    private val messagesListDataSource = DataSource().getMessages()

    private val messagesList = mutableListOf<Chat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)
        recycleView.layoutManager = layoutManager
        recycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        ItemTouchHelper(ItemTouchHelperCallback(this)).attachToRecyclerView(recycleView)

        messagesList.addAll(messagesListDataSource)

        updateRecyclerView(messagesList)

        val scrollListener = ScrollListener(layoutManager) {
            loadMoreMessages()
        }
        recycleView.addOnScrollListener(scrollListener)
        scrollListener.onLoadFinished()
    }

    override fun onItemSwipe(position: Int) {
        val newList = messagesList.toMutableList()
        newList.removeAt(position)
        messagesList.clear()
        messagesList.addAll(newList)

        updateRecyclerView(messagesList)
    }

    private fun updateRecyclerView(messagesList: List<Chat>) {
        messagesAdapter.submitList(messagesList)
        recycleView.adapter = messagesAdapter
    }

    private fun loadMoreMessages() {
        messagesList.addAll(messagesListDataSource)
        updateRecyclerView(messagesList)
    }
}