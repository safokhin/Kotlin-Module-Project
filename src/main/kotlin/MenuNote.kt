import java.util.Scanner

fun showMenuNote(archive: Archive) {
    while (true) {
        val indexMenu = showMenu(arrayListOf("Список заметок", "Создать заметку", "Удалить заметку", "Открыть заметку", "Назад"))

        when(indexMenu) {
            0 -> showNotesList(archive)
            1 -> createNote(archive)
            2 -> removeNote(archive)
            3 -> openNote(archive)
            4 -> return
        }
    }
}

/** Список заметок */
fun showNotesList(archive: Archive) {
    if(archive.notesList.size == 0) {
        println("Список пуст")
    } else {
        for((index, note) in archive.notesList.withIndex()) {
            println("${index + 1}. ${note.title}")
        }
    }
}

/** Создание заметки */
fun createNote(archive: Archive) {
    var title = ""
    var text = ""

    // Ввод имени
    while(true) {
        println("Введите название заметки")

        val titleNote = Scanner(System.`in`).nextLine().trim()

        if (titleNote.isEmpty()) {
            println("Название не должно быть пустым")
        } else if(titleNote.length > MAX_SIZE_NOTE_TITLE) {
            println("Название должно быть менее $MAX_SIZE_NOTE_TITLE символов")
        } else {
            title = titleNote
            break
        }
    }

    while (true) {
        println("Введите текст заметки")

        val textNote = Scanner(System.`in`).nextLine().trim()

        if (textNote.isEmpty()) {
            println("Заметка не должна быть пустой")
        } else {
            text = textNote
            break
        }
    }

    archive.notesList.add(Note(title, text))
}

/** Удаление заметки */
fun removeNote(archive: Archive) {
    if(archive.notesList.size == 0) {
        println("Список пуст. Нечего удалять")
        return
    }

    println("Введите номер заметки для удаления")

    val scanner = Scanner(System.`in`)
    val noteIndex = getIntScanner(scanner) - 1

    if (isArrayItem(archive.notesList, noteIndex)) {
        archive.notesList.removeAt(noteIndex)
    } else {
        println("Заметка не найдена")
    }
}

/** Открытие заметки */
fun openNote(archive: Archive) {
    if(archive.notesList.size == 0) {
        println("Список пуст")
        return
    }

    println("Введите номер заметки для открытия")

    val scanner = Scanner(System.`in`)
    val noteIndex = getIntScanner(scanner) - 1

    if (isArrayItem(archive.notesList, noteIndex)) {
        val note = archive.notesList[noteIndex]


        println("==========\n ${note.title}\n=====")
        println(note.text)
        println("==========")
    } else {
        println("Заметка не найдена")
    }
}