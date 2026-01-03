package otus.gpb.recyclerview

class DataSource {
    private val messagesList = listOf(
        Chat(
            id = 1,
            title = "Title1",
            author = "User1",
            message = "Message1",
            time = "12:00",
            icon = R.drawable.cat
        ),
        Chat(
            id = 2,
            title = "Title2",
            author = "User2",
            message = "Message2",
            time = "13:05",
            icon = R.drawable.dog
        ),
        Chat(
            id = 3,
            title = "Title3",
            author = "User3",
            message = "Message3",
            time = "9:13",
            icon = R.drawable.fox
        ),
        Chat(
            id = 4,
            title = "Title4",
            author = "User4",
            message = "Message4",
            time = "4:17",
            icon = R.drawable.giraffe
        ),
        Chat(
            id = 5,
            title = "Title5",
            author = "User5",
            message = "Message5",
            time = "10:00",
            icon = R.drawable.koala
        ),
        Chat(
            id = 6,
            title = "Title6",
            author = "User6",
            message = "Message6",
            time = "10:35",
            icon = R.drawable.lion
        ),
        Chat(
            id = 7,
            title = "Title7",
            author = "User7",
            message = "Message7",
            time = "15:16",
            icon = R.drawable.owl
        ),
        Chat(
            id = 8,
            title = "Title8",
            author = "User8",
            message = "Message8",
            time = "16:22",
            icon = R.drawable.panda
        ),
        Chat(
            id = 9,
            title = "Title9",
            author = "User9",
            message = "Message9",
            time = "21:18",
            icon = R.drawable.rabbit
        ),
        Chat(
            id = 10,
            title = "Title10",
            author = "User10",
            message = "Message10",
            time = "22:45",
            icon = R.drawable.wolf
        )
    )

    fun getMessages(): List<Chat> = messagesList

    fun deleteMessage(id: Int): List<Chat> = messagesList.filter { it.id != id }

}