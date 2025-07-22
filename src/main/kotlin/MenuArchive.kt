import java.util.ArrayList
import java.util.Scanner

fun showMenuArchive(archivesList: ArrayList<Archive>) {
    while (true) {
        val indexMenu = showMenu(arrayListOf("Список архивов", "Создать архив", "Удалить архив", "Перейти в архив", "Назад"))

        when(indexMenu) {
            0 -> showArchivesList(archivesList)
            1 -> createArchive(archivesList)
            2 -> removeArchive(archivesList)
            3 -> openArchive(archivesList)
            4 -> return
        }
    }
}

/** Отображение списка архивов */
fun showArchivesList(archivesList: ArrayList<Archive>) {
    if(archivesList.size == 0) {
        println("Список пуст")
    } else {
        for((index, archive) in archivesList.withIndex()) {
            println("${index + 1}. ${archive.name}")
        }
    }
}

/** Создание нового архива */
fun createArchive(archivesList: ArrayList<Archive>) {
    while (true) {
        println("Введите название архива")

        val name = Scanner(System.`in`).nextLine().trim()

        if(name.isEmpty()) {
            println("Название не должно быть пустым")
        } else if(!archivesList.all { name != it.name }) {
            println("Название уже есть в списке")
        } else {
            archivesList.add(Archive(name))
            break
        }
    }
}

/** Удаление архива по индексу */
fun removeArchive(archivesList: ArrayList<Archive>) {
    if(archivesList.size == 0) {
        println("Список пуст. Нечего удалять")
        return
    }

    println("Введите номер архива для удаления")

    val scanner = Scanner(System.`in`)
    val archiveIndex = getIntScanner(scanner) - 1


     if (isArrayItem(archivesList, archiveIndex)) {
         archivesList.removeAt(archiveIndex)
     } else {
         println("Архив не найден")
     }
}

fun openArchive(archivesList: ArrayList<Archive>) {
    println("Введите номер архива для открытия")

    val scanner = Scanner(System.`in`)
    val archiveIndex = getIntScanner(scanner) - 1


    if (isArrayItem(archivesList, archiveIndex)) {
        showMenuNote(archivesList[archiveIndex])
    } else {
        println("Архив не найден")
    }
}