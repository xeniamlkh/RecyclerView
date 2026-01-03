package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val messagesAdapter by lazy { MessagesAdapter() }
    private val messagesList = DataSource().getMessages()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messagesAdapter.submitList(messagesList)

        val recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        recycleView.adapter = messagesAdapter

        recycleView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }
}