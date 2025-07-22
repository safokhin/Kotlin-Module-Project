import java.util.ArrayList

fun main() {
    val archivesList = ArrayList<Archive>()

    while (true) {
        val indexMenu = showMenu(arrayListOf("Архивы", "Выход"))

        when(indexMenu) {
            0 -> showMenuArchive(archivesList)
            1 -> {
                println("Пока :)")
                return
            }
        }
    }
}